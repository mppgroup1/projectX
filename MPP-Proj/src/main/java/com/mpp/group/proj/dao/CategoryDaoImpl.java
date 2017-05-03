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

import com.mpp.group.proj.model.Categories;


@Repository
public class CategoryDaoImpl implements CategoryDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
			throws DataAccessException{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	private SqlParameterSource getSqlParameterByModel(Categories categories){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		
		if(categories!=null){
			paramSource.addValue("id", categories.getId());
			paramSource.addValue("category_name", categories.getCategory_name());
		}
		return paramSource;
	}
	
	private static final class CategoryMapper implements RowMapper<Categories>{
		
		public Categories mapRow(ResultSet rs, int rowNum) throws SQLException{
			Categories categories = new Categories();
			categories.setId(rs.getInt("id"));
			categories.setCategory_name(rs.getString("category_name"));
			return categories;
		}
	}
	
	public List<Categories> listAllCategories() {
		String sql="select id, category_name from tbl_category order by id";
		List<Categories> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new CategoryMapper());
		return list;
	}

	public void addCategory(Categories categories) {
		String sql = "insert into tbl_category(category_name)"
				+ " values(:category_name)";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(categories));
	}

	public void updateCategory(Categories categories) {
		String sql = "update tbl_category set category_name =:category_name where id =:id";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(categories));
	}

	public void deleteCategory(int id) {
		String sql = "delete from tbl_category where id =:id";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Categories(id)));
	}

	public Categories findCategoryById(int id) {
		String sql="select id, category_name from tbl_category where id = " +id;
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Categories(id)), new CategoryMapper());
	}

}
