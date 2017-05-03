package com.mpp.group.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.mpp.group.proj.config.GetCurrentUser;

@Controller
public class AdminController {
	
	@Autowired
	GetCurrentUser getCurrentUser;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		if(getCurrentUser.getLoggedInUserName()  != null){
			return "home";
		}
		
		return "login";
	}

}
