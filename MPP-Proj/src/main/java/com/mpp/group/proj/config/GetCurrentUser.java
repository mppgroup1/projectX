package com.mpp.group.proj.config;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class GetCurrentUser {

	private String currentUser = null;
	//private GetCurrentUser getCurrentUser;
	
	public GetCurrentUser(){}
	
	public String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails){
			this.currentUser = principal.toString();
		}

		return currentUser;
	}
	
	public String getCurrentUserLogedin(){
		return currentUser;
	}
	
	public void logoutUser(){
		currentUser = null;
	}
}
