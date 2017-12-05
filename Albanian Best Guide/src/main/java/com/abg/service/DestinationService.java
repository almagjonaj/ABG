package com.abg.service;

import java.io.IOException;
import java.util.List;

import com.abg.model.Destination;

public interface DestinationService {
	
	public List<Destination> listDestinations();
	
	public Destination getDestinationById(String id);
	
	public void addDestination() throws IOException;
	
	public void editDestination() throws IOException;
	
	public void deleteDestination() throws IOException;
	
	public List<Destination> getDestinationList();

	public void setDestinationList(List<Destination> destinationList);
	
	public Destination getDestination();
	
	public void setDestination(Destination destination);
	
	public Destination getSelectedDestination();

	public void setSelectedDestination(Destination selectedDestination);
}
