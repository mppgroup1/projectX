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
public class EmailDaoImpl implements EmailDao {
	
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
			throws DataAccessException{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	private SqlParameterSource getSqlParameterByModel(Email email, boolean isById){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		
		if(email!=null){
			paramSource.addValue("em_id", email.getId());
			if(!isById)
			{
				paramSource.addValue("em_email", email.getEmail());				
				paramSource.addValue("ph_primary", (email.isPrimary()? 1:0));
				//Associations
				paramSource.addValue("pr_id", email.getPerson_id());
			}
			
		}
		return paramSource;
	}
	
	private static final class EmailMapper implements RowMapper<Email>{
		
		public Email mapRow(ResultSet rs, int rowNum) throws SQLException{
			
			Email email = new Email();
			email.setId(rs.getInt("em_id"));
			email.setEmail(rs.getString("em_email"));
			email.setPrimary(rs.getBoolean("ph_primary"));
			
			//associations
			Person person= new Person();	
			person.setId(rs.getInt("pr_id"));
			person.setLastName(rs.getString("pr_lastname"));
			email.setPerson(person);//person
							
			return email;
		}
	}

	@Override
	public List<Email> listAllEmail() {
		//String sql="SELECT * FROM t_email";
		String sql="SELECT t_email.em_id, t_email.pr_id, t_email.em_email,t_email.ph_primary, t_person.pr_lastname "
		+" FROM t_email,t_person "	
		+ " order by t_email.em_id";
		
		List<Email> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null,false), new EmailMapper());
		return list;
	}
	
	@Override
	public List<Email> listAllEmail(int id) {
		String sql="SELECT t_email.em_id, t_email.pr_id, t_email.em_email,t_email.ph_primary, t_person.pr_lastname "
				+" FROM t_email,t_person where "
				+" t_person.pr_id = t_email.pr_id and t_email.pr_id = " + id	
				+ " order by t_email.em_id";
				
		//System.out.println(sql);
				List<Email> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null,false), new EmailMapper());
				return list;
	}

	@Override
	public void addEmail(Email email) {		
		String sql = "insert into t_email(em_email,pr_id,ph_primary) values(:em_email,:pr_id,:ph_primary)";						
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(email,false));		
	}

	@Override
	public void updateEmail(Email email) {		
		String sql = "update t_email set em_email =:em_email,"
				+ " ph_primary =:ph_primary,"
				+ " pr_id =:pr_id "
				+ " where em_id =:em_id";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(email,false));		
	}

	@Override
	public void deleteEmail(int id) {		
		String sql = "delete from t_email where em_id =:em_id";		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Email(id),true));		
	}

	@Override
	public Email findEmailById(int id) {		
		//String sql="select * from t_email where em_id =" +id ;
		String sql="SELECT t_email.em_id, t_email.pr_id, t_email.em_email,t_email.ph_primary, t_person.pr_lastname  "
		+" FROM t_email,t_person where "
		+" t_person.pr_id = t_email.pr_id "		
		+ " and t_email.em_id=" +id;
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Email(id),true), new EmailMapper());		
	}
}
