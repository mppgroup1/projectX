package com.mpp.group.proj.service;

import java.util.List;

import com.mpp.group.proj.model.Microchip;

public interface MicrochipService {

	public List<Microchip> listAllMicrochip();
	public void addMicrochip(Microchip microchip);
	public void updateMicrochip(Microchip microchip);
	public void deleteMicrochip(int id);
	public Microchip findMicrochipById(int id);
}
