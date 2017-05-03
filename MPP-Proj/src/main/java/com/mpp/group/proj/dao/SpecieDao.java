package com.mpp.group.proj.dao;

import java.util.List;

import com.mpp.group.proj.model.Specie;

public interface SpecieDao {

	public List<Specie> listAllSpecie();
	public void addSpecie(Specie Specie);
	public void updateSpecie(Specie Specie);
	public void deleteSpecie(int id);
	public Specie findSpecieById(int id);
	
}