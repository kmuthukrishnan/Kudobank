package com.newrubric.kudobank.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.newrubric.kudobank.object.RcQuestionMap;

public class RcQuestionMapMapper implements ResultSetMapper<RcQuestionMap>  {
	public RcQuestionMap map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
		RcQuestionMap rcQuestionMap = new RcQuestionMap();	
		rcQuestionMap.setInitialMarks(rs.getInt("initial_marks"));
		rcQuestionMap.setNrQuestionId(rs.getString("nr_question_id"));
		rcQuestionMap.setNrRcQuestionId(rs.getString("nr_rc_question_id"));
		rcQuestionMap.setQuestionOrder(rs.getInt("question_order"));
		rcQuestionMap.setQuestionType(rs.getString("question_type"));		
		return rcQuestionMap;
	}
}