package com.mpp.group.proj.service;

import java.util.List;
import com.mpp.group.proj.model.Email;

public interface EmailService {

	public List<Email> listAllEmail(int id);
	public List<Email> listAllEmail();
	public void addEmail(Email Email);
	public void updateEmail(Email Email);
	public void deleteEmail(int id);
	public Email findEmailById(int id);
	
}
