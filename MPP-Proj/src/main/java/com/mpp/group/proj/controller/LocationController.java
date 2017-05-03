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
import com.mpp.group.proj.model.*;
import com.mpp.group.proj.service.LocationService;
import com.mpp.group.proj.service.PersonService;

@Controller
@RequestMapping(value="/location")
public class LocationController {
	
	@Autowired
	LocationService locationService;
	@Autowired
	PersonService PersonService; 
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView listLocation(){
		ModelAndView model = new ModelAndView("location/location");
		
		Location location = new Location();
		List<Location> list = locationService.listAllLocation();
		List<Person> persons = PersonService.listAllPerson();
		model.addObject("locationForm",location);
		model.addObject("listLocation",list);
		model.addObject("PersonList",persons);
				
		return model;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView saveLocation(@ModelAttribute("id") Location location){
			
		if(location != null && location.getId() != 0){
			//update
			locationService.updateLocation(location);
		}else{
			locationService.addLocation(location);
		}
		return new ModelAndView("redirect:/location/");
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteLocation(ModelMap model, @RequestParam int id) {
		
		locationService.deleteLocation(id);
		Location location = new Location();
		List<Location> list = locationService.listAllLocation();
		List<Person> persons = PersonService.listAllPerson();		
		model.addAttribute("locationForm",location);
		model.addAttribute("listLocation",list);
		model.addAttribute("PersonList",persons);
				
		return "location/location";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateLocation(ModelMap model, @RequestParam int id) {
		
		List<Location> list = locationService.listAllLocation();
		List<Person> persons = PersonService.listAllPerson();
		Location l = locationService.findLocationById(id);
		model.addAttribute("locationForm", l);
		model.addAttribute("listLocation",list);
		model.addAttribute("PersonList",persons);
				
		return "location/location";
	}


}
