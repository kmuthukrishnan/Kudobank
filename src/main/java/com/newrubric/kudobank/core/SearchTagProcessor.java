package com.newrubric.kudobank.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newrubric.kudobank.configuration.KudoBankConfiguration;
import com.newrubric.kudobank.dao.ILcsaDAO;
import com.newrubric.kudobank.dao.ITopicDAO;
import com.newrubric.kudobank.object.Lcsa;
import com.newrubric.kudobank.object.SearchTagEntity;
import com.newrubric.kudobank.object.TopicConcepts;
import com.newrubric.kudobank.resources.SearchTag;

public class SearchTagProcessor {
	private KudoBankConfiguration configuration;
	private static final Logger logger = LoggerFactory.getLogger(SearchTag.class);

	private SessionFactory factory = null;
	
	private ITopicDAO topicDAO;
	private ILcsaDAO lcsaDAO;
	
	public SearchTagProcessor(KudoBankConfiguration configuration,SessionFactory factory,ITopicDAO itopicDAO,ILcsaDAO ilcsaDAO ) {		
		this.configuration = configuration;
		this.factory = factory;
		this.topicDAO = itopicDAO;
		this.lcsaDAO = ilcsaDAO;
	}
	
	public Lcsa saveLcsaToFirebase(String lcsaId) throws JsonProcessingException{
		Lcsa lcsa = lcsaDAO.getLcsaById(lcsaId);
		ObjectMapper mapper = new ObjectMapper();
		String lcsaFireBase = mapper.writeValueAsString(lcsa);
		
		return lcsa;
	}
	
	public List<SearchTagEntity>  saveConceptsToFirebase(String topicId) throws JsonProcessingException{
		TopicConcepts topicConcepts = topicDAO.getConceptsForId(topicId);
		Set<String> conceptSet= topicConcepts.getConceptSet();
		List<SearchTagEntity> entities = new ArrayList<SearchTagEntity>();
		if((null!=conceptSet)&&(!conceptSet.isEmpty())){
			entities = makeSearchTagEntities(conceptSet, topicConcepts);
		}
		ObjectMapper mapper = new ObjectMapper();
		String entitiesFireBase = mapper.writeValueAsString(entities);
		
		return entities;
	}
	
	private List<SearchTagEntity> makeSearchTagEntities(Set<String> conceptSet,TopicConcepts topicConcepts){

		List<SearchTagEntity> list = new ArrayList<SearchTagEntity>();
		for (String value : conceptSet) {
			SearchTagEntity entity = new SearchTagEntity();
			entity.setTagDisplayValue(value);
			entity.setTagSubject(topicConcepts.getSubject());
			entity.setTagType("CONCEPTS");
			entity.setTagValue(value);
			list.add(entity);
		}
		return list;
	}
}
