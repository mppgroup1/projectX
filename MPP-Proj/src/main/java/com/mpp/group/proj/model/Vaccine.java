package com.mpp.group.proj.model;

import java.sql.Date;

public class Vaccine {

private int id;
private Animal animal;
private Date date;
private String name;
private String batch;
private Person doctor;
private int doctor_id;
private int animal_id;



public Vaccine() {
	super();
}
public Vaccine(int id) {
	super();
	this.id=id;
}


public Vaccine(int id, Animal animal,Date date, String name, String batch,Person doctor) {
	super();
	this.id=id;
	this.animal=animal;
	this.date = date;
	this.name = name;
	this.batch = batch;
	this.doctor= doctor;
}

public Date getDate() {
	return date;
}



public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
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


public String getBatch() {
	return batch;
}


public void setBatch(String batch) {
	this.batch = batch;
}


public Animal getAnimal() {
	return animal;
}


public void setAnimal(Animal animal) {
	this.animal = animal;
	this.animal_id= animal.getId();
}
public int getDoctor_id() {
	return doctor_id;
}
public void setDoctor_id(int doctor_id) {
	this.doctor_id = doctor_id;
}
@Override
public String toString() {
	return "Vaccine [id=" + id + ", animal_id=" + animal + ", date=" + date + ", name=" + name + ", batch=" + batch
			+ ", doctor_id=" + doctor_id + "]";
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
