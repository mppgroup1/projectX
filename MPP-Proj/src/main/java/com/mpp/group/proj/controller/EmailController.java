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
import com.mpp.group.proj.model.Email;
import com.mpp.group.proj.model.Person;
import com.mpp.group.proj.service.EmailService;
import com.mpp.group.proj.service.PersonService;

@Controller
@RequestMapping(value="/email")
public class EmailController {
	
	@Autowired
	EmailService EmailService;
	
	@Autowired
	PersonService PersonService; 
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView listEmail(){
		ModelAndView model = new ModelAndView("email/email");
		
		Email Email = new Email();
		List<Email> list = EmailService.listAllEmail();
		List<Person> persons = PersonService.listAllPerson();
		
		model.addObject("EmailForm",Email);
		model.addObject("listEmail",list);
		model.addObject("PersonList",persons);
				
		return model;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView saveEmail(@ModelAttribute("id") Email Email){
	
		if(Email != null && Email.getId() != 0){
			//update
			EmailService.updateEmail(Email);
		}else{
			EmailService.addEmail(Email);
		}
		return new ModelAndView("redirect:/email/");
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteEmail(ModelMap model, @RequestParam int id) {
		
		EmailService.deleteEmail(id);
		Email Email = new Email();
		List<Email> list = EmailService.listAllEmail();
		model.addAttribute("EmailForm",Email);
		model.addAttribute("listEmail",list);
			
		return "email/email";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateEmail(ModelMap model, @RequestParam int id) {
		
		List<Email> list = EmailService.listAllEmail();
		List<Person> persons = PersonService.listAllPerson();
		
		Email a = EmailService.findEmailById(id);
		model.addAttribute("EmailForm", a);
		model.addAttribute("listEmail",list);
		model.addAttribute("PersonList",persons);
		
		return "email/email";
	}


}
