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

import com.mpp.group.proj.model.Animal;
import com.mpp.group.proj.model.Person;
import com.mpp.group.proj.model.Vaccine;
import com.mpp.group.proj.service.AnimalService;

@Repository
public class VaccineDaoImpl implements VaccineDao {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	AnimalService AnimalService;
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
			throws DataAccessException{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	
	private SqlParameterSource getSqlParameterByModel(Vaccine vaccine, boolean isById){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		
		if(vaccine!=null){
			paramSource.addValue("va_id", vaccine.getId());
			if(!isById)
			{
			//System.out.println("interno");
			paramSource.addValue("va_id", vaccine.getId());
			paramSource.addValue("an_id", vaccine.getAnimal_id());
			paramSource.addValue("va_date", vaccine.getDate());
			paramSource.addValue("va_name", vaccine.getName());
			paramSource.addValue("va_batch", vaccine.getBatch());
			paramSource.addValue("pr_id", vaccine.getDoctor_id());
		}
		}
		return paramSource;
	}
	
	private static final class VaccineMapper implements RowMapper<Vaccine>{

		public Vaccine mapRow(ResultSet rs, int rowNum) throws SQLException{

			Vaccine vaccine = new Vaccine();
			vaccine.setId(rs.getInt("va_id"));
			//System.out.println("Animal ID "+ rs.getInt("an_id"));
			Animal animal= new Animal();
			
			//System.out.println("Person ID "+ rs.getInt("pr_id"));
			Person doctor= new Person();
			
			animal.setId(rs.getInt("an_id"));
			animal.setName(rs.getString("an_name"));			
			vaccine.setAnimal(animal);//animal
			
			doctor.setId(rs.getInt("pr_id"));
			doctor.setLastName(rs.getString("pr_lastname"));
			vaccine.setDoctor(doctor);//doctor
			//vaccine.setDoctor_id(rs.getInt("pr_id"));//doctor
			vaccine.setDate(rs.getDate("va_date"));
			vaccine.setName(rs.getString("va_name"));
			vaccine.setBatch(rs.getString("va_batch"));
			//System.out.println(vaccine);
			
			return vaccine;
		}
	}
	
	
	@Override
	public List<Vaccine> listAllVaccine() {
		String sql="select "
		+" t_vaccine.va_id,"
		+"   t_vaccine.an_id,"
		+"	t_animal.an_name,"
		+"    t_vaccine.pr_id,"
		+"    t_vaccine.va_date,"
		+"    t_vaccine.va_name,"
		+"    t_vaccine.va_batch,"
		+"    t_person.pr_lastname"
		+" from t_vaccine, t_animal, t_person where "
		+" t_animal.an_id = t_vaccine.an_id and "
		+" t_person.pr_id = t_vaccine.pr_id "
		+ " order by va_id";
		
		List<Vaccine> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null,false), new VaccineMapper());
		return list;
	}

	@Override
	public void addVaccine(Vaccine Vaccine) {
		 String sql = "INSERT INTO t_vaccine (an_id,pr_id,va_date,va_name,va_batch)"
				+ "VALUES (:an_id,:pr_id,:va_date,:va_name,:va_batch)";
	
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(Vaccine,false));
	
	}

	@Override
	public void updateVaccine(Vaccine Vaccine) {
		// TODO Auto-generated method stub
		//String sql = "update tbl_category set category_name =:category_name where id =:id";
		String sql = "UPDATE  t_vaccine"
				+" SET an_id = :an_id,"
				+"pr_id = :pr_id, "
				+ "va_date = :va_date, "
				+"va_name=:va_name, "
				+"va_batch=:va_batch "
				+"WHERE va_id = :va_id;";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(Vaccine,false));
	
	}

	@Override
	public void deleteVaccine(int id) {
		
		
		String sql = "delete from t_vaccine where va_id =:va_id";
		//System.out.println("DELETE" +sql);
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Vaccine(id),true));
		
	}

	@Override
	public Vaccine findVaccineById(int id) {
		//String sql="select id, category_name from tbl_category where id = " +id;
		String sql="select "
		+" t_vaccine.va_id,"
		+"   t_vaccine.an_id,"
		+"	t_animal.an_name,"
		+"    t_vaccine.pr_id,"
		+"    t_vaccine.va_date,"
		+"    t_vaccine.va_name,"
		+"    t_vaccine.va_batch,"
		+"    t_person.pr_lastname"
		+" from t_vaccine, t_animal ,t_person where "
		+" t_animal.an_id = t_vaccine.an_id and "
		+" t_person.pr_id = t_vaccine.pr_id "
		+ " and t_vaccine.va_id=" +id;
		
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Vaccine(id),true), new VaccineMapper());
	
	}

}
