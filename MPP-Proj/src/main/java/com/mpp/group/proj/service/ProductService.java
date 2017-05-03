package com.mpp.group.proj.service;

import java.util.List;

import com.mpp.group.proj.model.Product;

public interface ProductService {
	
	public List<Product> listAllProduct();
	public void addProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(int id);
	public Product findProductById(int id);
	
}
