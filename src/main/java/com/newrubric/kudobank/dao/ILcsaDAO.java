package com.newrubric.kudobank.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.newrubric.kudobank.mapper.LcsaMapper;
import com.newrubric.kudobank.object.Lcsa;


public interface ILcsaDAO {
	@SqlQuery("select nr_lcsa_id,lcsa_name,lcsa_display_name,subskill_name,superskill_name, subject_applicability from nr_lcsa where is_active = 1 and is_deleted = 0  ;")
	@Mapper(LcsaMapper.class)
	public List<Lcsa> getAllLcsaa();

	@SqlQuery("select nr_lcsa_id,lcsa_name,lcsa_display_name,subskill_name,superskill_name, subject_applicability from nr_lcsa where nr_lcsa_id = :lcsaId and  is_active = 1 and is_deleted = 0 ;")
	@Mapper(LcsaMapper.class)
	public Lcsa getLcsaById(@Bind("lcsaId")  String lcsaId);

}
