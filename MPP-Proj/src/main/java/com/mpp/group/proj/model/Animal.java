package com.mpp.group.proj.model;
import java.sql.Date;

public class Animal {
	
	private int id;
	private String name;
	private boolean neutered;
	private Date birth;
	private String color;
	private Specie specie;
	private Breed breed;
	private Microchip microchip;
	private Date deceased;
	private boolean status;	
	private Gender gender;
	
	private int specie_id;	
	private int breed_id;
	private int microchip_id;
	private boolean is_deceased;
		
	
	public boolean isIs_deceased() {
		return is_deceased;
	}
	public void setIs_deceased(boolean is_deceased) {
		this.is_deceased = is_deceased;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isNeutered() {
		return neutered;
	}
	public void setNeutered(boolean neutered) {
		this.neutered = neutered;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Date getDeceased() {
		return deceased;
	}
	public void setDeceased(Date deceased) {
		this.deceased = deceased;
		this.is_deceased = true;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Specie getSpecie() {
		return specie;
	}
	public void setSpecie(Specie specie) {
		this.specie = specie;
		this.specie_id = specie.getId();
	}
	public Breed getBreed() {
		return breed;
	}
	public void setBreed(Breed breed) {
		this.breed = breed;
		this.breed_id = breed.getId();
	}
	public Microchip getMicrochip() {
		return microchip;
	}
	public void setMicrochip(Microchip microchip) {
		this.microchip = microchip;
		this.microchip_id = microchip.getId();
	}
	public int getSpecie_id() {
		return specie_id;
	}
	public void setSpecie_id(int specie_id) {
		this.specie_id = specie_id;
	}
	public int getBreed_id() {
		return breed_id;
	}
	public void setBreed_id(int breed_id) {
		this.breed_id = breed_id;
	}
	public int getMicrochip_id() {
		return microchip_id;
	}
	public void setMicrochip_id(int microchip_id) {
		this.microchip_id = microchip_id;
	}
	public Animal(){}
	
	public Animal(int id){this.id = id;}
	
	public Animal(int id, String name, boolean neutered, Date birth, String color, Date deceased,
			boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.neutered = neutered;
		this.birth = birth;
		this.color = color;
		this.deceased = deceased;
		this.status = status;
		
	}
	
	
	public String toString()
	{
		String str = "[";
		str += " id = " + this.id;
		str += ", name = " + this.name;
		str += ", neutered = " + this.neutered;
		str += ", birth = " + this.birth;
		str += ", color = " + this.color;
		str += ", deceased = " + this.deceased;
		str += ", status = " + this.status;
		str += ", gender = " + this.gender;
		str += ", specie = " + this.specie.getId();
		str += ", microchip = " + this.microchip.getId();
		str += ", breed = " + this.breed.getId() + "]";
		return str;
	}
	
	
	
}
