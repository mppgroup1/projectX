package com.mpp.group.proj.service;

import java.util.List;

import com.mpp.group.proj.model.Categories;

public interface CategoryService {
	
	public List<Categories> listAllCategories();
	public void addCategory(Categories categories);
	public void updateCategory(Categories categories);
	public void deleteCategory(int id);
	public Categories findCategoryById(int id);
	
}
