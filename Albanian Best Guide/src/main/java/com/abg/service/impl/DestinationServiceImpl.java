package com.abg.service.impl;

import java.io.IOException;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abg.dao.DestinationDAO;
import com.abg.model.Destination;
import com.abg.service.DestinationService;

@Service
public class DestinationServiceImpl implements DestinationService {

	@Autowired
	private DestinationDAO destinationDAO;

	private List<Destination> destinationList;

	private Destination destination = new Destination();

	private Destination selectedDestination = new Destination();

	private ExternalContext externalContext;

	@Override
	@Transactional
	public List<Destination> listDestinations() {
		return this.destinationDAO.listDestinations();
	}

	@Transactional
	private void update() throws IOException {
		this.destinationList = listDestinations();
		this.destination = new Destination();
		this.selectedDestination = new Destination();
		this.externalContext = FacesContext.getCurrentInstance().getExternalContext();
		this.externalContext
				.redirect(this.externalContext.getRequestContextPath() + this.externalContext.getRequestServletPath());
	}

	public Destination getDestinationById(String id) {
		for (Destination d : destinationList) {
			if (d.getIddestination() == Integer.parseInt(id)) {
				return d;
			}
		}
		return null;
	}

	private boolean doesExist(Destination destination) {
		for (Destination d : destinationList) {
			if (d.getDestination_address().equals(destination.getDestination_address())
					&& d.getCity().getIdcity() == destination.getCity().getIdcity()) {
				return true;
			}
		}
		return false;
	}

	@Override
	@Transactional
	public void addDestination() throws IOException {

		if (!doesExist(this.destination)) {
			if (this.destinationDAO.addDestination(this.destination)) {
				update();
				RequestContext.getCurrentInstance().execute("PF('AddDestinationDialog').hide()");
			} else {

			}
		} else {
			
		}
	}

	@Override
	@Transactional
	public void editDestination() throws IOException {

		if (this.destinationDAO.editDestination(this.selectedDestination)) {
			update();
		} else {

		}
	}

	@Override
	@Transactional
	public void deleteDestination() throws IOException {

		if (this.destinationDAO.deleteDestination(this.destination)) {
			update();
		} else {

		}
	}
	
	public DestinationDAO getDestinationDAO() {
		return destinationDAO;
	}

	public void setDestinationDAO(DestinationDAO destinationDAO) {
		this.destinationDAO = destinationDAO;
	}

	public List<Destination> getDestinationList() {
		return destinationList;
	}

	public void setDestinationList(List<Destination> destinationList) {
		this.destinationList = destinationList;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Destination getSelectedDestination() {
		return selectedDestination;
	}

	public void setSelectedDestination(Destination selectedDestination) {
		this.selectedDestination = selectedDestination;
	}
}
