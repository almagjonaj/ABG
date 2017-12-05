package com.abg.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abg.dao.GuideDAO;
import com.abg.model.Guide;
import com.abg.model.GuideCategory;
import com.abg.service.GuideService;

@Service
public class GuideServiceImpl implements GuideService {

	@Autowired
	private GuideDAO guideDAO;

	private List<Guide> guideList;

	private Guide guide = new Guide();

	private Guide selectedGuide = new Guide();

	private ExternalContext externalContext;

	@Override
	@Transactional
	public List<Guide> listGuides() {
		return this.guideDAO.listGuides();
	}

	@Transactional
	private void update() throws IOException {
		this.guideList = listGuides();
		this.guide = new Guide();
		this.selectedGuide = new Guide();
		this.externalContext = FacesContext.getCurrentInstance().getExternalContext();
		this.externalContext
				.redirect(this.externalContext.getRequestContextPath() + this.externalContext.getRequestServletPath());
	}

	public Guide getGuideById(String id) {
		for (Guide g : guideList) {
			if (g.getIdguide() == Integer.parseInt(id)) {
				return g;
			}
		}
		return null;
	}

	private boolean doesExist(Guide guide) {
		for (Guide g : guideList) {
			if (g.getDeparture_station().getIddeparture_station() == guide.getDeparture_station()
					.getIddeparture_station() && g.getDeparture_time().equals(guide.getDeparture_time())) {
				return true;
			}
		}

		return false;
	}
	
	private void generateGuide() {
		LocalDateTime now = LocalDateTime.now().plusDays(10);
		this.guide.setDeparture_time(now);
		now = now.plusHours(2);
		this.guide.setDestination_arrival_time(now);
		now = now.plusDays(1);
		this.guide.setDestination_leave_time(now);
		now = now.plusHours(2);
		this.guide.setArrival_time(now);
		GuideCategory category = new GuideCategory();
		category.setGuide_category("Eksplorimi i vendeve historike");
		category.setGuide_name("Guida Historike");
		category.setIdguide_category(1);
		this.guide.setGuide_description("");
		this.guide.setGuideCategory(category);
		
	}

	@Override
	@Transactional
	public void addGuide() throws IOException {
		
		generateGuide();

		if (!doesExist(this.guide)) {
			if (this.guideDAO.addGuide(this.guide)) {
				update();
				RequestContext.getCurrentInstance().execute("PF('AddGuideDialog').hide()");
			} else {
				
			}
		}

	}

	@Override
	@Transactional
	public void editGuide() throws IOException {

		if (this.guideDAO.editGuide(this.selectedGuide)) {
			update();
		} else {

		}
	}

	@Override
	@Transactional
	public void deleteGuide() {

		if (this.guideDAO.deleteGuide(this.guide)) {
			
		} else {

		}
	}

	public List<Guide> getAvailableGuides() {
		List<Guide> availableGuides = new ArrayList<>();

		LocalDateTime now = LocalDateTime.now();

		for (Guide g : this.guideList) {
			if (g.getReservation_number() <= g.getMax_reservation_nr() && g.getDeparture_time().isAfter(now)) {
				availableGuides.add(g);
			}
		}
		System.out.println("List size eshte: " + availableGuides.size());
		return availableGuides;
	}

	public GuideDAO getGuideDAO() {
		return guideDAO;
	}

	public void setGuideDAO(GuideDAO guideDAO) {
		this.guideDAO = guideDAO;
	}

	public List<Guide> getGuideList() {
		return guideList;
	}

	public void setGuideList(List<Guide> guideList) {
		this.guideList = guideList;
	}

	public Guide getGuide() {
		return guide;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}

	public Guide getSelectedGuide() {
		return selectedGuide;
	}

	public void setSelectedGuide(Guide selectedGuide) {
		this.selectedGuide = selectedGuide;
	}

}
