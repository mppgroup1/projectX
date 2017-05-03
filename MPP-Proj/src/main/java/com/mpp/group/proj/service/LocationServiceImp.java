package com.mpp.group.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mpp.group.proj.dao.LocationDao;
import com.mpp.group.proj.model.Location;

@Service
public class LocationServiceImp implements LocationService {
	
    LocationDao locationDao;
	
	@Autowired
	public void setLocationDao(LocationDao LocationDao){
		this.locationDao = LocationDao;
	}

	@Override
	public List<Location> listAllLocation() {
		return locationDao.listAllLocation();
	}

	@Override
	public void addLocation(Location Location) {
		locationDao.addLocation(Location);
	}

	@Override
	public void updateLocation(Location Location) {
		locationDao.updateLocation(Location);
	}

	@Override
	public void deleteLocation(int id) {
		locationDao.deleteLocation(id);
	}

	@Override
	public Location findLocationById(int id) {
		return locationDao.findLocationById(id);
	}

	@Override
	public List<Location> listAllLocation(int id) {
		return locationDao.listAllLocation(id);
	}


}
