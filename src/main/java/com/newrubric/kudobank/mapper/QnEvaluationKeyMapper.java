package com.newrubric.kudobank.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.newrubric.kudobank.object.QnEvaluationKey;

public class QnEvaluationKeyMapper  implements ResultSetMapper<QnEvaluationKey>  {
	public QnEvaluationKey map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
		QnEvaluationKey qnEvaluationKey = new QnEvaluationKey();
		qnEvaluationKey.setEvalKeyMarks(rs.getInt("eval_key_marks"));
		qnEvaluationKey.setEvalKeySeq(rs.getInt("eval_key_seq"));
		qnEvaluationKey.setEvalKeyType(rs.getString("eval_key_type"));
		qnEvaluationKey.setEvalKeyTypeDisplayName(rs.getString("eval_key_type_display_name"));
		qnEvaluationKey.setEvalKeyTypeId(rs.getString("eval_key_type_id"));
		qnEvaluationKey.setEvalKeyTypeName(rs.getString("eval_key_type_name"));
		qnEvaluationKey.setNrQuestionId(rs.getString("nr_question_id"));
		qnEvaluationKey.setQnEvalKeyId(rs.getString("qn_eval_key_id"));
		return qnEvaluationKey;
	}
}
