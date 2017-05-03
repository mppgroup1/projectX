package com.mpp.group.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpp.group.proj.dao.CategoryDao;
import com.mpp.group.proj.model.Categories;

@Service
public class CategoryServiceImp implements CategoryService {

	CategoryDao categoryDao;
	
	@Autowired
	public void setCategoryDao(CategoryDao categoryDao){
		this.categoryDao = categoryDao;
	}

	@Override
	public List<Categories> listAllCategories() {
		return categoryDao.listAllCategories();
	}

	@Override
	public void addCategory(Categories categories) {
		categoryDao.addCategory(categories);
	}

	@Override
	public void updateCategory(Categories categories) {
		categoryDao.updateCategory(categories);
	}

	@Override
	public void deleteCategory(int id) {
		categoryDao.deleteCategory(id);
	}

	@Override
	public Categories findCategoryById(int id) {
		return categoryDao.findCategoryById(id);
	}

}
