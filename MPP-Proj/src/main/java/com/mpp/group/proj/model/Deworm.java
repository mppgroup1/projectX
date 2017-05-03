package com.mpp.group.proj.model;

import java.sql.Date;

public class Deworm {
	private int id;
	private Animal animal;
	private Date date;
	private String name;
	private int doctor_id;
	private int animal_id;
	private Person doctor;
	
	
	public Deworm(int id, Animal animal, Date date, String name, Person doctor) {
		super();
		this.id = id;
		this.animal = animal;
		this.date = date;
		this.name = name;
		this.doctor = doctor;
	}
	public Deworm() {
		super();
	}
	public Deworm(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
		this.animal_id=animal.getId();
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	@Override
	public String toString() {
		return "Deworm [id=" + id + ", animal=" + animal + ", date=" + date + ", name=" + name + ", doctor_id="
				+ doctor_id + "]";
	}
	public int getAnimal_id() {
		return animal_id;
	}
	public void setAnimal_id(int animal_id) {
		this.animal_id = animal_id;
	}
	public Person getDoctor() {
		return doctor;
	}
	public void setDoctor(Person doctor) {
		this.doctor = doctor;
		this.doctor_id= doctor.getId();
	}

	
	
}
