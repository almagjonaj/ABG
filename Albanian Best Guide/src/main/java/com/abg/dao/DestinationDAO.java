package com.abg.dao;

import java.util.List;

import com.abg.model.Destination;

public interface DestinationDAO {
	
	public List<Destination> listDestinations();
	
	public boolean addDestination(Destination destination);
	
	public boolean editDestination(Destination destination);
	
	public boolean deleteDestination(Destination destination);
	
}
