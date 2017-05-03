package com.mpp.group.proj.model;

public class Email {

	private int id;
	private String email;
	private boolean primary;
	private Person person;
	private int person_id;
	
	public Email(int id, String email, boolean primary,Person person) {
		super();
		this.id = id;
		this.email = email;
		this.primary = primary;
		this.person=person;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isPrimary() {
		return primary;
	}



	public void setPrimary(boolean primary) {
		this.primary = primary;
	}



	public Email(){}
		
	public Email(int id) {
		super();
		this.id = id;
	}


	
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

	public String toString()
	{
		String str = "[";
		str += " id = " + this.id;
		str += ", email = " + this.email;
		str += ", primary = " + this.primary + "]";
		return str;
	}
	
	
	
}
