package com.mpp.group.proj.service;

import java.util.List;

import com.mpp.group.proj.model.Animal;

public interface AnimalService {
	
	public List<Animal> listAllAnimal();
	public void addAnimal(Animal Animal);
	public void updateAnimal(Animal Animal);
	public void deleteAnimal(int id);
	public Animal findAnimalById(int id);

}
