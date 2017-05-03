package com.mpp.group.proj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.mpp.group.proj.model.*;

@Repository
public class SpecieDaoImp implements SpecieDao {

NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
			throws DataAccessException{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	private SqlParameterSource getSqlParameterByModel(Specie Specie, boolean isById){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		
		if(Specie!=null){
			paramSource.addValue("sp_id", Specie.getId());
			if(!isById)
			{
				paramSource.addValue("sp_description", Specie.getDescription());			
			}
			
		}
		return paramSource;
	}
	
	private static final class SpecieMapper implements RowMapper<Specie>{
		
		public Specie mapRow(ResultSet rs, int rowNum) throws SQLException{
			
			Specie Specie = new Specie();
			Specie.setId(rs.getInt("sp_id"));
			Specie.setDescription(rs.getString("sp_description"));
										
			return Specie;
		}
	}
	
	@Override
	public List<Specie> listAllSpecie() {		
		String sql="SELECT * FROM t_specie";
		List<Specie> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null,false), new SpecieMapper());
		return list;		
	}

	@Override
	public void addSpecie(Specie Specie) {		
		String sql = "insert into t_specie(sp_description) values(:sp_description)";						
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(Specie,false));		
	}

	@Override
	public void updateSpecie(Specie Specie) {
		String sql = "update t_specie set sp_description =:sp_description"
				+ " where sp_id =:sp_id";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(Specie,false));
		
	}

	@Override
	public void deleteSpecie(int id) {		
		String sql = "delete from t_specie where sp_id =:sp_id";		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Specie(id),true));		
	}

	@Override
	public Specie findSpecieById(int id) {
		String sql="select * from t_specie where sp_id =" +id ;
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Specie(id),true), new SpecieMapper());
	}

}
