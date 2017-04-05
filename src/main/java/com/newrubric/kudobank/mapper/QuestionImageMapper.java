package com.newrubric.kudobank.mapper;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.newrubric.kudobank.object.QuestionImage;

public class QuestionImageMapper implements ResultSetMapper<QuestionImage>  {
	public QuestionImage map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
		QuestionImage qnImage = new QuestionImage();
		Blob blob = rs.getBlob("ref_material");
		byte [] array = blob.getBytes( 1, ( int ) blob.length() );
		qnImage.setImage(array);
		qnImage.setImageOrder(rs.getInt("image_order"));
		qnImage.setIsQuestionImage(rs.getInt("isQuestionImage"));
		
		qnImage.setImageName(rs.getString("nr_question_image_name"));
		qnImage.setQuestionId(rs.getString("nr_question_id"));
		qnImage.setQuestionImageId(rs.getString("nr_question_image_id"));		
		return qnImage;
	}
}
