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

import com.mpp.group.proj.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
			throws DataAccessException{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	private SqlParameterSource getSqlParameterByModel(Product product){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		
		if(product!=null){
			paramSource.addValue("id", product.getId());
			paramSource.addValue("category_id", product.getCategory_id());
			paramSource.addValue("product_code", product.getProduct_code());
			paramSource.addValue("product_name", product.getProduct_name());
			paramSource.addValue("uom", product.getUom());
		}
		return paramSource;
	}
	
	private static final class ProductMapper implements RowMapper<Product>{
		
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException{
			Product product = new Product();
			product.setId(rs.getInt("id"));
			product.setCategory_id(rs.getInt("category_id"));
			product.setProduct_code(rs.getString("product_code"));
			product.setProduct_name(rs.getString("product_name"));
			product.setUom(rs.getString("uom"));
			
			return product;
		}
	}
	
	public List<Product> listAllProduct() {
		String sql="select id, category_id, product_code, product_name, uom from tbl_product order by id";
		List<Product> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new ProductMapper());
		return list;
	}

	public void addProduct(Product product) {
		
		String sql = "insert into tbl_product(category_id, product_code, product_name, uom)"
				+ " values(:category_id,:product_code,:product_name,:uom)";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(product));
	}

	public void updateProduct(Product product) {
		String sql = "update tbl_product set category_id =:category_id, product_name =:product_name, product_code =:product_code, uom =:uom where id =:id";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(product));
	}

	public void deleteProduct(int id) {
		String sql = "delete from tbl_product where id =:id";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Product(id)));
	}

	public Product findProductById(int id) {
		String sql="select id, category_id, product_code, product_name, uom from tbl_product where id = " +id;
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Product(id)), new ProductMapper());
	}
}
