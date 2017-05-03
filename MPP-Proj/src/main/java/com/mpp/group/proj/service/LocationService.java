package com.mpp.group.proj.service;

import java.util.List;
import com.mpp.group.proj.model.Location;

public interface LocationService {
	
	public List<Location> listAllLocation(int id);
	public List<Location> listAllLocation();
	public void addLocation(Location Location);
	public void updateLocation(Location Location);
	public void deleteLocation(int id);
	public Location findLocationById(int id);

}
