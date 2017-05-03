package com.mpp.group.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpp.group.proj.dao.VaccineDao;
import com.mpp.group.proj.model.Vaccine;

@Service
public class VaccineServiceImp implements VaccineService{
	VaccineDao vaccineDao;
	
	@Autowired
	public void setVaccineDao(VaccineDao vaccineDao){
		this.vaccineDao = vaccineDao;
	}
	@Override
	public List<Vaccine> listAllVaccine() {
		return vaccineDao.listAllVaccine();
	}

	@Override
	public void addVaccine(Vaccine Vaccine) {
		vaccineDao.addVaccine(Vaccine);
		
	}

	@Override
	public void updateVaccine(Vaccine Vaccine) {
		vaccineDao.updateVaccine(Vaccine);
		
	}

	@Override
	public void deleteVaccine(int id) {
		vaccineDao.deleteVaccine(id);
		
	}

	@Override
	public Vaccine findVaccineById(int id) {
		// TODO Auto-generated method stub
		return vaccineDao.findVaccineById(id);
	}

}
