package com.newrubric.kudobank.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.newrubric.kudobank.object.VsaQuestion;

public class VsaQuestionMapper implements ResultSetMapper<VsaQuestion>  {
	public VsaQuestion map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
		VsaQuestion question = new VsaQuestion();
		question.setVsaQuestionCategory(rs.getString("question_category"));
		question.setCorrectOption(rs.getString("correct_option"));
		question.setLcsaName(rs.getString("lcsa_name"));
		question.setQuestionText(rs.getString("vsa_question"));
		question.setNrLcsaId(rs.getString("nr_lcsa_id"));
		question.setNrQuestionId(rs.getString("nr_question_id"));
		question.setNrSubskillId(rs.getString("nr_subskill_id"));
		question.setNrSuperskillId(rs.getString("nr_superskill_id"));
		question.setNrTopicId(rs.getString("nr_topic_id"));
		question.setNrTopicName(rs.getString("nr_topic_name"));
		
		question.setQuestionImageExists(rs.getInt("image_exists"));
		question.setSubskillName(rs.getString("subskill_name"));
		question.setSuperskillName(rs.getString("superskill_name"));
		question.setTopicDisplayName(rs.getString("topic_display_name"));
		return question;
	}
}