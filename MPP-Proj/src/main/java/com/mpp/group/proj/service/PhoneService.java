package com.mpp.group.proj.service;

import java.util.List;

import com.mpp.group.proj.model.Phone;

public interface PhoneService {

	public List<Phone> listAllPersonPhone(int pr_id);
	public List<Phone> listAllPhone();
	public void addPhone(Phone phone);
	public void updatePhone(Phone phone);
	public void deletePhone(int id);
	public Phone findPhoneById(int id);
}
