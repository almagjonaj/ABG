package com.abg.dao;

import java.util.List;

import com.abg.model.DepartureStation;

public interface DepartureStationDAO {
	
	public List<DepartureStation> listDepartureStations();
	
	public boolean addDepartureStation(DepartureStation departure_station);
	
	public boolean editDepartureStation(DepartureStation departure_station);
	
	public boolean deleteDepartureStation(DepartureStation departure_station);

}
