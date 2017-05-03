package com.mpp.group.proj.dao;

import java.util.List;

import com.mpp.group.proj.model.Product;

public interface ProductDao {
	
	public List<Product> listAllProduct();
	public void addProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(int id);
	public Product findProductById(int id);
	
}
