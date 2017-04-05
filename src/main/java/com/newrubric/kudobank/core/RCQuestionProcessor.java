package com.newrubric.kudobank.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.newrubric.kudobank.model.BaseQuestionModel;
import com.newrubric.kudobank.model.QuestionMultiPart;
import com.newrubric.kudobank.object.Lcsa;
import com.newrubric.kudobank.object.QuestionImage;
import com.newrubric.kudobank.object.RCQuestion;
import com.newrubric.kudobank.object.RcQuestionMap;
import com.newrubric.kudobank.object.Topic;

public class RCQuestionProcessor extends BaseQuestionProcessor {
	private static final Logger logger = LoggerFactory.getLogger(LAQuestionProcessor.class);
	// private SessionFactory factory = null;
	private IQuestionsDao questionsDAO;

	public RCQuestionProcessor(FirebaseDatabase firebaseDatabase, DatabaseReference fbDBRef, Storage fbStorage, KudoBankConfiguration configuration,
			SessionFactory factory, ITopicDAO itopicDAO, ILcsaDAO ilcsaDAO, IQnImageDao qnImageDao,
			IQuestionsDao iQnDAO) {
		super(firebaseDatabase,fbDBRef, fbStorage, configuration, factory, itopicDAO, ilcsaDAO, qnImageDao, iQnDAO);
		this.questionsDAO = iQnDAO;
	}


	public RCQuestion getRC(String questionId) {
		RCQuestion vsaQuestion = this.questionsDAO.getQuestionRCById(questionId);
		return vsaQuestion;
	}	
	
	public Response pushRC(String id) throws IOException {
		Response response = pushRCToFirebase(id);
		return response;
	}

	private Response pushRCToFirebase(String questionId) throws IOException {
		QuestionMultiPart question = processQuestion(questionId);
		saveObjectInFirebase(questionId, question);
		return Response.ok().entity(question).build();
	}


	private QuestionMultiPart processQuestion(String questionId) throws IOException {
		Map<QuestionImage, String> mapImages = saveQuestionImageToFireBase(questionId);
		QuestionMultiPart question = getQuestionOpenEndedForFireBase(questionId);
		setQuestionImageURL(question, mapImages);		
		return question;	
	}


	public QuestionMultiPart getQuestionOpenEndedForFireBase(String questionId) throws IOException {
		RCQuestion question = this.questionsDAO.getQuestionRCById(questionId);
		
		Topic topic = this.topicDAO.getTopicId(question.getNrTopicId());
		Lcsa lcsa = this.lcsaDAO.getLcsaById(question.getNrLcsaId());
		QuestionMultiPart questionOpenEnded  =new QuestionMultiPart();
		prepareQuestionMultiPart(questionOpenEnded,question, topic, lcsa);	
		return questionOpenEnded;
	}


	private void prepareQuestionMultiPart(QuestionMultiPart result, RCQuestion question, Topic topic,Lcsa lcsa) throws IOException {
		MCQuestionProcessor mcqProcesspr = new MCQuestionProcessor(this.firebaseDatabase,fbDBRef, fbStorage, configuration, factory, this.topicDAO, this.lcsaDAO, this.questionDAO, qnImageDao);
		VSAQuestionProcessor vsaProcessor = new VSAQuestionProcessor(this.firebaseDatabase,fbDBRef, fbStorage, configuration, factory, this.topicDAO, this.lcsaDAO, qnImageDao, this.questionDAO);
		SAQuestionProcessor saProcessor = new SAQuestionProcessor(this.firebaseDatabase,fbDBRef, fbStorage, configuration, factory, this.topicDAO, this.lcsaDAO, qnImageDao, this.questionDAO);
		LAQuestionProcessor laProcessor = new LAQuestionProcessor(this.firebaseDatabase,fbDBRef, fbStorage, configuration, factory, this.topicDAO, this.lcsaDAO, qnImageDao, this.questionDAO);
		
		prepareBaseQuestion(result,question, topic, lcsa,"questionMultiPart");
		List<RcQuestionMap> rcComponents = this.questionDAO.getRCComponentQuestions(question.getNrQuestionId());
		if((null == rcComponents)||(rcComponents.isEmpty())){
			return;
		}
		int itemCount = rcComponents.size();
//		Object[] components = new Object[itemCount];
		List<BaseQuestionModel> components = new ArrayList<BaseQuestionModel>();
		
		for (int i = 0; i < itemCount ; i++) {
			RcQuestionMap component = rcComponents.get(i);
			if("MCQ".equalsIgnoreCase(component.getQuestionType())){
//				components[i] = mcqProcesspr.getMCQForFireBase(component.getNrQuestionId());
				components.add(mcqProcesspr.getMCQForFireBase(component.getNrQuestionId()));
			}
			
			if("VSA".equalsIgnoreCase(component.getQuestionType())){
//				components[i] = vsaProcessor.processQuestion(component.getNrQuestionId());
				components.add(vsaProcessor.processQuestion(component.getNrQuestionId()));
			}
			
			if("SA".equalsIgnoreCase(component.getQuestionType())){
//				components[i] = saProcessor.processQuestion(component.getNrQuestionId());
				components.add(saProcessor.processQuestion(component.getNrQuestionId()));
			}
			if("LA".equalsIgnoreCase(component.getQuestionType())){
//				components[i] = laProcessor.processQuestion(component.getNrQuestionId());
				components.add(laProcessor.processQuestion(component.getNrQuestionId()));
			}			
		}
		result.setQuestions(components);
		return ;
		
	}

		
}
