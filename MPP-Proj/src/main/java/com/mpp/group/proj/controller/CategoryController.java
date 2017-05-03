package com.mpp.group.proj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mpp.group.proj.model.Categories;
import com.mpp.group.proj.service.CategoryService;

@Controller
@RequestMapping(value="/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView listCategories(){
		ModelAndView model = new ModelAndView("category/category");
		
		Categories categories = new Categories();
		List<Categories> list = categoryService.listAllCategories();
		model.addObject("categoryForm",categories);
		model.addObject("listCategory",list);
		
		return model;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView saveCategory(@ModelAttribute("id") Categories categories){
	
		if(categories != null && categories.getId() != 0){
			//update
			categoryService.updateCategory(categories);
		}else{
			categoryService.addCategory(categories);
		}
		return new ModelAndView("redirect:/category/");
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(ModelMap model, @RequestParam int id) {
		
		categoryService.deleteCategory(id);
		Categories categories = new Categories();
		List<Categories> list = categoryService.listAllCategories();
		model.addAttribute("categoryForm",categories);
		model.addAttribute("listCategory",list);
		
		return "category/category";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(ModelMap model, @RequestParam int id) {
		
		List<Categories> list = categoryService.listAllCategories();
		model.addAttribute("categoryForm", categoryService.findCategoryById(id));
		model.addAttribute("listCategory",list);
		
		return "category/category";
	}
}
