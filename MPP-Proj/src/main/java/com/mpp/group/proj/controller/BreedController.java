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
import com.mpp.group.proj.model.Breed;
import com.mpp.group.proj.service.BreedService;

@Controller
@RequestMapping(value="/breed")
public class BreedController {
	
	@Autowired
	BreedService BreedService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView listBreed(){
		ModelAndView model = new ModelAndView("breed/breed");
		
		Breed Breed = new Breed();
		List<Breed> list = BreedService.listAllBreed();
		model.addObject("BreedForm",Breed);
		model.addObject("listBreed",list);
				
		return model;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView saveBreed(@ModelAttribute("id") Breed Breed){
	
		if(Breed != null && Breed.getId() != 0){
			//update
			BreedService.updateBreed(Breed);
		}else{
			BreedService.addBreed(Breed);
		}
		return new ModelAndView("redirect:/breed/");
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteBreed(ModelMap model, @RequestParam int id) {
		
		BreedService.deleteBreed(id);
		Breed Breed = new Breed();
		List<Breed> list = BreedService.listAllBreed();
		model.addAttribute("BreedForm",Breed);
		model.addAttribute("listBreed",list);
			
		return "breed/breed";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateBreed(ModelMap model, @RequestParam int id) {
		
		List<Breed> list = BreedService.listAllBreed();
		Breed a = BreedService.findBreedById(id);
		model.addAttribute("BreedForm", a);
		model.addAttribute("listBreed",list);
				
		return "breed/breed";
	}


}
