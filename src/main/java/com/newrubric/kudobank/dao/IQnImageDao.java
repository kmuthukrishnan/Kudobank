package com.newrubric.kudobank.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.newrubric.kudobank.mapper.QuestionImageMapper;
import com.newrubric.kudobank.object.QuestionImage;

public interface IQnImageDao {
	@SqlQuery("select nr_question_image_id,nr_question_id,nr_question_image_name,isQuestionImage,image_order,ref_material from nr_question_images where nr_question_id = :QID and  is_active = 1 and is_deleted = 0 ;")
	@Mapper(QuestionImageMapper.class)
	public List<QuestionImage> getQnImagesByQnId(@Bind("QID")  String qid);
}
