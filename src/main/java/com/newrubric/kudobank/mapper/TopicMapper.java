package com.newrubric.kudobank.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.newrubric.kudobank.object.Topic;

public class TopicMapper implements ResultSetMapper<Topic>  {
	public Topic map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
		Topic topic = new Topic();		
		topic.setApplicableForbbm1(getApplicability(rs.getString("applicable_for_bbm1")));
		topic.setApplicableForGrade1(getApplicability(rs.getString("applicable_for_grade_1")));
		topic.setApplicableForGrade10(getApplicability(rs.getString("applicable_for_grade_10")));
		topic.setApplicableForGrade2(getApplicability(rs.getString("applicable_for_grade_2")));
		topic.setApplicableForGrade3(getApplicability(rs.getString("applicable_for_grade_3")));
		topic.setApplicableForGrade4(getApplicability(rs.getString("applicable_for_grade_4")));
		topic.setApplicableForGrade5(getApplicability(rs.getString("applicable_for_grade_5")));
		topic.setApplicableForGrade6(getApplicability(rs.getString("applicable_for_grade_6")));
		topic.setApplicableForGrade7(getApplicability(rs.getString("applicable_for_grade_7")));
		topic.setApplicableForGrade8(getApplicability(rs.getString("applicable_for_grade_8")));
		topic.setApplicableForGrade9(getApplicability(rs.getString("applicable_for_grade_9")));
		topic.setApplicableForLkg(getApplicability(rs.getString("applicable_for_lkg")));
		topic.setApplicableForNursery(getApplicability(rs.getString("applicable_for_nursery")));
		topic.setApplicableForPlaygroup(getApplicability(rs.getString("applicable_for_playgroup")));
		topic.setApplicableForUkg(getApplicability(rs.getString("applicable_for_ukg")));	
		
		topic.setSubjectApplicable1(rs.getString("subject_applicable_1"));
		topic.setSubjectApplicable2(rs.getString("subject_applicable_2"));
		
		topic.setConceptsIncluded1(rs.getString("concepts_included_1"));
		topic.setConceptsIncluded2(rs.getString("concepts_included_2"));
		topic.setConceptsIncluded3(rs.getString("concepts_included_3"));
		topic.setConceptsIncluded4(rs.getString("concepts_included_4"));
		topic.setConceptsIncluded5(rs.getString("concepts_included_5"));
		topic.setConceptsIncluded6(rs.getString("concepts_included_6"));
		topic.setConceptsIncluded7(rs.getString("concepts_included_7"));
		topic.setConceptsIncluded8(rs.getString("concepts_included_8"));
		topic.setConceptsIncluded9(rs.getString("concepts_included_9"));
		topic.setConceptsIncluded10(rs.getString("concepts_included_10"));
		
		topic.setContentUnit(rs.getString("content_unit"));
		topic.setNrTopicId(rs.getString("nr_topic_id"));
		topic.setTopicDisplayName(rs.getString("topic_display_name"));
		topic.setTopicName(rs.getString("topic_name"));
		return topic;
	}
	
	private int getApplicability(String applicable){
		if((null == applicable)||(applicable.trim().isEmpty())){
			return 0;
		}
		if("Y".equalsIgnoreCase(applicable.trim())){
			return 1;
		}else{
			return 0;
		}
	}
}