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

import com.mpp.group.proj.model.Phone;

@Repository
public class PhoneDaoImpl implements PhoneDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
			throws DataAccessException{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	private SqlParameterSource getSqlParameterByModel(Phone phone){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		
		if(phone!=null){
			paramSource.addValue("ph_id", phone.getId());
			paramSource.addValue("pr_id", phone.getPid());
			paramSource.addValue("ph_areacode", phone.getAreacode());
			paramSource.addValue("ph_telephone", phone.getTelephone());
			paramSource.addValue("ph_primary", phone.getPrimary());
		}
		
		return paramSource;
	}
	
	
	private SqlParameterSource getSqlParameterByModelSave(Phone phone){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		
		if(phone!=null){
			paramSource.addValue("ph_id", phone.getId());
			paramSource.addValue("pr_id", phone.getPid());
			paramSource.addValue("ph_areacode", phone.getAreacode());
			paramSource.addValue("ph_telephone", phone.getTelephone());
			paramSource.addValue("ph_primary", phone.getPrimary().toString());
		}
		
		return paramSource;
	}
	private static final class PhoneMapper implements RowMapper<Phone>{
		
		public Phone mapRow(ResultSet rs, int rowNum) throws SQLException{
			Phone phone = new Phone();
			
			phone.setId(rs.getInt("ph_id"));
			phone.setPid(rs.getInt("pr_id"));
			phone.setAreacode(rs.getInt("ph_areacode"));
			phone.setTelephone(rs.getLong("ph_telephone"));
			phone.setPrimary(rs.getString("ph_primary"));

			return phone;
		}
	}
	
	@Override
	public List<Phone> listAllPhone() {
		String sql="select ph_id, pr_id, ph_areacode, ph_telephone, ph_primary "+
				"from t_phone order by ph_id";
		List<Phone> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new PhoneMapper());
		
		return list;
	}
	
	@Override
	public List<Phone> listAllPersonPhone(int pr_id) {
		String sql="select ph_id, pr_id, ph_areacode, ph_telephone, ph_primary "+
				"from t_phone where pr_id = " + pr_id + " order by ph_id";
		List<Phone> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new PhoneMapper());
		
		return list;
	}

	@Override
	public void addPhone(Phone phone) {

		String sql = "insert into t_phone(ph_id, pr_id, ph_areacode, ph_telephone, ph_primary) "+
				"values(:ph_id, :pr_id, :ph_areacode, :ph_telephone, :ph_primary)";
		
		System.out.println("91 addPhone " + sql);
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModelSave(phone));
	}
	
	@Override
	public void updatePhone(Phone phone) {
		String sql = "update t_phone set ph_id =:ph_id, pr_id =:pr_id, ph_areacode =:ph_areacode, "+
				"ph_telephone =:ph_telephone, ph_primary =:ph_primary where ph_id =:ph_id";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModelSave(phone));
	}

	@Override
	public void deletePhone(int id) {
		String sql = "delete from t_phone where ph_id =:ph_id";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Phone(id)));
	}

	@Override
	public Phone findPhoneById(int id) {
		String sql="select ph_id, pr_id, ph_areacode, ph_telephone, ph_primary "+
				"from t_phone where ph_id = " +id;
		
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Phone(id)), new PhoneMapper());
	}

}
