package com.mpp.group.proj.service;

import java.util.List;
import com.mpp.group.proj.model.Breed;

public interface BreedService {

	public List<Breed> listAllBreed();
	public void addBreed(Breed Breed);
	public void updateBreed(Breed Breed);
	public void deleteBreed(int id);
	public Breed findBreedById(int id);
	
}