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
import com.mpp.group.proj.model.Breed;

@Repository
public class BreedDaoImpl implements BreedDao {

NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
			throws DataAccessException{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	private SqlParameterSource getSqlParameterByModel(Breed Breed, boolean isById){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		
		if(Breed!=null){
			paramSource.addValue("br_id", Breed.getId());
			if(!isById)
			{
				paramSource.addValue("br_description", Breed.getDescription());			
			}
			
		}
		return paramSource;
	}
	
	private static final class BreedMapper implements RowMapper<Breed>{
		
		public Breed mapRow(ResultSet rs, int rowNum) throws SQLException{
			
			Breed Breed = new Breed();
			Breed.setId(rs.getInt("br_id"));
			Breed.setDescription(rs.getString("br_description"));
										
			return Breed;
		}
	}
	
	@Override
	public List<Breed> listAllBreed() {		
		String sql="SELECT * FROM t_breed";
		List<Breed> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null,false), new BreedMapper());
		return list;		
	}

	@Override
	public void addBreed(Breed Breed) {		
		String sql = "insert into t_Breed(br_description) values(:br_description)";						
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(Breed,false));		
	}

	@Override
	public void updateBreed(Breed Breed) {
		String sql = "update t_breed set br_description =:br_description"
				+ " where br_id =:br_id";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(Breed,false));
		
	}

	@Override
	public void deleteBreed(int id) {		
		String sql = "delete from t_breed where br_id =:br_id";		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Breed(id),true));		
	}

	@Override
	public Breed findBreedById(int id) {
		String sql="select * from t_breed where br_id =" +id ;
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Breed(id),true), new BreedMapper());
	}

}
