package com.mpp.group.proj.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mpp.group.proj.dao.EmailDao;
import com.mpp.group.proj.model.Email;

@Service
public class EmailServiceImp implements EmailService {
	
    EmailDao emailDao;
	
	@Autowired
	public void setEmailDao(EmailDao EmailDao){
		this.emailDao = EmailDao;
	}

	@Override
	public List<Email> listAllEmail() {
		return emailDao.listAllEmail();
	}

	@Override
	public List<Email> listAllEmail(int id) {
		return emailDao.listAllEmail(id);
	}
	
	@Override
	public void addEmail(Email Email) {
		emailDao.addEmail(Email);
	}

	@Override
	public void updateEmail(Email Email) {
		emailDao.updateEmail(Email);
	}

	@Override
	public void deleteEmail(int id) {
		emailDao.deleteEmail(id);
	}

	@Override
	public Email findEmailById(int id) {
		return emailDao.findEmailById(id);
	}
}
