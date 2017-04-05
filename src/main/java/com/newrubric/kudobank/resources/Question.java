package com.newrubric.kudobank.resources;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.google.cloud.storage.Storage;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.newrubric.kudobank.configuration.KudoBankConfiguration;
import com.newrubric.kudobank.core.LAQuestionProcessor;
import com.newrubric.kudobank.core.MCQuestionProcessor;
import com.newrubric.kudobank.core.RCQuestionProcessor;
import com.newrubric.kudobank.core.SAQuestionProcessor;
import com.newrubric.kudobank.core.VSAQuestionProcessor;
import com.newrubric.kudobank.dao.ILcsaDAO;
import com.newrubric.kudobank.dao.IQnImageDao;
import com.newrubric.kudobank.dao.IQuestionsDao;
import com.newrubric.kudobank.dao.ITopicDAO;

import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.servlets.assets.ResourceNotFoundException;

@Path("/api/v1/question")
@Produces("application/json")
public class Question {

	private KudoBankConfiguration configuration;
	private static final Logger logger = LoggerFactory.getLogger(Question.class);

	private SessionFactory factory = null;

	private ITopicDAO topicDAO;
	private ILcsaDAO lcsaDAO;
	private IQuestionsDao mcqDAO;
	private IQnImageDao qnImageDao ;
	private DatabaseReference fbDBRef ;
	private Storage fbStorage;
	private FirebaseDatabase firebaseDatabase ;
	public Question(FirebaseDatabase defaultDatabase, DatabaseReference fbDBRef,Storage firebaseGoogleCloudStorage, KudoBankConfiguration configuration,SessionFactory factory,ITopicDAO itopicDAO,ILcsaDAO ilcsaDAO,IQuestionsDao imcqDAO, IQnImageDao qnImageDao ) {		
		this.configuration = configuration;
		this.factory = factory;
		this.topicDAO = itopicDAO;
		this.lcsaDAO = ilcsaDAO;
		this.mcqDAO = imcqDAO;
		this.qnImageDao = qnImageDao;
		this.fbDBRef = fbDBRef;
		this.fbStorage = firebaseGoogleCloudStorage;
		this.firebaseDatabase = defaultDatabase;
	}


	@POST
	@Path("/{type}/{id}")
	@Timed
	@UnitOfWork
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	public Response pushQuestionToFirebase(@PathParam("type") String type,@PathParam("id") String id)
			throws ResourceNotFoundException, IOException {
		
		Response response = Response.status(400).build();
		
		if("MCQ".equalsIgnoreCase(type.trim())){
			response = pushMCQ(id);			
		}
		if("VSA".equalsIgnoreCase(type.trim())){
			response = pushVSA(id);			
		}
		if("SA".equalsIgnoreCase(type.trim())){
			response = pushSA(id);			
		}
		if("LA".equalsIgnoreCase(type.trim())){
			response = pushLA(id);			
		}
		if("RC".equalsIgnoreCase(type.trim())){
			response = pushRC(id);			
		}		
		return response;		
	}	
	
	private Response pushMCQ(String id) throws IOException{
		MCQuestionProcessor processor = new MCQuestionProcessor(this.firebaseDatabase,this.fbDBRef,this.fbStorage,configuration, factory, topicDAO, lcsaDAO, mcqDAO,this.qnImageDao);
		Response response = processor.pushMCQ(id);		
		return response;
	}
	
	private Response pushVSA(String id) throws IOException{
		VSAQuestionProcessor processor = new VSAQuestionProcessor(this.firebaseDatabase,this.fbDBRef,this.fbStorage,configuration, factory, topicDAO, lcsaDAO,this.qnImageDao, mcqDAO);
		Response response = processor.pushVSA(id);	
		return response;
	}
	
	private Response pushSA(String id) throws IOException{
		SAQuestionProcessor processor = new SAQuestionProcessor(this.firebaseDatabase,this.fbDBRef,this.fbStorage,configuration, factory, topicDAO, lcsaDAO,this.qnImageDao, mcqDAO);
		Response response = processor.pushSA(id);	
		return response;
	}	
	
	private Response pushLA(String id) throws IOException{
		LAQuestionProcessor processor = new LAQuestionProcessor(this.firebaseDatabase,this.fbDBRef,this.fbStorage,configuration, factory, topicDAO, lcsaDAO,this.qnImageDao, mcqDAO);
		Response response = processor.pushLA(id);	
		return response;
	}
	
	private Response pushRC(String id) throws IOException{
		RCQuestionProcessor processor = new RCQuestionProcessor(this.firebaseDatabase,this.fbDBRef,this.fbStorage,configuration, factory, topicDAO, lcsaDAO,this.qnImageDao, mcqDAO);
		Response response = processor.pushRC(id);	
		return response;
	}		
}
