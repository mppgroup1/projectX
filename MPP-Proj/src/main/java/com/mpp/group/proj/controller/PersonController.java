package com.mpp.group.proj.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mpp.group.proj.model.Active;
import com.mpp.group.proj.model.Email;
import com.mpp.group.proj.model.Gender;
import com.mpp.group.proj.model.Location;
import com.mpp.group.proj.model.Person;
import com.mpp.group.proj.model.PersonType;
import com.mpp.group.proj.model.Phone;
import com.mpp.group.proj.model.Primary;
import com.mpp.group.proj.model.Title;
import com.mpp.group.proj.service.EmailService;
import com.mpp.group.proj.service.LocationService;
import com.mpp.group.proj.service.PersonService;
import com.mpp.group.proj.service.PhoneService;

@Controller
public class PersonController {

	@Autowired
	PersonService personService;
	
	@Autowired
	PhoneService phoneService;
	
	@Autowired
	LocationService locationService;
	
	@Autowired
	EmailService emailService;
	
	private List<PersonType> personTypeList = new ArrayList<PersonType>(Arrays.asList(PersonType.values()));
	private List<Title> titleList = new ArrayList<Title>(Arrays.asList(Title.values()));
	private List<Gender> genderList = new ArrayList<Gender>(Arrays.asList(Gender.values()));
	private List<Active> activeList = new ArrayList<Active>(Arrays.asList(Active.values()));
	private List<Primary> primaryList = new ArrayList<Primary>(Arrays.asList(Primary.values()));

    @RequestMapping(value="/person", method=RequestMethod.GET)
	public ModelAndView listPerson(){
		ModelAndView model = new ModelAndView("person/person");
		Person person = new Person();
		
		List<Person> personList = personService.listAllPerson();
		
		model.addObject("personForm",person);
		model.addObject("personType",personTypeList);
		model.addObject("titleList",titleList);
		model.addObject("genderList",genderList);
		model.addObject("personList",personList);
		model.addObject("statusList",activeList);
		
		return model;
	}
	
    @RequestMapping(value="/person/email", method=RequestMethod.GET)
	public String listEmail(ModelMap model, @RequestParam int id, @RequestParam int update_id){
		
		Email email; 
		List<Email> list = emailService.listAllEmail(id);
		
		if(update_id!=0)
			email = emailService.findEmailById(update_id);
    	else
    	{
    		email = new Email();
    		email.setPerson_id(id);
    	}
		
		Person person = personService.findPersonById(id);
		String personName = person.getTitle().toString() + " " + 
				person.getFirstName().toUpperCase() + " " + person.getLastName().toUpperCase();
		
		model.addAttribute("personName",personName);
		model.addAttribute("EmailForm",email);
		model.addAttribute("pid", id);
		model.addAttribute("listEmail",list);
				
		return "/person/email";
	}
    
    @RequestMapping(value="/person/location", method=RequestMethod.GET)
	public String listLocation(ModelMap model, @RequestParam int id, @RequestParam int update_id){
		
		Location location; // = new Location();
		List<Location> list = locationService.listAllLocation(id);
		
		if(update_id!=0)
			location = locationService.findLocationById(update_id);
    	else
    	{
    		location = new Location();
    		location.setPerson_id(id);
    	}
		
		Person person = personService.findPersonById(id);
		String personName = person.getTitle().toString() + " " + 
				person.getFirstName().toUpperCase() + " " + person.getLastName().toUpperCase();
		
		model.addAttribute("locationForm",location);
		model.addAttribute("personName",personName);
		model.addAttribute("pid", id);
		model.addAttribute("listLocation",list);
				
		return "/person/location";
	}
	
    @RequestMapping(value="/person/email", method=RequestMethod.POST)
	public String saveEmail(ModelMap model, HttpServletRequest request, 
	        @RequestParam(value="id", required=false) int id, 
	        @RequestParam(value="pid", required=false) int pid, Email email){
    	
		if(email != null && email.getId() != 0){
			emailService.updateEmail(email);
		}else{
			emailService.addEmail(email);
			email.setPerson_id(id);
		}
		
		return "redirect:/person/email?id="+pid+"&update_id=0";
	}
	
    @RequestMapping(value="/person/location", method=RequestMethod.POST)
	public String saveLocation(ModelMap model, HttpServletRequest request, 
	        @RequestParam(value="id", required=false) int id, 
	        @RequestParam(value="pid", required=false) int pid, Location location){
    	
		if(location != null && location.getId() != 0){
			System.out.println("100");
			System.out.println(location);
			System.out.println(location.getPerson_id());
			locationService.updateLocation(location);
		}else{
			locationService.addLocation(location);
			location.setPerson_id(id);
		}
		
		return "redirect:/person/location?id="+pid+"&update_id=0";
	}
    
    @RequestMapping(value="/person/phone", method=RequestMethod.GET)
	public String showPhone(ModelMap model, @RequestParam int id, @RequestParam int update_id) {

    	Phone phone; // = new Phone();
    	
    	if(update_id!=0)
    		phone = phoneService.findPhoneById(update_id);
    	else
    		phone = new Phone();
    	
		List<Phone> phoneList = phoneService.listAllPersonPhone(id);
		Person person = personService.findPersonById(id);
		
		String personName = person.getTitle().toString() + " " + 
				person.getFirstName().toUpperCase() + " " + person.getLastName().toUpperCase();
		model.addAttribute("phoneForm", phone);
		model.addAttribute("pid", id);
		model.addAttribute("phonePrimary", primaryList);
		model.addAttribute("personName",personName);
		model.addAttribute("listPhones",phoneList);
		
		return "/person/phone";
	}
    
	@RequestMapping(value="/person/phone", method=RequestMethod.POST)
	public String savePersonPhone1(ModelMap model, HttpServletRequest request, 
	        @RequestParam(value="id", required=false) int id, 
	        @RequestParam(value="pid", required=false) int pid, Phone phone){ 
		
		if(phone != null && phone.getId() != 0){
			phoneService.updatePhone(phone);
		}else{
			phoneService.addPhone(phone);
		}
		
		return "redirect:/person/phone?id="+pid+"&update_id=0";
	}
	
	/*@RequestMapping(value="/person/email/delete", method=RequestMethod.GET)
	public String deleteEmail(ModelMap model, HttpServletRequest request, 
	        @RequestParam(value="id", required=false) int id, 
	        @RequestParam(value="pid", required=false) int pid, Phone phone){ 
		
		emailService.deleteEmail(id);
		
		return "redirect:/person/email?id="+pid+"&update_id=0";
	}*/
	
	@RequestMapping(value="/person/location/delete", method=RequestMethod.GET)
	public String deleteEmail(ModelMap model, HttpServletRequest request, 
	        @RequestParam(value="id", required=false) int id, 
	        @RequestParam(value="pid", required=false) int pid, Location location){ 
		
		locationService.deleteLocation(id);
		
		return "redirect:/person/location?id="+pid+"&update_id=0";
	}
	
	@RequestMapping(value="/person/email/delete", method=RequestMethod.GET)
	public String deleteEmail(ModelMap model, HttpServletRequest request, 
	        @RequestParam(value="id", required=false) int id, 
	        @RequestParam(value="pid", required=false) int pid, Email email){ 
		
		emailService.deleteEmail(id);
		
		return "redirect:/person/email?id="+pid+"&update_id=0";
	}
	
	@RequestMapping(value="/person/phone/delete", method=RequestMethod.GET)
	public String deletePersonPhone(ModelMap model, HttpServletRequest request, 
	        @RequestParam(value="id", required=false) int id, 
	        @RequestParam(value="pid", required=false) int pid, Phone phone){ 
		
		phoneService.deletePhone(id);
		
		return "redirect:/person/phone?id="+pid+"&update_id=0";
	}
    
	@RequestMapping(value="/person/phone/update", method=RequestMethod.GET)
	public String updatePhone(ModelMap model, @RequestParam int id) {
		
		System.out.println("117 "+id);
		Phone phone = phoneService.findPhoneById(id);
    	
		List<Phone> phoneList = phoneService.listAllPersonPhone(phone.getPid());
		Person person = personService.findPersonById(phone.getPid());
		
		String personName = person.getFirstName().toUpperCase() + " " + person.getLastName().toUpperCase();
		model.addAttribute("phoneForm", phone);
		model.addAttribute("pid", phone.getPid());
		model.addAttribute("phonePrimary", primaryList);
		model.addAttribute("personName",personName);
		model.addAttribute("listPhones",phoneList);
		
		return "/person/phone";
	}
	
	@RequestMapping(value="/person/update", method=RequestMethod.GET)
	public String update(ModelMap model, @RequestParam int id) {
		
		List<Person> personList = personService.listAllPerson();
		
		model.addAttribute("personForm", personService.findPersonById(id));
		model.addAttribute("personType",personTypeList);
		model.addAttribute("titleList",titleList);
		model.addAttribute("genderList",genderList);
		model.addAttribute("personList",personList);
		model.addAttribute("statusList",activeList);
		
		return "/person/person";
	}
	
	@RequestMapping(value="/person/delete", method=RequestMethod.GET)
	public String delete(ModelMap model, @RequestParam int id) {
		
		personService.deletePerson(id);
		List<Person> personList = personService.listAllPerson();
		Person person = new Person();
		model.addAttribute("personForm", person);
		model.addAttribute("personType",personTypeList);
		model.addAttribute("titleList",titleList);
		model.addAttribute("genderList",genderList);
		model.addAttribute("personList",personList);
		model.addAttribute("statusList",activeList);
		
		return "/person/person";
	}
	
	@RequestMapping(value="/person", method=RequestMethod.POST)
	public ModelAndView savePerson(@ModelAttribute("id") Person person){
		if(person != null && person.getId() != 0){
			personService.updatePerson(person);
		}else{
			personService.addPerson(person);
		}
		
		return new ModelAndView("redirect:/person/");
	}

}
