package com.newrubric.kudobank.core;

import java.io.FileNotFoundException;
import java.io.IOException;
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
import com.newrubric.kudobank.model.QuestionOpenEnded;
import com.newrubric.kudobank.object.Lcsa;
import com.newrubric.kudobank.object.QuestionImage;
import com.newrubric.kudobank.object.SaQuestion;
import com.newrubric.kudobank.object.Topic;

public class SAQuestionProcessor extends BaseQuestionProcessor {
	private static final Logger logger = LoggerFactory.getLogger(SAQuestionProcessor.class);
	// private SessionFactory factory = null;
	private IQuestionsDao questionsDAO;
	
	public SAQuestionProcessor(FirebaseDatabase firebaseDatabase, DatabaseReference fbDBRef, Storage fbStorage, KudoBankConfiguration configuration,
			SessionFactory factory, ITopicDAO itopicDAO, ILcsaDAO ilcsaDAO, IQnImageDao qnImageDao,
			IQuestionsDao iQnDAO) {
		super(firebaseDatabase,fbDBRef, fbStorage, configuration, factory, itopicDAO, ilcsaDAO, qnImageDao, iQnDAO);
		this.questionsDAO = iQnDAO;
	}

	public Response pushSA(String id) throws IOException {
		Response response = pushSaToFirebase(id);
		return response;
	}

	public SaQuestion getSA(String questionId) {
		SaQuestion vsaQuestion = this.questionsDAO.getQuestionSAById(questionId);
		return vsaQuestion;
	}	
	private Response pushSaToFirebase(String questionId) throws IOException {
		QuestionOpenEnded question = processQuestion(questionId);
		saveObjectInFirebase(questionId, question);
		return Response.ok().entity(question).build();
	}
	public QuestionOpenEnded processQuestion(String questionId) throws IOException{
		Map<QuestionImage, String> mapImages = saveQuestionImageToFireBase(questionId);
		QuestionOpenEnded question = getQuestionOpenEndedForFireBase(questionId);
		setQuestionImageURL(question, mapImages);		
		return question;
	}
	

	private QuestionOpenEnded getQuestionOpenEndedForFireBase(String questionId) throws FileNotFoundException, IOException {
		SaQuestion question = this.questionsDAO.getQuestionSAById(questionId);
		
		Topic topic = this.topicDAO.getTopicId(question.getNrTopicId());
		Lcsa lcsa = this.lcsaDAO.getLcsaById(question.getNrLcsaId());
		QuestionOpenEnded questionOpenEnded  =new QuestionOpenEnded();
		prepareQuestionOpenEnded(questionOpenEnded,question, topic, lcsa);	
		return questionOpenEnded;
	}


	private void prepareQuestionOpenEnded(QuestionOpenEnded result  ,SaQuestion question, Topic topic, Lcsa lcsa) throws FileNotFoundException, IOException {		
		prepareBaseQuestion(result, question,topic, lcsa,"questionOpenEnded");
		/*
		List<QuestionAnswerOption> qnAnswerOptions = new ArrayList<QuestionAnswerOption>();
		QuestionAnswerOption qnAnswer = new QuestionAnswerOption();
		qnAnswer.setOptionNumber(question.getCorrectOption());
		qnAnswer.setText(question.getCorrectOption());
		qnAnswerOptions.add(qnAnswer);
		
		result.setCorrectAnswer(qnAnswerOptions);
		*/
		return ;
	}	
}
