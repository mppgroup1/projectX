package com.mpp.group.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpp.group.proj.dao.DewormDao;
import com.mpp.group.proj.model.Deworm;
@Service
public class DewormServiceImp implements DewormService{
	DewormDao DewormDao;
	
	@Autowired
	public void seDewormDao(DewormDao DewormDao){
		this.DewormDao = DewormDao;
	}
	
	@Override
	public List<Deworm> listAllDeworm() {
		return DewormDao.listAllDeworm();
	}

	@Override
	public void addDeworm(Deworm Deworm) {
		DewormDao.addDeworm(Deworm);
		
	}

	@Override
	public void updateDeworm(Deworm Deworm) {
		DewormDao.updateDeworm(Deworm);
		
	}

	@Override
	public void deleteDeworm(int id) {
		DewormDao.deleteDeworm(id);
		
		
	}

	@Override
	public Deworm findDewormById(int id) {
		// TODO Auto-generated method stub
		return DewormDao.findDewormById(id);
	
	}

}
