package com.newrubric.kudobank.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.newrubric.kudobank.mapper.LaQuestionMapper;
import com.newrubric.kudobank.mapper.McqQuestionMapper;
import com.newrubric.kudobank.mapper.QnEvaluationKeyMapper;
import com.newrubric.kudobank.mapper.RCQuestionMapper;
import com.newrubric.kudobank.mapper.RcQuestionMapMapper;
import com.newrubric.kudobank.mapper.SaQuestionMapper;
import com.newrubric.kudobank.mapper.VsaQuestionMapper;
import com.newrubric.kudobank.object.LaQuestion;
import com.newrubric.kudobank.object.McqQuestion;
import com.newrubric.kudobank.object.QnEvaluationKey;
import com.newrubric.kudobank.object.RCQuestion;
import com.newrubric.kudobank.object.RcQuestionMap;
import com.newrubric.kudobank.object.SaQuestion;
import com.newrubric.kudobank.object.VsaQuestion;

public interface IQuestionsDao {
	@SqlQuery("select mcq.nr_question_id , mcq.nr_topic_id , mcq.mcq_question , mcq.mcq_option1 , mcq.mcq_option2 , mcq.mcq_option3 , mcq.mcq_option4 , mcq.question_image_exists , mcq.option_image_exists , mcq.correct_option ,master.nr_question_type_id ,master.question_type_name ,master.nr_topic_id ,master.nr_topic_name ,master.topic_display_name ,master.nr_lcsa_id ,master.lcsa_name ,master.nr_subskill_id ,master.subskill_name ,master.nr_superskill_id ,master.superskill_name ,master.is_closeended from nr_mcq_questions as mcq inner join nr_question_master as master on mcq.nr_question_id = master.nr_question_id where mcq.nr_question_id =:QID limit 1;")
	@Mapper(McqQuestionMapper.class)
	public McqQuestion getQuestionMCQById(@Bind("QID")  String qid);

	@SqlQuery("select mcq.nr_question_id , mcq.nr_topic_id , mcq.mcq_question , mcq.mcq_option1 , mcq.mcq_option2 , mcq.mcq_option3 , mcq.mcq_option4 , mcq.question_image_exists , mcq.option_image_exists , mcq.correct_option ,master.nr_question_type_id ,master.question_type_name ,master.nr_topic_id ,master.nr_topic_name ,master.topic_display_name ,master.nr_lcsa_id ,master.lcsa_name ,master.nr_subskill_id ,master.subskill_name ,master.nr_superskill_id ,master.superskill_name ,master.is_closeended from nr_mcq_questions as mcq inner join nr_question_master as master on mcq.nr_question_id = master.nr_question_id where mcq.nr_question_id =:QID and mcq.option_image_exists = 1 limit 1;")
	@Mapper(McqQuestionMapper.class)
	public McqQuestion getQuestionMCQImageById(@Bind("QID")  String qid);	
	

	@SqlQuery("select vsa.nr_question_id , vsa.nr_topic_id ,vsa.correct_option ,vsa.image_exists ,vsa.question_category, vsa.vsa_question ,master.nr_question_type_id ,master.question_type_name ,master.nr_topic_id ,master.nr_topic_name ,master.topic_display_name ,master.nr_lcsa_id ,master.lcsa_name ,master.nr_subskill_id ,master.subskill_name ,master.nr_superskill_id ,master.superskill_name , master.is_closeended from nr_vsa_questions as vsa inner join nr_question_master as master  on vsa.nr_question_id = master.nr_question_id where vsa.nr_question_id =:QID limit 1;")
	@Mapper(VsaQuestionMapper.class)
	public VsaQuestion getQuestionVSAById(@Bind("QID")  String qid);

	
	@SqlQuery("select sa.nr_question_id , sa.nr_topic_id ,sa.image_exists , sa.sa_question ,master.nr_question_type_id ,master.question_type_name ,master.nr_topic_id ,master.nr_topic_name ,master.topic_display_name ,master.nr_lcsa_id ,master.lcsa_name ,master.nr_subskill_id ,master.subskill_name ,master.nr_superskill_id ,master.superskill_name , master.is_closeended from nr_sa_questions as sa inner join nr_question_master as master on sa.nr_question_id = master.nr_question_id where sa.nr_question_id =:QID limit 1;")
	@Mapper(SaQuestionMapper.class)
	public SaQuestion getQuestionSAById(@Bind("QID")  String qid);
	

	@SqlQuery("select la.nr_question_id , la.nr_topic_id ,la.image_exists , la.la_question ,master.nr_question_type_id ,master.question_type_name ,master.nr_topic_id ,master.nr_topic_name ,master.topic_display_name ,master.nr_lcsa_id ,master.lcsa_name ,master.nr_subskill_id ,master.subskill_name ,master.nr_superskill_id ,master.superskill_name , master.is_closeended from nr_la_questions as la inner join nr_question_master as master on la.nr_question_id = master.nr_question_id where la.nr_question_id =:QID limit 1;")
	@Mapper(LaQuestionMapper.class)
	public LaQuestion getQuestionLAById(@Bind("QID")  String qid);


	@SqlQuery("select qn_eval_key_id,nr_question_id,eval_key_seq,eval_key_type,eval_key_type_id,eval_key_type_name,eval_key_type_display_name ,eval_key_marks from nr_qn_evaluation_key where nr_question_id = :QID ;")
	@Mapper(QnEvaluationKeyMapper.class)
	public List<QnEvaluationKey> getQuestionEvaluationKeyId(@Bind("QID")  String qid);

	
	@SqlQuery("select rc.nr_question_id , rc.nr_topic_id ,rc.image_exists , rc.rc_question ,master.nr_question_type_id ,master.question_type_name ,master.nr_topic_id ,master.nr_topic_name ,master.topic_display_name ,master.nr_lcsa_id ,master.lcsa_name ,master.nr_subskill_id ,master.subskill_name , master.nr_superskill_id ,master.superskill_name , master.is_closeended from nr_rc_questions as rc inner join nr_question_master as master on rc.nr_question_id = master.nr_question_id where rc.nr_question_id =:QID limit 1;")
	@Mapper(RCQuestionMapper.class)
	public RCQuestion getQuestionRCById(@Bind("QID")  String qid);

	@SqlQuery("select nr_rc_question_id ,nr_question_id,question_type,question_order,initial_marks from nr_rc_question_map where nr_rc_question_id = :QID and is_active = 1 and is_deleted = 0 order by question_order ;")
	@Mapper(RcQuestionMapMapper.class)
	public List<RcQuestionMap> getRCComponentQuestions(@Bind("QID")  String qid);
	
}
