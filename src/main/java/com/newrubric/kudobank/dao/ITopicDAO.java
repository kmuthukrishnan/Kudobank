package com.newrubric.kudobank.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.newrubric.kudobank.mapper.TopicConceptMapper;
import com.newrubric.kudobank.mapper.TopicMapper;
import com.newrubric.kudobank.object.Topic;
import com.newrubric.kudobank.object.TopicConcepts;

public interface ITopicDAO {
	@SqlQuery("select * from nr_topic where is_active = 1 and is_deleted = 0  ;")
	@Mapper(TopicMapper.class)
	public List<Topic> getAllTopics();

	@SqlQuery("select * from nr_topic where nr_topic_id = :topicId and is_active = 1 and is_deleted = 0  ;")
	@Mapper(TopicMapper.class)
	public Topic getTopicId(@Bind("topicId")  String topicId);
	
	@SqlQuery("select distinct concepts_included_1,concepts_included_2,concepts_included_3,concepts_included_4,concepts_included_5,concepts_included_6,concepts_included_7,concepts_included_8,concepts_included_9,concepts_included_10,subject_applicable_1 from nr_topic where is_active = 1 and is_deleted = 0;")
	@Mapper(TopicConceptMapper.class)
	public List<TopicConcepts> getAllConcepts();
	
	@SqlQuery("select distinct concepts_included_1,concepts_included_2,concepts_included_3,concepts_included_4,concepts_included_5,concepts_included_6,concepts_included_7,concepts_included_8,concepts_included_9,concepts_included_10, subject_applicable_1 from nr_topic where nr_topic_id = :topicId and is_active = 1 and is_deleted = 0;")
	@Mapper(TopicConceptMapper.class)
	public TopicConcepts getConceptsForId(@Bind("topicId")  String topicId);	
}
