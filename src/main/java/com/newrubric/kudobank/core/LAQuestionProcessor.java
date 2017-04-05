package com.newrubric.kudobank.core;

import java.io.FileNotFoundException;
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
import com.newrubric.kudobank.model.QuestionOpenEndedWithKey;
import com.newrubric.kudobank.object.AnswerKey;
import com.newrubric.kudobank.object.LaQuestion;
import com.newrubric.kudobank.object.Lcsa;
import com.newrubric.kudobank.object.QnEvaluationKey;
import com.newrubric.kudobank.object.QuestionImage;
import com.newrubric.kudobank.object.Topic;

public class LAQuestionProcessor extends BaseQuestionProcessor {
	private static final Logger logger = LoggerFactory.getLogger(LAQuestionProcessor.class);
	// private SessionFactory factory = null;
	private IQuestionsDao questionsDAO;
	
	public LAQuestionProcessor(FirebaseDatabase firebaseDatabase, DatabaseReference fbDBRef, Storage fbStorage, KudoBankConfiguration configuration,
			SessionFactory factory, ITopicDAO itopicDAO, ILcsaDAO ilcsaDAO, IQnImageDao qnImageDao,
			IQuestionsDao iQnDAO) {
		super(firebaseDatabase,fbDBRef, fbStorage, configuration, factory, itopicDAO, ilcsaDAO, qnImageDao, iQnDAO);
		this.questionsDAO = iQnDAO;
	}

	public Response pushLA(String id) throws IOException {
		Response response = pushLaToFirebase(id);
		return response;
	}

	public LaQuestion getLA(String questionId) {
		LaQuestion vsaQuestion = this.questionsDAO.getQuestionLAById(questionId);
		return vsaQuestion;
	}	
	

	private Response pushLaToFirebase(String questionId) throws IOException {
		QuestionOpenEndedWithKey question = processQuestion(questionId);
		saveObjectInFirebase(questionId, question);
		return Response.ok().entity(question).build();
	}
	
	public QuestionOpenEndedWithKey processQuestion(String questionId) throws IOException{
		Map<QuestionImage, String> mapImages = saveQuestionImageToFireBase(questionId);
		QuestionOpenEndedWithKey question = getQuestionOpenEndedForFireBase(questionId);
		setQuestionImageURL(question, mapImages);		
		return question;
	}
	public QuestionOpenEndedWithKey getQuestionOpenEndedForFireBase(String questionId) throws FileNotFoundException, IOException {
		LaQuestion question = this.questionsDAO.getQuestionLAById(questionId);
		
		Topic topic = this.topicDAO.getTopicId(question.getNrTopicId());
		Lcsa lcsa = this.lcsaDAO.getLcsaById(question.getNrLcsaId());
		QuestionOpenEndedWithKey questionOpenEnded  =new QuestionOpenEndedWithKey();
		prepareQuestionOpenEnded(questionOpenEnded,question, topic, lcsa);	
		return questionOpenEnded;
	}


	private void prepareQuestionOpenEnded(QuestionOpenEndedWithKey result  ,LaQuestion question, Topic topic, Lcsa lcsa) throws FileNotFoundException, IOException {		
		prepareBaseQuestion(result,question, topic, lcsa,"questionOpenEndedKey");
		
		List<QnEvaluationKey> qnEvaluationKeys= this.questionsDAO.getQuestionEvaluationKeyId(question.getNrQuestionId());
		List<AnswerKey> answerKeys = new ArrayList<AnswerKey>();
		if(null != qnEvaluationKeys){
			for (QnEvaluationKey qnEvaluationKey : qnEvaluationKeys) {
				AnswerKey answerKey = new AnswerKey();
				setAnswerKey(qnEvaluationKey, answerKey);
				answerKeys.add(answerKey);
			}
		}
		result.setCorrectAnswer(answerKeys);
		return ;
	}	
	
	private void setAnswerKey(QnEvaluationKey qnEvaluationKey,AnswerKey answerKey){
		answerKey.setKeyImage("");
		answerKey.setKeyMarks(qnEvaluationKey.getEvalKeyMarks());
		answerKey.setKeyOrderNumber(qnEvaluationKey.getEvalKeySeq());
		answerKey.setKeyValue(qnEvaluationKey.getEvalKeyTypeDisplayName());
		answerKey.setKeyType(qnEvaluationKey.getEvalKeyType());
	}
}
