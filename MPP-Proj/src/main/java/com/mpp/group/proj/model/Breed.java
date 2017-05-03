package com.mpp.group.proj.model;

public class Breed {
	
	private int id;
	private String description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Breed(){}
	public Breed(int id){this.id = id;}
		
	public Breed(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
}
