package com.mpp.group.proj.dao;

import java.util.List;

import com.mpp.group.proj.model.Animal;

public interface AnimalDao {
	
	public List<Animal> listAllAnimal();
	public void addAnimal(Animal Animal);
	public void updateAnimal(Animal Animal);
	public void deleteAnimal(int id);
	public Animal findAnimalById(int id);

}
