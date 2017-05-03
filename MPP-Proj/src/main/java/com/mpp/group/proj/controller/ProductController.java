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
import com.mpp.group.proj.model.Product;
import com.mpp.group.proj.service.CategoryService;
import com.mpp.group.proj.service.ProductService;

@Controller
@RequestMapping(value="/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView listProduct(){
		ModelAndView model = new ModelAndView("product/product");
		Product product = new Product();
		
		List<Categories> categories = categoryService.listAllCategories();
		model.addObject("categoryList",categories);
		
		List<Product> list = productService.listAllProduct();
		
		model.addObject("productForm",product);
		model.addObject("listProduct",list);
		
		return model;
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView saveCategory(@ModelAttribute("id") Product product){
		
		if(product != null && product.getId() != 0){
			//update
			productService.updateProduct(product);
		}else{
			productService.addProduct(product);
		}
		
		return new ModelAndView("redirect:/product/");
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(ModelMap model, @RequestParam int id) {
		
		productService.deleteProduct(id);
		Product product = new Product();
		List<Product> list = productService.listAllProduct();
		model.addAttribute("productForm",product);
		model.addAttribute("listProduct",list);
		
		return "product/product";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(ModelMap model, @RequestParam int id) {
		
		List<Categories> categories = categoryService.listAllCategories();
		model.addAttribute("categoryList",categories);
		
		List<Product> list = productService.listAllProduct();
		model.addAttribute("productForm", productService.findProductById(id));
		model.addAttribute("listProduct",list);
		
		return "product/product";
	}
}
