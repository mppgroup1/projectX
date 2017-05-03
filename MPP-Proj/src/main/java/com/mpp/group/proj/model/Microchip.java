package com.mpp.group.proj.model;


import java.sql.Date;

public class Microchip {
	
	private int id;
	private String description;
	private String brand;
	private Date implantDate;
	private ImplantSite implantSite;
	
	
	
	public Microchip() {
		super();
	}
	
	public Microchip(int id){
		this.id=id;
	}

	public Microchip(int id,String description){
		this.id=id;
		this.description = description;
	}
	
	public Microchip(int id , String description, String brand, Date implantDate, ImplantSite implantSite) {
		super();
		this.id= id;
		this.description = description;
		this.brand = brand;
		this.implantDate = implantDate;
		this.implantSite = implantSite;
	}
	
	
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Date getImplantDate() {
		return implantDate;
	}
	public void setImplantDate(Date implantDate) {

		this.implantDate = implantDate;
	}
	public ImplantSite getImplantSite() {
		return implantSite;
	}
	public void setImplantSite(ImplantSite implantSite) {
		this.implantSite = implantSite;
	}

	@Override
	public String toString() {
		return "Microchip [id=" + id + ", description=" + description + ", brand=" + brand + ", implantDate="
				+ implantDate + ", implantSite=" + implantSite + "]";
	}
	
	
}
