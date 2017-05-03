package com.mpp.group.proj.model;

import java.util.ArrayList;
import java.util.List;

public class Person {

	public Person(){}
	public Person(int id){
		this.id = id;
	}
	
    public Person(String lastName, String firstName, Title title, 
    		String status, Gender gender, int type) {
    	this.lastName = lastName;
    	this.firstName = firstName;
    	this.title = title;
    	this.status = status;
    	this.type = type;
    	this.gender = gender;
    }

    private int id;
    private String lastName;
    private Title title;
    private String firstName;
    private Gender gender;
    private String status;
    private int type;
    private List<Phone> listOfPhones = new ArrayList<>();
    private List<Location> listOfLocations = new ArrayList<>();
    private List<Email> listOfEmails  = new ArrayList<>();
    
    public void addPhone(Phone phone){
    	listOfPhones.add(phone);
    }
    
    public Phone getPhone(int indx){
    	return listOfPhones.get(indx);
    }
    
    public List getListOfPhone(){
    	return listOfPhones;
    }
    
    public void addLocations(Location location){
    	listOfLocations.add(location);
    }
    
    public List getListOfLocations(){
    	return listOfLocations;
    }
    
    public Location getLocation(int indx){
    	return listOfLocations.get(indx);
    }
    
    public void addEmail(Email email){
    	listOfEmails.add(email);
    }
    
    public List getListOfEmail(){
    	return listOfEmails;
    }
    
    public Email getEmail(int indx){
    	return listOfEmails.get(indx);
    }

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

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public String getFullName() {
		return title + " "+ firstName+" "+lastName;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public void setType(int type) {
		this.type = type;
	}
    
	@Override
    public String toString(){
        return id + " " + type + " " + getTitle() + " " + firstName +" "+ lastName + 
        		getGender() + " " + getStatus();
        
    }
}