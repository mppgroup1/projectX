package com.mpp.group.proj.model;

public class Categories {

	private int id;
	private String category_name;
	
	public Categories(){
		super();
	}
	
	public Categories(int id){
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
}
