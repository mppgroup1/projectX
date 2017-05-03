package com.mpp.group.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpp.group.proj.dao.PersonDao;
import com.mpp.group.proj.model.Person;

@Service
public class PersonServiceImpl implements PersonService{

	PersonDao personDao;
	
	@Autowired
	public void setPersonDao(PersonDao personDao){
		this.personDao = personDao;
	}
	
	@Override
	public List<Person> listAllPerson() {
		return personDao.listAllPerson();
	}

	@Override
	public void addPerson(Person person) {
		personDao.addPerson(person);
	}

	@Override
	public void updatePerson(Person person) {
		personDao.updatePerson(person);
	}

	@Override
	public void deletePerson(int id) {
		personDao.deletePerson(id);
	}

	@Override
	public Person findPersonById(int id) {
		return personDao.findPersonById(id);
	}

	@Override
	public List<Person> listAllDoctor() {
		return personDao.listAllDoctor();
	}

}
