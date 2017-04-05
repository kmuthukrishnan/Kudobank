package com.newrubric.kudobank.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.newrubric.kudobank.object.TopicConcepts;

public class TopicConceptMapper implements ResultSetMapper<TopicConcepts>  {
	public TopicConcepts map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
		TopicConcepts topicConcepts = new TopicConcepts();		
	
		topicConcepts.setConceptsIncluded1(rs.getString("concepts_included_1"));
		topicConcepts.setConceptsIncluded2(rs.getString("concepts_included_2"));
		topicConcepts.setConceptsIncluded3(rs.getString("concepts_included_3"));
		topicConcepts.setConceptsIncluded4(rs.getString("concepts_included_4"));
		topicConcepts.setConceptsIncluded5(rs.getString("concepts_included_5"));
		topicConcepts.setConceptsIncluded6(rs.getString("concepts_included_6"));
		topicConcepts.setConceptsIncluded7(rs.getString("concepts_included_7"));
		topicConcepts.setConceptsIncluded8(rs.getString("concepts_included_8"));
		topicConcepts.setConceptsIncluded9(rs.getString("concepts_included_9"));
		topicConcepts.setConceptsIncluded10(rs.getString("concepts_included_10"));
		topicConcepts.setSubject(rs.getString("subject_applicable_1"));
		return topicConcepts;
	}
}
