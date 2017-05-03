package com.mpp.group.proj.model;


import java.util.*;

public class Customer extends Person {

	public Customer(String firstName, String lastName, Title title, String status) {
		this.lastName = lastName;
    	this.firstName = firstName;
    	this.title = title;
    	this.status = status;
    }

    private int id;
    private String lastName;
    private String firstName;
    private Title title;
    private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

    
}
