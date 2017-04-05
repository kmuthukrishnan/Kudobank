package com.newrubric.kudobank.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.newrubric.kudobank.object.McqQuestion;

public class McqQuestionMapper implements ResultSetMapper<McqQuestion>  {
	public McqQuestion map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
		McqQuestion question = new McqQuestion();		
		question.setCorrectOption(rs.getString("correct_option"));
		question.setLcsaName(rs.getString("lcsa_name"));
		question.setMcqOption1(rs.getString("mcq_option1"));
		question.setMcqOption2(rs.getString("mcq_option2"));
		question.setMcqOption3(rs.getString("mcq_option3"));
		question.setMcqOption4(rs.getString("mcq_option4"));
		question.setQuestionText(rs.getString("mcq_question"));
		question.setNrLcsaId(rs.getString("nr_lcsa_id"));
		question.setNrQuestionId(rs.getString("nr_question_id"));
		question.setNrSubskillId(rs.getString("nr_subskill_id"));
		question.setNrSuperskillId(rs.getString("nr_superskill_id"));
		question.setNrTopicId(rs.getString("nr_topic_id"));
		question.setNrTopicName(rs.getString("nr_topic_name"));
		question.setOptionImageExists(rs.getInt("option_image_exists"));
		question.setQuestionImageExists(rs.getInt("question_image_exists"));
		question.setSubskillName(rs.getString("subskill_name"));
		question.setSuperskillName(rs.getString("superskill_name"));
		question.setTopicDisplayName(rs.getString("topic_display_name"));

		return question;
	}
}