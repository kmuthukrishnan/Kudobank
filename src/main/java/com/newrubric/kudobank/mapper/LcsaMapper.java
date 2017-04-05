package com.newrubric.kudobank.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.newrubric.kudobank.object.Lcsa;


public class LcsaMapper implements ResultSetMapper<Lcsa>  {
	public Lcsa map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
		Lcsa lcsa = new Lcsa();		
		lcsa.setLcsaDisplayName(rs.getString("lcsa_display_name"));
		lcsa.setLcsaName(rs.getString("lcsa_name"));
		lcsa.setNrLcsaId(rs.getString("nr_lcsa_id"));
		lcsa.setSubskillName(rs.getString("subskill_name"));
		lcsa.setSuperskillName(rs.getString("superskill_name"));	
		lcsa.setTagSubject(rs.getString("subject_applicability"));
		return lcsa;
	}
}
