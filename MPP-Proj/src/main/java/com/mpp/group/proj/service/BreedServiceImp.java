package com.mpp.group.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpp.group.proj.dao.BreedDao;
import com.mpp.group.proj.model.Breed;

@Service
public class BreedServiceImp implements BreedService {
	
    BreedDao BreedDao;
	
	@Autowired
	public void setBreedDao(BreedDao BreedDao){
		this.BreedDao = BreedDao;
	}

	@Override
	public List<Breed> listAllBreed() {
		return BreedDao.listAllBreed();
	}

	@Override
	public void addBreed(Breed Breed) {
		BreedDao.addBreed(Breed);
	}

	@Override
	public void updateBreed(Breed Breed) {
		BreedDao.updateBreed(Breed);
	}

	@Override
	public void deleteBreed(int id) {
		BreedDao.deleteBreed(id);
	}

	@Override
	public Breed findBreedById(int id) {
		return BreedDao.findBreedById(id);
	}


}
