package com.mpp.group.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpp.group.proj.dao.MicrochipDao;
import com.mpp.group.proj.model.Microchip;

@Service
public class MicrochipServiceImp  implements MicrochipService{

	MicrochipDao microchipDao;
	
	@Autowired
	public void setMicrochipDao(MicrochipDao MicrochipDao){
		this.microchipDao = MicrochipDao;
	}

	@Override
	public List<Microchip> listAllMicrochip() {
		return microchipDao.listAllMicrochip();
	}

	@Override
	public void addMicrochip(Microchip microchip) {
		microchipDao.addMicrochip(microchip);
	}

	@Override
	public void updateMicrochip(Microchip microchip) {
		microchipDao.updateMicrochip(microchip);
	}

	@Override
	public void deleteMicrochip(int id) {
		microchipDao.deleteMicrochip(id);
	}

	@Override
	public Microchip findMicrochipById(int id) {
		return microchipDao.findMicrochipById(id);
	}

}
