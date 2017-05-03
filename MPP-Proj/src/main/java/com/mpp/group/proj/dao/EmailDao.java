package com.mpp.group.proj.dao;

import java.util.List;
import com.mpp.group.proj.model.Email;

public interface EmailDao {

	public List<Email> listAllEmail(int id);
	public List<Email> listAllEmail();
	public void addEmail(Email email);
	public void updateEmail(Email email);
	public void deleteEmail(int id);
	public Email findEmailById(int id);
	
}
