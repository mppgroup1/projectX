package com.mpp.group.proj.model;

import org.springframework.security.web.firewall.FirewalledRequest;

public class Doctor extends Person {

    public Doctor(String firstName, String lastName, Title title, char status) {
    	this.lastName = lastName;
    	this.firstName = firstName;
    	this.title = title;
    	this.status = status;
    }

    private int id;
    private String firstName;
    private String lastName;
    private Title title;
    private char status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public char isStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}

    
}