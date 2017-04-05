package com.newrubric.kudobank.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Response;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.cloud.storage.Storage;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.newrubric.kudobank.configuration.KudoBankConfiguration;
import com.newrubric.kudobank.dao.ILcsaDAO;
import com.newrubric.kudobank.dao.IQnImageDao;
import com.newrubric.kudobank.dao.IQuestionsDao;
import com.newrubric.kudobank.dao.ITopicDAO;
import com.newrubric.kudobank.model.QuestionMCQ;
import com.newrubric.kudobank.model.QuestionMCQImage;
import com.newrubric.kudobank.object.AnswerOptions;
import com.newrubric.kudobank.object.Lcsa;
import com.newrubric.kudobank.object.McqQuestion;
import com.newrubric.kudobank.object.QnAnswerImageOption;
import com.newrubric.kudobank.object.QuestionAnswerOption;
import com.newrubric.kudobank.object.QuestionImage;
import com.newrubric.kudobank.object.Topic;

public class MCQuestionProcessor extends BaseQuestionProcessor{
	private static final Logger logger = LoggerFactory.getLogger(MCQuestionProcessor.class);
	private IQuestionsDao questionsDAO;


	public MCQuestionProcessor(FirebaseDatabase firebaseDatabase, DatabaseReference fbDBRef, Storage fbStorage, KudoBankConfiguration configuration,SessionFactory factory,ITopicDAO itopicDAO,ILcsaDAO ilcsaDAO,IQuestionsDao imcqDAO, IQnImageDao qnImageDao ) {		
		super(firebaseDatabase,fbDBRef, fbStorage, configuration, factory, itopicDAO, ilcsaDAO,  qnImageDao,imcqDAO);
		this.questionsDAO = imcqDAO;
	}
	
	public Response pushMCQ(String id) throws IOException{
		
		McqQuestion qn = getMCQ(id);
		Response response = null;
		switch (qn.getOptionImageExists()) {
		case 0:				
			response = pushMCQWithoutAnswerImages( id);
			break;
		case 1:
			response = pushMCQWitAnswerImages( id);
			break;
		default:
			response = Response.status(400).build();
			break;
		}
		return response;
	}
	
	private Response pushMCQWithoutAnswerImages(String questionId) throws IOException{
		QuestionMCQ questionMCQ = processMCQWithoutAnswerImages(questionId);
		saveObjectInFirebase(questionId, questionMCQ);
		return Response.ok().entity(questionMCQ).build();
	}
	
	private QuestionMCQ processMCQWithoutAnswerImages(String questionId) throws IOException{
		Map<QuestionImage, String> mapImages = saveQuestionImageToFireBase(questionId);
		QuestionMCQ questionMCQ = getMCQForFireBase(questionId);		
		setQuestionImageURL(questionMCQ, mapImages);		
		return questionMCQ;
	}

	private Response pushMCQWitAnswerImages(String questionId) throws IOException{
		QuestionMCQImage questionMCQ = processMCQWithAnswerImages(questionId);
		saveObjectInFirebase(questionId, questionMCQ);
		return Response.ok().entity(questionMCQ).build();
	}
	
	private QuestionMCQImage processMCQWithAnswerImages(String questionId) throws IOException{
		Map<QuestionImage, String> mapImages = saveQuestionImageToFireBase(questionId);
		QuestionMCQImage questionMcqImage = getMCQWithImageForFireBase(questionId);
		List<QnAnswerImageOption> answerImages = new ArrayList<QnAnswerImageOption>();
		if((null != mapImages) && (!mapImages.isEmpty())){
			Set<QuestionImage> keys= mapImages.keySet();
			for (QuestionImage questionImage : keys) {
				String url = mapImages.get(questionImage);
				
				if(questionImage.getIsQuestionImage() == 1){						
					questionMcqImage.setQuestionImagesUrl(url);
					
				}else{
					QnAnswerImageOption answerOptions  = new QnAnswerImageOption();
					answerOptions.setOrder(questionImage.getImageOrder());
					answerOptions.setUrl(url);
					answerImages.add(answerOptions);
				}
			}
		}		
		questionMcqImage.setAnswerImages(answerImages);
		return questionMcqImage;
	}

	
	public McqQuestion getMCQ(String questionId){
		McqQuestion mcQuestion = this.questionsDAO.getQuestionMCQById(questionId);
		return mcQuestion;
	}
	
	public QuestionMCQ getMCQForFireBase(String questionId) throws FileNotFoundException, IOException{
		McqQuestion mcQuestion = this.questionsDAO.getQuestionMCQById(questionId);
		//mcQuestion.getOptionImageExists();
		Topic topic = this.topicDAO.getTopicId(mcQuestion.getNrTopicId());
		Lcsa lcsa = this.lcsaDAO.getLcsaById(mcQuestion.getNrLcsaId());
		QuestionMCQ questionMCQ =null;
		questionMCQ = prepareQuestionMCQ(mcQuestion, topic, lcsa);		
		return questionMCQ;
	}
	
	
	public QuestionMCQImage getMCQWithImageForFireBase(String questionId) throws FileNotFoundException, IOException{
		McqQuestion mcQuestion = this.questionsDAO.getQuestionMCQImageById(questionId);
		Topic topic = this.topicDAO.getTopicId(mcQuestion.getNrTopicId());
		Lcsa lcsa = this.lcsaDAO.getLcsaById(mcQuestion.getNrLcsaId());
		QuestionMCQImage questionMcqImage = prepareQuestionMCQImage(mcQuestion, topic, lcsa);
		return questionMcqImage;
	}
	
	
	
	private QuestionMCQ prepareQuestionMCQ(McqQuestion mcQuestion,Topic topic ,Lcsa lcsa ) throws FileNotFoundException, IOException{
		QuestionMCQ result = new QuestionMCQ();
		prepareBaseQuestion(result,mcQuestion, topic, lcsa,"questionMCQ");
		
		AnswerOptions answerOptions  = new AnswerOptions();
		answerOptions.setOption1(mcQuestion.getMcqOption1());
		answerOptions.setOption2(mcQuestion.getMcqOption2());
		answerOptions.setOption3(mcQuestion.getMcqOption3());
		answerOptions.setOption4(mcQuestion.getMcqOption4());
		
		List<QuestionAnswerOption> qnAnswerOptions = new ArrayList<QuestionAnswerOption>();
		QuestionAnswerOption qnAnswer = new QuestionAnswerOption();
		qnAnswer.setOptionNumber(mcQuestion.getCorrectOption());
		qnAnswer.setText(getOptionText(mcQuestion.getCorrectOption(), mcQuestion));
		qnAnswerOptions.add(qnAnswer);
		result.setAnswerOptions(answerOptions);
		result.setCorrectAnswer(qnAnswerOptions);

         //Krithika
		result.setQuestionMarks(1);		
		return result;
	}
	
	private QuestionMCQImage prepareQuestionMCQImage(McqQuestion mcQuestion,Topic topic ,Lcsa lcsa ) throws FileNotFoundException, IOException{
		QuestionMCQImage result = new QuestionMCQImage();
		prepareBaseQuestion(result,mcQuestion, topic, lcsa,"questionMCQImage");
		List<QnAnswerImageOption> answerImages = new ArrayList<QnAnswerImageOption>(); 
		QnAnswerImageOption answerOptions  = new QnAnswerImageOption();
		answerOptions.setOrder(1);
		// answerOptions.setUrl("http://www.gritfx.com/FREE_photos/0048.JPG");
		answerImages.add(answerOptions);
				
		List<QuestionAnswerOption> qnAnswerOptions = new ArrayList<QuestionAnswerOption>();
		QuestionAnswerOption qnAnswer = new QuestionAnswerOption();
		qnAnswer.setOptionNumber(mcQuestion.getCorrectOption());
		qnAnswer.setText(getOptionText(mcQuestion.getCorrectOption(), mcQuestion));
		qnAnswerOptions.add(qnAnswer);
				
		result.setAnswerImages(answerImages);
		result.setCorrectAnswer(qnAnswerOptions);
		
		return result;
	}
		
	private String getOptionText(String correctOption, McqQuestion mcQuestion){
		String answer = "";
	
		if(correctOption.trim().equalsIgnoreCase("a")){
			answer = mcQuestion.getMcqOption1();
		}

		if(correctOption.trim().equalsIgnoreCase("b")){
			answer = mcQuestion.getMcqOption2();
		}
		
		if(correctOption.trim().equalsIgnoreCase("c")){
			answer = mcQuestion.getMcqOption3();
		}
		if(correctOption.trim().equalsIgnoreCase("d")){
			answer = mcQuestion.getMcqOption4();
		}		
		return answer;
	}

}
