package com.abg.service;

import java.io.IOException;
import java.util.List;

import com.abg.model.DepartureStation;

public interface DepartureStationService {
	
	public List<DepartureStation> listDepartureStations();
	
	public DepartureStation getDepartureStationById(String id);
	
	public void addDepartureStation() throws IOException;
	
	public void editDepartureStation() throws IOException;
	
	public void deleteDepartureStation() throws IOException;
	
	public List<DepartureStation> getDepartureStationList();

	public void setDepartureStationList(List<DepartureStation> departureStationList);
	
	public DepartureStation getDepartureStation();

	public void setDepartureStation(DepartureStation departureStation);
	
	public DepartureStation getSelectedDepartureStation();

	public void setSelectedDepartureStation(DepartureStation selectedDepartureStation);

}
