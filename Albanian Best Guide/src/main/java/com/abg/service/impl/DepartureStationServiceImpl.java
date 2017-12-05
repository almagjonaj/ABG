package com.abg.service.impl;

import java.io.IOException;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abg.dao.DepartureStationDAO;
import com.abg.model.DepartureStation;
import com.abg.service.DepartureStationService;

@Service
public class DepartureStationServiceImpl implements DepartureStationService {

	@Autowired
	private DepartureStationDAO departureStationDAO;

	private List<DepartureStation> departureStationList;

	private DepartureStation departureStation = new DepartureStation();

	private DepartureStation selectedDepartureStation = new DepartureStation();

	private ExternalContext externalContext;

	@Override
	@Transactional
	public List<DepartureStation> listDepartureStations() {
		return this.departureStationDAO.listDepartureStations();
	}

	@Transactional
	private void update() throws IOException {
		this.departureStationList = listDepartureStations();
		this.departureStation = new DepartureStation();
		this.selectedDepartureStation = new DepartureStation();
		this.externalContext = FacesContext.getCurrentInstance().getExternalContext();
		this.externalContext
				.redirect(this.externalContext.getRequestContextPath() + this.externalContext.getRequestServletPath());

	}

	public DepartureStation getDepartureStationById(String id) {
		for (DepartureStation s : departureStationList) {
			if (s.getIddeparture_station() == Integer.parseInt(id)) {
				return s;
			}
		}
		return null;
	}

	private boolean doesExist(DepartureStation station) {
		for (DepartureStation s : departureStationList) {
			if (s.getCity().getIdcity() == station.getCity().getIdcity()
					&& s.getStation_address().equals(station.getStation_address())) {
				return true;
			}
		}
		return false;
	}

	@Override
	@Transactional
	public void addDepartureStation() throws IOException {

		if (!doesExist(this.departureStation)) {
			if (this.departureStationDAO.addDepartureStation(this.departureStation)) {
				update();
				RequestContext.getCurrentInstance().execute("PF('AddDepartureStationDialog').hide()");
			} else {

			}
		} else {

		}
	}

	@Override
	@Transactional
	public void editDepartureStation() throws IOException {

		if (this.departureStationDAO.editDepartureStation(this.selectedDepartureStation)) {
			update();
		} else {

		}
	}

	@Override
	@Transactional
	public void deleteDepartureStation() throws IOException {

		if (this.departureStationDAO.deleteDepartureStation(this.departureStation)) {
			update();
		} else {

		}
	}

	public DepartureStationDAO getDepartureStationDAO() {
		return departureStationDAO;
	}

	public void setDepartureStationDAO(DepartureStationDAO departureStationDAO) {
		this.departureStationDAO = departureStationDAO;
	}

	public List<DepartureStation> getDepartureStationList() {
		return departureStationList;
	}

	public void setDepartureStationList(List<DepartureStation> departureStationList) {
		this.departureStationList = departureStationList;
	}

	public DepartureStation getDepartureStation() {
		return departureStation;
	}

	public void setDepartureStation(DepartureStation departureStation) {
		this.departureStation = departureStation;
	}

	public DepartureStation getSelectedDepartureStation() {
		return selectedDepartureStation;
	}

	public void setSelectedDepartureStation(DepartureStation selectedDepartureStation) {
		this.selectedDepartureStation = selectedDepartureStation;
	}

}
