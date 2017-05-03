package com.mpp.group.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpp.group.proj.dao.PhoneDao;
import com.mpp.group.proj.model.Phone;

@Service
public class PhoneServiceImpl implements PhoneService {

	PhoneDao phoneDao;
	
	@Autowired
	public void setPhoneDao(PhoneDao phoneDao){
		this.phoneDao = phoneDao;
	}
	
	@Override
	public List<Phone> listAllPhone() {
		
		return phoneDao.listAllPhone();
	}

	@Override
	public void addPhone(Phone phone) {
		phoneDao.addPhone(phone);
	}

	@Override
	public void updatePhone(Phone phone) {
		phoneDao.updatePhone(phone);
	}

	@Override
	public void deletePhone(int id) {
		phoneDao.deletePhone(id);
	}

	@Override
	public Phone findPhoneById(int id) {
		return phoneDao.findPhoneById(id);
	}

	@Override
	public List<Phone> listAllPersonPhone(int pr_id) {
		
		return phoneDao.listAllPersonPhone(pr_id);
	}

}
