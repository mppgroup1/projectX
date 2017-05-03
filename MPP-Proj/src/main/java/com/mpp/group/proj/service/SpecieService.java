package com.mpp.group.proj.service;

import java.util.List;

import com.mpp.group.proj.model.Specie;

public interface SpecieService {

	public List<Specie> listAllSpecie();
	public void addSpecie(Specie Specie);
	public void updateSpecie(Specie Specie);
	public void deleteSpecie(int id);
	public Specie findSpecieById(int id);
	
}