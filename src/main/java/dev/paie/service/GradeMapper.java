package dev.paie.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dev.paie.entite.Grade;

public class GradeMapper implements RowMapper<Grade> {

	@Override
	public Grade mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Grade grade = new Grade();
		grade.setId(rs.getInt("id_grade"));
		grade.setCode(rs.getString("code"));
		grade.setNbHeuresBase(rs.getBigDecimal("nbHeureBase"));
		grade.setTauxBase(rs.getBigDecimal("tauxBase"));
		return grade;
	}

}
