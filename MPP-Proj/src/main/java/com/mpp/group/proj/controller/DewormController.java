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

import com.mpp.group.proj.model.Animal;
import com.mpp.group.proj.model.Deworm;
import com.mpp.group.proj.model.Person;
import com.mpp.group.proj.model.Vaccine;
import com.mpp.group.proj.service.DewormService;
import com.mpp.group.proj.service.PersonService;
import com.mpp.group.proj.service.AnimalService;

@Controller
@RequestMapping(value="/deworm")
public class DewormController {
	@Autowired
	DewormService DewormService;
	
	@Autowired
	AnimalService AnimalService;
	
	@Autowired
	PersonService PersonService; 

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView listDeworm(){
		
	//	System.out.println("listado!!");
		ModelAndView model = new ModelAndView("deworm/deworm");
		Deworm deworm = new Deworm();

		List<Animal> animals = AnimalService.listAllAnimal();
		List<Deworm> list = DewormService.listAllDeworm();
		List<Person> doctors = PersonService.listAllDoctor();
		
		model.addObject("dewormForm",deworm);
		model.addObject("listdeworm",list);
		model.addObject("AnimalList",animals);
		model.addObject("DoctorList",doctors);
		
		return model;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	
	public ModelAndView saveDeworm(@ModelAttribute("id") Deworm Deworm){
		    
		if(Deworm != null && Deworm.getId() != 0){
			//update
			DewormService.updateDeworm(Deworm);
		}else{
			DewormService.addDeworm(Deworm);
		}
		return new ModelAndView("redirect:/deworm/");
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteDeworm(ModelMap model, @RequestParam int id) {
		
		DewormService.deleteDeworm(id);
		Deworm Deworm = new Deworm();
		List<Deworm> list = DewormService.listAllDeworm();

		model.addAttribute("dewormForm",Deworm);
		model.addAttribute("listdeworm",list);
		
		return "deworm/deworm";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateDeworm(ModelMap model, @RequestParam int id) {
		
		List<Deworm> list = DewormService.listAllDeworm();
		List<Animal> animals = AnimalService.listAllAnimal();
		List<Person> doctors = PersonService.listAllDoctor();
		Deworm a = DewormService.findDewormById(id);
		
		model.addAttribute("dewormForm", a);
		model.addAttribute("listdeworm",list);
		model.addAttribute("AnimalList",animals);
		model.addAttribute("DoctorList",doctors);
		
		return "deworm/deworm";
	}
}
