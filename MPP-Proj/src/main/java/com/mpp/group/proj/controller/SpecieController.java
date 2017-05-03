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

import com.mpp.group.proj.model.Specie;
import com.mpp.group.proj.service.SpecieService;

@Controller
@RequestMapping(value="/specie")
public class SpecieController {
	
	@Autowired
	SpecieService SpecieService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView listSpecie(){
		ModelAndView model = new ModelAndView("specie/specie");
		
		Specie Specie = new Specie();
		List<Specie> list = SpecieService.listAllSpecie();
		model.addObject("SpecieForm",Specie);
		model.addObject("listSpecie",list);
				
		return model;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView saveSpecie(@ModelAttribute("id") Specie Specie){
	
		if(Specie != null && Specie.getId() != 0){
			//update
			SpecieService.updateSpecie(Specie);
		}else{
			SpecieService.addSpecie(Specie);
		}
		return new ModelAndView("redirect:/specie/");
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteSpecie(ModelMap model, @RequestParam int id) {
		
		SpecieService.deleteSpecie(id);
		Specie Specie = new Specie();
		List<Specie> list = SpecieService.listAllSpecie();
		model.addAttribute("SpecieForm",Specie);
		model.addAttribute("listSpecie",list);
			
		return "specie/specie";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateSpecie(ModelMap model, @RequestParam int id) {
		
		List<Specie> list = SpecieService.listAllSpecie();
		Specie a = SpecieService.findSpecieById(id);
		model.addAttribute("SpecieForm", a);
		model.addAttribute("listSpecie",list);
				
		return "specie/specie";
	}


}
