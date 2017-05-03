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
public class LocationDaoImpl implements LocationDao {
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
			throws DataAccessException{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	private SqlParameterSource getSqlParameterByModel(Location location, boolean isById){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		
		if(location!=null){
			paramSource.addValue("lc_id", location.getId());
			if(!isById)
			{
				paramSource.addValue("lc_address", location.getAddress());
				paramSource.addValue("lc_city", location.getCity());
				paramSource.addValue("lc_state",location.getState());
				paramSource.addValue("lc_zipcode", location.getZipcode());
				paramSource.addValue("lc_country", location.getCountry());
				paramSource.addValue("ph_primary", (location.isPrimary()?1:0));
				//Associations
				paramSource.addValue("pr_id", location.getPerson_id());
			}
			
		}
		return paramSource;
	}
	
	private static final class LocationMapper implements RowMapper<Location>{
		
		public Location mapRow(ResultSet rs, int rowNum) throws SQLException{
			
			Location location = new Location();
			location.setId(rs.getInt("lc_id"));
			location.setAddress(rs.getString("lc_address"));
			location.setCity(rs.getString("lc_city"));
			location.setState(rs.getString("lc_state"));
			location.setZipcode(rs.getInt("lc_zipcode"));
			location.setCountry(rs.getString("lc_country"));
			location.setPrimary(rs.getBoolean("ph_primary"));
			//associations
			Person person= new Person();	
			person.setId(rs.getInt("pr_id"));
			person.setLastName(rs.getString("pr_lastname"));
			location.setPerson(person);
							
			return location;
		}
	}
	
	@Override
	public List<Location> listAllLocation(int id) {
		String sql="SELECT t_location.*, concat( t_person.pr_firstname, ' ' ,t_person.pr_lastname ) as pr_lastname "
				+ " FROM t_person inner join t_location on t_person.pr_id = t_location.pr_id where t_location.pr_id = " + id;
		List<Location> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null,false), new LocationMapper());
		return list;
	}

	@Override
	public List<Location> listAllLocation() {
		
		String sql="SELECT t_location.*, concat( t_person.pr_firstname, ' ' ,t_person.pr_lastname ) as pr_lastname "
				+ " FROM t_person inner join t_location on t_person.pr_id = t_location.pr_id";
		List<Location> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null,false), new LocationMapper());
		return list;
		
	}

	@Override
	public void addLocation(Location location) {
		
		String sql = "insert into t_location(lc_address,lc_city,lc_state,lc_zipcode,lc_country"
				+ ",ph_primary,pr_id) values(:lc_address,:lc_city,:lc_state,:lc_zipcode,:lc_country"
				+ ",:ph_primary,:pr_id)";
						
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(location,false));
		
	}

	@Override
	public void updateLocation(Location location) {
		
		String sql = "update t_location set lc_address =:lc_address,"
				+ " lc_city =:lc_city,"
				+ " lc_state =:lc_state,"
				+ " lc_zipcode =:lc_zipcode,"
				+ " lc_country =:lc_country,"
				+ " ph_primary =:ph_primary,"
				+ " pr_id =:pr_id"
				+ " where lc_id =:lc_id";
		
		//System.out.println("117 -> " + sql);
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(location,false));
		
	}

	@Override
	public void deleteLocation(int id) {
		
		String sql = "delete from t_location where lc_id =:lc_id";		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Location(id),true));
		
	}

	@Override
	public Location findLocationById(int id) {
		
		String sql= "SELECT t_location.*, concat( t_person.pr_firstname, ' ' ,t_person.pr_lastname ) as pr_lastname "
				+ " FROM t_person inner join t_location on t_person.pr_id = t_location.pr_id"
				+ " where lc_id =" +id ;
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Location(id),true), new LocationMapper());
	}

	

}
