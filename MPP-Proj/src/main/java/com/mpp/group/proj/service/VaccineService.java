package com.mpp.group.proj.service;

import java.util.List;

import com.mpp.group.proj.model.Vaccine;

public interface VaccineService {
	public List<Vaccine> listAllVaccine();
	public void addVaccine(Vaccine Vaccine);
	public void updateVaccine(Vaccine Vaccine);
	public void deleteVaccine(int id);
	public Vaccine findVaccineById(int id);
}
