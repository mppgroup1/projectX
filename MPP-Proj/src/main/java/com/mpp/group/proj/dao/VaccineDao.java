package com.mpp.group.proj.dao;

import java.util.List;

import com.mpp.group.proj.model.Vaccine;


public interface VaccineDao {
	
	public List<Vaccine> listAllVaccine();
	public void addVaccine(Vaccine Vaccine);
	public void updateVaccine(Vaccine Vaccine);
	public void deleteVaccine(int id);
	public Vaccine findVaccineById(int id);
}
