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

import com.mpp.group.proj.model.Gender;
import com.mpp.group.proj.model.Person;
import com.mpp.group.proj.model.Title;

@Repository
public class PersonDaoImpl implements PersonDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
			throws DataAccessException{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	private SqlParameterSource getSqlParameterByModel(Person person){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		
		if(person!=null){
			paramSource.addValue("pr_id", person.getId());
			paramSource.addValue("pr_type", person.getType());
			paramSource.addValue("pr_title", person.getTitle());
			paramSource.addValue("pr_lastname", person.getLastName());
			paramSource.addValue("pr_firstname", person.getFirstName());
			paramSource.addValue("pr_gender", person.getGender());
			paramSource.addValue("pr_status", person.getStatus());
		}
		
		return paramSource;
	}
	
	
	private SqlParameterSource getSqlParameterByModelSave(Person person){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		
		if(person!=null){
			paramSource.addValue("pr_id", person.getId());
			paramSource.addValue("pr_type", person.getType());
			paramSource.addValue("pr_title", person.getTitle().toString());
			paramSource.addValue("pr_lastname", person.getLastName());
			paramSource.addValue("pr_firstname", person.getFirstName());
			paramSource.addValue("pr_gender", person.getGender().toString());
			paramSource.addValue("pr_status", person.getStatus().toString());
		}
		
		return paramSource;
	}
	private static final class PersonMapper implements RowMapper<Person>{
		
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException{
			Person person = new Person();
			
			person.setId(rs.getInt("pr_id"));
			person.setType(rs.getInt("pr_type"));
			person.setTitle(Title.valueOf(rs.getString("pr_title")));
			person.setLastName(rs.getString("pr_lastname"));
			person.setFirstName(rs.getString("pr_firstname"));
			person.setGender(Gender.valueOf(rs.getString("pr_gender")));
			person.setStatus(rs.getString("pr_status"));

			return person;
		}
	}
	
	@Override
	public List<Person> listAllPerson() {
		String sql="select pr_id, pr_type, pr_title, pr_title, pr_lastname, "+
				"pr_firstname, pr_gender, pr_status from t_person order by pr_id";
		List<Person> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new PersonMapper());
		return list;
	}

	@Override
	public void addPerson(Person person) {

		String sql = "insert into t_person(pr_id, pr_type, pr_title, "+
				"pr_lastname, pr_firstname, pr_gender, pr_status) values(:pr_id, "+
				":pr_type, :pr_title, :pr_lastname, :pr_firstname, :pr_gender, :pr_status)";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModelSave(person));
	}
	
	@Override
	public void updatePerson(Person person) {
		String sql = "update t_person set pr_id =:pr_id, pr_type =:pr_type, pr_title =:pr_title, "+
				"pr_lastname =:pr_lastname, pr_firstname =:pr_firstname, pr_gender =:pr_gender, "+
				"pr_status =:pr_status where pr_id =:pr_id";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModelSave(person));
	}

	@Override
	public void deletePerson(int id) {
		String sql = "delete from t_person where pr_id =:pr_id";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Person(id)));
	}

	@Override
	public Person findPersonById(int id) {
		String sql="select pr_id, pr_type, pr_title, pr_lastname, "+
				"pr_firstname, pr_gender, pr_status from t_person where pr_id = " +id;
		
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Person(id)), new PersonMapper());
	}

	@Override
	public List<Person> listAllDoctor() {
		String sql="select pr_id, pr_type, pr_title, pr_title, pr_lastname, "+
				"pr_firstname, pr_gender, pr_status from t_person where  pr_type= 1 order by pr_id";
		List<Person> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new PersonMapper());
		return list;
	}

}
