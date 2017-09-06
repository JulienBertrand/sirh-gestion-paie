package dev.paie.service;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dev.paie.entite.Cotisation;

public class CotisationMapper implements RowMapper<Cotisation> {

	@Override
	public Cotisation mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cotisation cotisation = new Cotisation();
		cotisation.setId(rs.getInt("id"));
		cotisation.setCode(rs.getString("code"));
		cotisation.setLibelle(rs.getString("libelle"));
		cotisation.setTauxPatronal(rs.getBigDecimal("tauxPatronal"));
		cotisation.setTauxSalarial(rs.getBigDecimal("tauxSalarial"));
		
		return cotisation;
	}

}
