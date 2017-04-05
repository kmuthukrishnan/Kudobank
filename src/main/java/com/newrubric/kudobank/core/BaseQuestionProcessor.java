package com.newrubric.kudobank.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.newrubric.kudobank.configuration.KudoBankConfiguration;
import com.newrubric.kudobank.dao.ILcsaDAO;
import com.newrubric.kudobank.dao.IQnImageDao;
import com.newrubric.kudobank.dao.IQuestionsDao;
import com.newrubric.kudobank.dao.ITopicDAO;
import com.newrubric.kudobank.model.BaseQuestionModel;
import com.newrubric.kudobank.object.BaseQuestionObject;
import com.newrubric.kudobank.object.GradeApplicability;
import com.newrubric.kudobank.object.HiddenTags;
import com.newrubric.kudobank.object.Lcsa;
import com.newrubric.kudobank.object.QnGrades;
import com.newrubric.kudobank.object.QuestionAuthor;
import com.newrubric.kudobank.object.QuestionImage;
import com.newrubric.kudobank.object.SubjectsApplicable;
import com.newrubric.kudobank.object.Tag;
import com.newrubric.kudobank.object.Topic;
import com.newrubric.kudobank.object.VisibleTags;
import com.newrubric.kudobank.util.KudoUtil;
//Apr 2 Krithika
import com.newrubric.kudobank.object.Status;


public abstract class BaseQuestionProcessor {
	 KudoBankConfiguration configuration;
	 static final Logger logger = LoggerFactory.getLogger(BaseQuestionProcessor.class);

	 SessionFactory factory = null;
	
	 ITopicDAO topicDAO;
	 ILcsaDAO lcsaDAO;
	 IQuestionsDao questionDAO;
	 IQnImageDao qnImageDao ;
	 DatabaseReference fbDBRef ;
	 Storage fbStorage;
	 FirebaseDatabase firebaseDatabase;
	 
	 DatabaseReference fbGradeSubjectDBRef ;
	public BaseQuestionProcessor(FirebaseDatabase firebaseDB,DatabaseReference fbDBRef, Storage fbStorage, KudoBankConfiguration configuration,SessionFactory factory,ITopicDAO itopicDAO,ILcsaDAO ilcsaDAO, IQnImageDao qnImageDao,IQuestionsDao iQnDAO ){
		this.configuration = configuration;
		this.factory = factory;
		this.topicDAO = itopicDAO;
		this.lcsaDAO = ilcsaDAO;
		this.questionDAO = iQnDAO;
		this.qnImageDao = qnImageDao;
		this.fbDBRef = fbDBRef;
		this.fbStorage = fbStorage;
		this.firebaseDatabase = firebaseDB;
		this.fbGradeSubjectDBRef =  firebaseDB.getReference("gsauthorqncount");
	}
	
	public void saveObjectInFirebase(String questionId,Object question){
		this.fbDBRef.push().setValue(question, new DatabaseReference.CompletionListener(){

			public void onComplete(DatabaseError databaseError, DatabaseReference dbRef) {
				   if (databaseError != null) {
			            System.out.println("Data could not be saved " + databaseError.getMessage());
			        } else {
			            System.out.println("Data saved successfully.");
			        }				
			}
			
		});
	}
	
	public void setQuestionImageURL(BaseQuestionModel question,Map<QuestionImage,String> mapImages ){
		if ((null != mapImages) && (!mapImages.isEmpty())) {
			Set<QuestionImage> keys = mapImages.keySet();
			for (QuestionImage questionImage : keys) {
				if (questionImage.getIsQuestionImage() == 1) {
					String url = mapImages.get(questionImage);
					question.setQuestionImagesUrl(url);
					break;
				}
			}
		}
	}
	public Map<QuestionImage,String> saveQuestionImageToFireBase(String questionId) throws IOException{
		List<QuestionImage> images = qnImageDao.getQnImagesByQnId(questionId);
		return saveQuestionImageToFireBase(images);
	}
	public Map<QuestionImage,String> saveQuestionImageToFireBase(List<QuestionImage>  images) throws IOException{
		
		Map<QuestionImage,String> map = new HashMap<QuestionImage,String>();
		for (QuestionImage questionImage : images) {
			String contentType = "image/jpeg";
			String extension = questionImage.getImageName().substring(questionImage.getImageName().lastIndexOf("."));
			String fileName = "";
			if(".jpeg".equalsIgnoreCase(extension.trim())){
				fileName = questionImage.getQuestionImageId()+".jpg";
			}else if(".jpg".equalsIgnoreCase(extension.trim())){
				fileName = questionImage.getQuestionImageId()+".jpg";
			}if(".png".equalsIgnoreCase(extension.trim())){
				fileName = questionImage.getQuestionImageId()+".png";
				contentType = "image/png";
			}
			
			String localFilePath = saveBinaryInLocalFileSystem(questionImage);
			
			Map<String,String> metadata = new HashMap<String,String>();
			metadata.put("Type", contentType);
			metadata.put("Content-Type", contentType);
			// Upload a local file to a new file to be created in your bucket.
		    InputStream uploadContent = new FileInputStream(new File(localFilePath));
		    BlobId blobId = BlobId.of(configuration.getFirebaseDB().trim(), "questionImages/"+fileName);

		    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(contentType).setMetadata(metadata).build();
		    
		    Blob zebraBlob = fbStorage.create(blobInfo, uploadContent);
		    
		    String url = zebraBlob.getMediaLink();
		    
		    
		    System.out.println(url);
		    
		    map.put(questionImage, url);
		}
		return map;
	}
	
	public String saveBinaryInLocalFileSystem(QuestionImage questionImage) throws IOException{
		String defaultFolder = configuration.getDefaultImageLocalFolder();
		File folder = new File(defaultFolder);
		if(!folder.exists()){
			folder.mkdirs();
		}
		String extension = questionImage.getImageName().substring(questionImage.getImageName().lastIndexOf("."));
		String fileName = "";
		if(".jpeg".equalsIgnoreCase(extension.trim())){
			fileName = questionImage.getQuestionImageId()+".jpg";
		}else if(".jpg".equalsIgnoreCase(extension.trim())){
			fileName = questionImage.getQuestionImageId()+".jpg";
		}if(".png".equalsIgnoreCase(extension.trim())){
			fileName = questionImage.getQuestionImageId()+".png";
		}
//		String filePath = defaultFolder+File.separator+fileName;
		System.out.println("temp file for qid "+questionImage.getQuestionId() +" is "+fileName +" extension "+extension);
		File tempFile = File.createTempFile(fileName, extension);
		FileOutputStream out = new FileOutputStream( tempFile );
		out.write( questionImage.getImage() );
	    out.close();
		return tempFile.getAbsolutePath();
	}
	
	public void prepareBaseQuestion(BaseQuestionModel result,BaseQuestionObject qnObject, Topic topic ,Lcsa lcsa,String type ) throws FileNotFoundException, IOException{
		String difficulty = KudoUtil.getDifficulty(result.getNrQuestionId());
		QuestionAuthor author = getQuestionAuthor(result, topic, lcsa, type);
		
		/*
		QuestionAuthor author = new QuestionAuthor();
		author.setFollowerNum(0);
		author.setUserImageUrl("http://www.gritfx.com/FREE_photos/0048.JPG");
		author.setUserLevel("Editor");
		author.setUserName("Alice Walker");
		*/
		
		QnGrades grades = new QnGrades();
		grades.setGrades(topic.getApplicableGrades());
		
		SubjectsApplicable subjectApplicable = new SubjectsApplicable();
		Set<String> subjectSet = new TreeSet<String>();
		if((topic.getSubjectApplicable1()!=null) &&(!topic.getSubjectApplicable1().trim().isEmpty())){
			subjectSet.add(topic.getSubjectApplicable1().trim());
		}
		if((topic.getSubjectApplicable2()!=null) &&(!topic.getSubjectApplicable2().trim().isEmpty())){
			subjectSet.add(topic.getSubjectApplicable2().trim());
		}		
		subjectApplicable.setSubjects(subjectSet);

		Status status = new Status();
		status.setCreated(true);
		// questionStatus.setQuestionStatus("created");
		
		
		VisibleTags visibleTags = new VisibleTags ();
		List<Tag> tagShown = new ArrayList<Tag>();
		
		Tag topicTag = new Tag();
		topicTag.setTagType("topic");
		topicTag.setValue(topic.getTopicDisplayName());
		tagShown.add(topicTag);
		
		Tag bloomTag = new Tag();
		bloomTag.setTagType("blooms");
		bloomTag.setValue(lcsa.getSuperskillName());
		tagShown.add(bloomTag);
		visibleTags.setTags(tagShown);
		
		HiddenTags hiddenTags = new HiddenTags ();
		List<Tag> tagHidden = new ArrayList<Tag>();
		Tag bloomSubskillTag = new Tag();
		bloomSubskillTag.setTagType("bloomSubskill");
		bloomSubskillTag.setValue(lcsa.getSubskillName());
		tagHidden.add(bloomSubskillTag);

		//Added Mar30 Krithika
		tagHidden.add(bloomTag);
		tagHidden.add(topicTag);
		// tagHidden.add(topic.getApplicableGrades());
		
		Tag contentUnitTag = new Tag();
		contentUnitTag.setTagType("contentUnit");
		contentUnitTag.setValue(topic.getContentUnit());
		tagHidden.add(contentUnitTag);
		
		Tag lcsaNameTag = new Tag();
		lcsaNameTag.setTagType("lcsaName");
		lcsaNameTag.setValue(lcsa.getLcsaDisplayName());
		tagHidden.add(lcsaNameTag);	
		
		Set<String> conceptSet = topic.getConceptSet();
		if(null!=conceptSet){
			for (String concept : conceptSet) {
				Tag conceptTag = new Tag();
				conceptTag.setTagType("concept");
				conceptTag.setValue(concept);
				tagHidden.add(conceptTag);	
			}
		}
		hiddenTags.setTags(tagHidden);
		
		result.setCreatedBy(author);
		result.setDifficultyLevel(difficulty);
		result.setFlagCount(0);
		result.setGrades(grades.getGrades());
		

		result.setNrQuestionId(qnObject.getNrQuestionId());
		result.setPathToCreateQuestionPage("/NR");
		// result.setQuestionImagesUrl(questionImagesurl);
//      result.setQuestionImagesUrl("http://www.gritfx.com/FREE_photos/0048.JPG");
		result.setQuestionText(qnObject.getQuestionText());
		result.setQuestionType(type);
		result.setQuestionViews(0);
		result.setSubjectApplicable(subjectApplicable.getSubjects());
		result.setUpvotes(0);
		result.setUsageCount(0);

		//Apr 2 Krithika added
		result.setReviewRequests(0);
		result.setReviewAccepts(0);
		result.setStarred(false);
		result.setStatus(status);


		result.setHiddenTags(hiddenTags.getTags());
		result.setVisibleTags(visibleTags.getTags());
	}
		
	private QuestionAuthor getQuestionAuthor(BaseQuestionModel result,Topic topic ,Lcsa lcsa,String type) throws FileNotFoundException, IOException{
		
		QuestionAuthor author = new QuestionAuthor();
		String subject = topic.getSubjectApplicable1();
		
		if((null == subject)||(subject.trim().isEmpty())){
			return author;
		}
		if(subject.contains("social")){
			subject  = "Science";
		}
		List<GradeApplicability> lGrades  = topic.getApplicableGrades();
		if((null == lGrades)||(lGrades.isEmpty())){
			return author;
		}		
		GradeApplicability grade = lGrades.get(0);
		String gradeId = grade.getId();
		String pathKey = gradeId+"_"+subject;
		Set<String> users  = KudoUtil.getUsersForGradeSubject(pathKey);
		if(null == users){
			return author;//IDENTIFY DEFAULT
		}
		int size  = users.size();
		Random random = new Random();		
		int randomUserIndex  = random.nextInt(size);
		String email = (String) users.toArray()[randomUserIndex];
		String userId = KudoUtil.getUserIdForEmail(email);
		
		/*
		fbGradeSubjectDBRef.child(pathKey).addChildEventListener(new ChildEventListener() {
			
			public void onChildRemoved(DataSnapshot snapshot) {
			}
			
			public void onChildMoved(DataSnapshot snapshot, String prevChildKey) {
			}
			
			public void onChildChanged(DataSnapshot snapshot, String prevChildKey) {
			}
			
			public void onChildAdded(DataSnapshot snapshot, String prevChildKey) {
				// TODO Auto-generated method stub
				String key  = snapshot.getKey();
				Object object = snapshot.getValue();
				
			}
			
			public void onCancelled(DatabaseError arg0) {
			}
		});
		*/
		author.setFollowerNum(KudoUtil.getUserFollowerForEmail(email));//author.setFollowerNum(0);
		author.setUserImageUrl(KudoUtil.getUserImageUrlForEmail(email));//author.setUserImageUrl("http://www.gritfx.com/FREE_photos/0048.JPG");
		author.setUserLevel(KudoUtil.getUserLevelForEmail(email));//author.setUserLevel("Editor");
		author.setUserName(KudoUtil.getUserNameForEmail(email));//author.setUserName("Alice Walker");
		return author;
	}
}
