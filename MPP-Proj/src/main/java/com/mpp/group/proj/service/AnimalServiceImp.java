package com.mpp.group.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpp.group.proj.dao.AnimalDao;
import com.mpp.group.proj.model.Animal;

@Service
public class AnimalServiceImp implements AnimalService {
	
    AnimalDao AnimalDao;
	
	@Autowired
	public void setAnimalDao(AnimalDao AnimalDao){
		this.AnimalDao = AnimalDao;
	}

	@Override
	public List<Animal> listAllAnimal() {
		return AnimalDao.listAllAnimal();
	}

	@Override
	public void addAnimal(Animal Animal) {
		AnimalDao.addAnimal(Animal);
	}

	@Override
	public void updateAnimal(Animal Animal) {
		AnimalDao.updateAnimal(Animal);
	}

	@Override
	public void deleteAnimal(int id) {
		AnimalDao.deleteAnimal(id);
	}

	@Override
	public Animal findAnimalById(int id) {
		return AnimalDao.findAnimalById(id);
	}


}
