package com.mpp.group.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpp.group.proj.dao.SpecieDao;
import com.mpp.group.proj.model.Specie;

@Service
public class SpecieServiceImpl implements SpecieService {
	
    SpecieDao SpecieDao;
	
	@Autowired
	public void setSpecieDao(SpecieDao SpecieDao){
		this.SpecieDao = SpecieDao;
	}

	@Override
	public List<Specie> listAllSpecie() {
		return SpecieDao.listAllSpecie();
	}

	@Override
	public void addSpecie(Specie Specie) {
		SpecieDao.addSpecie(Specie);
	}

	@Override
	public void updateSpecie(Specie Specie) {
		SpecieDao.updateSpecie(Specie);
	}

	@Override
	public void deleteSpecie(int id) {
		SpecieDao.deleteSpecie(id);
	}

	@Override
	public Specie findSpecieById(int id) {
		return SpecieDao.findSpecieById(id);
	}


}
