package com.mpp.group.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpp.group.proj.dao.ProductDao;
import com.mpp.group.proj.model.Product;

@Service
public class ProductServiceImp implements ProductService {

	ProductDao productDao;
	
	@Autowired
	public void setProductDao(ProductDao productDao){
		this.productDao = productDao;
	}

	@Override
	public List<Product> listAllProduct() {
		return productDao.listAllProduct();
	}

	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	@Override
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	@Override
	public void deleteProduct(int id) {
		productDao.deleteProduct(id);
	}

	@Override
	public Product findProductById(int id) {
		return productDao.findProductById(id);
	}

}
