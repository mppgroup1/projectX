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
public class AnimalDaoImp implements AnimalDao {

	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
			throws DataAccessException{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	private SqlParameterSource getSqlParameterByModel(Animal animal, boolean isById){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		
		if(animal!=null){
			paramSource.addValue("an_id", animal.getId());
			if(!isById)
			{
				paramSource.addValue("an_name", animal.getName());
				paramSource.addValue("an_gender", animal.getGender().toString());
				paramSource.addValue("an_neuter", (animal.isNeutered() ? 1:0));
				paramSource.addValue("an_birth", animal.getBirth());
				paramSource.addValue("an_color", animal.getColor());
				if(animal.isIs_deceased())
					paramSource.addValue("an_deceased", animal.getDeceased());
				else
					paramSource.addValue("an_deceased", null);
				paramSource.addValue("an_status", (animal.isStatus()?1:0));
				//Associations
				paramSource.addValue("sp_id", animal.getSpecie_id());
				paramSource.addValue("br_id", animal.getBreed_id());
				paramSource.addValue("mr_id", animal.getMicrochip_id()	);
				
			}
			
		}
		return paramSource;
	}
	
	private static final class AnimalMapper implements RowMapper<Animal>{
		
		public Animal mapRow(ResultSet rs, int rowNum) throws SQLException{
			
			Animal animal = new Animal();
			animal.setId(rs.getInt("an_id"));
			animal.setName(rs.getString("an_name"));
			animal.setGender(Gender.valueOf(rs.getString("an_gender")));
			animal.setNeutered(rs.getBoolean("an_neuter"));
			animal.setBirth(rs.getDate("an_birth"));
			animal.setColor(rs.getString("an_color"));
			animal.setDeceased(rs.getDate("an_deceased"));
			animal.setStatus(rs.getBoolean("an_status"));
			//associations
			animal.setSpecie(new Specie(rs.getInt("sp_id"),rs.getString("sp_description")));
			animal.setBreed(new Breed(rs.getInt("br_id"),rs.getString("br_description")));
			animal.setMicrochip(new Microchip(rs.getInt("mr_id"),rs.getString("mr_description")));
				
			return animal;
		}
	}
	
	
	@Override
	public List<Animal> listAllAnimal() {
		
		String sql="select t_animal.*,mr_description,br_description,sp_description from t_animal "
				+ "inner join t_specie on t_specie.sp_id = t_animal.sp_id "
				+ "inner join t_breed on t_breed.br_id = t_animal.br_id "
				+ "inner join t_microchip on t_microchip.mr_id = t_animal.mr_id ORDER BY t_animal.an_id ";
		List<Animal> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null,false), new AnimalMapper());
		return list;
		
	}

	@Override
	public void addAnimal(Animal animal) {
		
		String sql = "insert into t_animal(an_name,an_gender,an_neuter,an_birth,an_color"
				+ ",an_deceased,an_status,sp_id,br_id,mr_id) values(:an_name,:an_gender,:an_neuter,:an_birth,:an_color"
				+ ",:an_deceased,:an_status,:sp_id,:br_id,:mr_id)";
						
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(animal,false));
		
	}

	@Override
	public void updateAnimal(Animal animal) {
		
		String sql = "update t_animal set an_name =:an_name,"
				+ " an_gender =:an_gender,"
				+ " an_neuter =:an_neuter,"
				+ " an_birth =:an_birth,"
				+ " an_color =:an_color,"
				+ " an_deceased =:an_deceased,"
				+ " an_status =:an_status,"
				+ " sp_id =:sp_id,"
				+ " br_id =:br_id,"
				+ " mr_id =:mr_id"
				+ " where an_id =:an_id";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(animal,false));
		
	}

	@Override
	public void deleteAnimal(int id) {
		
		String sql = "delete from t_animal where an_id =:an_id";		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Animal(id),true));
		
	}

	@Override
	public Animal findAnimalById(int id) {
		String sql="select t_animal.*,mr_description,br_description,sp_description from t_animal "
				+ "inner join t_specie on t_specie.sp_id = t_animal.sp_id "
				+ "inner join t_breed on t_breed.br_id = t_animal.br_id "
				+ "inner join t_microchip on t_microchip.mr_id = t_animal.mr_id "
				+ "where an_id =" +id ;
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Animal(id),true), new AnimalMapper());
	}

}
