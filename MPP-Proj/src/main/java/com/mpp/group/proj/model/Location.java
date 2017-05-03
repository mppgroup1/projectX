package com.mpp.group.proj.model;

public class Location {
	
	private int id;
	private String address;
	private String city;
	private String state;
	private int zipcode;
	private String country;
	private boolean primary;
	private Person person;
	private int person_id;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
		this.person_id=person.getId();
	}
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public boolean isPrimary() {
		return primary;
	}
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	
	public Location(){}
	public Location(int id) {
		super();
		this.id = id;
	}
	
	public Location(int id, String address, String city, String state, int zipcode, String country, boolean primary) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
		this.primary = primary;
	}
	
	
	public String toString()
	{
		String str = "[";
		str += " id = " + this.id;
		str += ", address = " + this.address;
		str += ", city = " + this.city;
		str += ", state = " + this.state;
		str += ", zipcode = " + this.zipcode;
		str += ", country = " + this.country;
		str += ", primary = " + this.primary + "]";
		return str;
	}

	

}
