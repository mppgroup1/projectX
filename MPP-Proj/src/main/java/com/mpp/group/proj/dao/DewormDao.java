package com.mpp.group.proj.dao;

import java.util.List;

import com.mpp.group.proj.model.Deworm;


public interface DewormDao {
	public List<Deworm> listAllDeworm();
	public void addDeworm(Deworm Deworm);
	public void updateDeworm(Deworm Deworm);
	public void deleteDeworm(int id);
	public Deworm findDewormById(int id);
}
