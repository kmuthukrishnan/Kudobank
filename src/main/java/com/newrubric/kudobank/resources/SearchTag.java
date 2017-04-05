package com.newrubric.kudobank.resources;

import java.util.List;

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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.newrubric.kudobank.configuration.KudoBankConfiguration;
import com.newrubric.kudobank.core.SearchTagProcessor;
import com.newrubric.kudobank.dao.ILcsaDAO;
import com.newrubric.kudobank.dao.IQuestionsDao;
import com.newrubric.kudobank.dao.ITopicDAO;
import com.newrubric.kudobank.object.Lcsa;
import com.newrubric.kudobank.object.SearchTagEntity;
import com.newrubric.kudobank.object.Tag;

import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.servlets.assets.ResourceNotFoundException;

@Path("/api/v1/searchtag")
@Produces("application/json")
public class SearchTag {

	private KudoBankConfiguration configuration;
	private static final Logger logger = LoggerFactory.getLogger(SearchTag.class);

	private SessionFactory factory = null;

	private ITopicDAO topicDAO;
	private ILcsaDAO lcsaDAO;
	private IQuestionsDao mcqDAO;
	private DatabaseReference fbDBRef ;
	
	public SearchTag(FirebaseDatabase defaultDatabase, DatabaseReference fbDBRef, KudoBankConfiguration configuration,SessionFactory factory,ITopicDAO itopicDAO,ILcsaDAO ilcsaDAO,IQuestionsDao imcqDAO ) {		
		this.configuration = configuration;
		this.factory = factory;
		this.topicDAO = itopicDAO;
		this.lcsaDAO = ilcsaDAO;
		this.mcqDAO = imcqDAO;	
		this.fbDBRef = fbDBRef;
	}

	/**
	 * Read the given type from NR DB and update to Firebase. All concepts for the topic are saved.
	 *   Type: LCSA/TOPIC/CONCEPT
	 *   id : nr_lcsa_id/nr_topic_id/nr_topic_id
	 *   
	 * @param centerId
	 * @param studentCode
	 * @param studentReqObject
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws JsonProcessingException 
	 */
	@POST
	@Path("/{type}/{id}")
	@Timed
	@UnitOfWork
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	public Response addStudent(@PathParam("type") String type,@PathParam("id") String id)
			throws ResourceNotFoundException, JsonProcessingException {
		
		SearchTagProcessor processor = new SearchTagProcessor(configuration, factory, topicDAO, lcsaDAO);
		ObjectMapper mapper = new ObjectMapper();
		if("concepts".equalsIgnoreCase(type.trim())){
			List<SearchTagEntity> tags = processor.saveConceptsToFirebase(id);
			String tagJson = mapper.writeValueAsString(tags);
			saveInFirebaseConcepts(id, tagJson,tags);
			return Response.ok().entity(tags).build();
		}else if("LCSA".equalsIgnoreCase(type.trim())){
			Lcsa lcsa = processor.saveLcsaToFirebase(id);
			String tagJson = mapper.writeValueAsString(lcsa);
			saveInFirebaseLcsa(id, tagJson,lcsa);
			return Response.ok().entity(lcsa).build();
		}
		return Response.status(400).build();	
	}		
	private void saveInFirebaseConcepts(String id, String searchTagJson, List<SearchTagEntity> tags){
		for (SearchTagEntity searchTagEntity : tags) {
			this.fbDBRef.push().setValue(searchTagEntity, new DatabaseReference.CompletionListener(){

				public void onComplete(DatabaseError databaseError, DatabaseReference dbRef) {
					   if (databaseError != null) {
				            System.out.println("Data could not be saved " + databaseError.getMessage());
				        } else {
				            System.out.println("Data saved successfully.");
				        }

					
				}
				
			});		
		}
	
	}
	private void saveInFirebaseLcsa(String id, String searchTagJson, Lcsa lcsa){
//		this.fbDBRef.push().setValue(searchTagJson);
		SearchTagEntity tag = new SearchTagEntity();
		tag.setTagDisplayValue(lcsa.getLcsaDisplayName());
		tag.setTagSubject(lcsa.getTagSubject());
		tag.setTagType("lcsa");
		tag.setTagValue(lcsa.getLcsaName());
		
		this.fbDBRef.push().setValue(tag, new DatabaseReference.CompletionListener(){

			public void onComplete(DatabaseError databaseError, DatabaseReference dbRef) {
				   if (databaseError != null) {
			            System.out.println("Data could not be saved " + databaseError.getMessage());
			        } else {
			            System.out.println("Data saved successfully.");
			        }

				
			}
			
		});
	}	
}
