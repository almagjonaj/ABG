package com.abg.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abg.model.Guide;
import com.abg.security.SessionUtils;
import com.abg.service.BookingHistoryService;
import com.abg.service.CityService;
import com.abg.service.DepartureStationService;
import com.abg.service.DestinationService;
import com.abg.service.GuideService;
import com.abg.service.UserService;
import com.abg.service.UserTypeService;

@Service
public class AdminBean implements Serializable {

	private static final long serialVersionUID = -6788777137299497221L;

	@Autowired
	private BookingHistoryService bookingHistoryService;

	@Autowired
	private CityService cityService;

	@Autowired
	private DepartureStationService departureStationService;

	@Autowired
	private DestinationService destinationService;

	@Autowired
	private GuideService guideService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserTypeService userTypeService;

	private boolean logged = false;

	private boolean showMessage = false;

	private int role;

	private Guide guide;

	@PostConstruct
	public void init() {
		this.cityService.setCityList(this.cityService.listCities());
		this.destinationService.setDestinationList(this.destinationService.listDestinations());
		this.guideService.setGuideList(this.guideService.listGuides());
	}

	private void adminConstruct() {
		this.bookingHistoryService.setBookingHistoryList(this.bookingHistoryService.listBookingHistory());
		this.departureStationService.setDepartureStationList(this.departureStationService.listDepartureStations());
		this.userService.setUserList(this.userService.listUsers());
		this.userTypeService.setUserTypeList(this.userTypeService.listUserTypes());
	}

	private void adminDestroy() {
		this.bookingHistoryService.setBookingHistoryList(null);
		this.departureStationService.setDepartureStationList(null);
		this.userService.setUserList(null);
		this.userTypeService.setUserTypeList(null);
	}

	public void test() {
		System.out.println("TEST");
	}

	public void Rezervo() throws IOException {

		this.bookingHistoryService.getBookingHistory().setUser(this.userService.getLogged_user());

		this.bookingHistoryService.getBookingHistory().setGuide(this.guide);

		this.bookingHistoryService.addBookingHistory();

	}
	
	@Transactional
	public void Register() {
		
	}

	@Transactional
	public void LogIn() throws IOException {

		this.role = userService.UserLog();

		System.out.println("Role: " + this.role);

		this.userService.setSession(SessionUtils.getSession());

		if (this.role == 2) {
			this.logged = true;
			userService.adminLogIn();
			adminConstruct();
		} else if (this.role == 1) {
			this.logged = true;
			userService.userLogIn();
		}

		else {
			this.showMessage = true;
			this.userService.setPassword("");
			RequestContext.getCurrentInstance().execute("PF('logInDialog').show()");
		}
	}

	@Transactional
	public void LogOut() throws IOException {

		this.userService.setLogged_user(null);

		this.userService.setExternalContext(FacesContext.getCurrentInstance().getExternalContext());

		if (this.role == 2) {
			this.userService.adminLogOut();
			adminDestroy();
		}

		else if (this.role == 1) {
			this.userService.userLogOut();
		}

		this.logged = false;

		this.showMessage = false;

		this.role = 0;
	}

	public BookingHistoryService getBookingHistoryService() {
		return bookingHistoryService;
	}

	public void setBookingHistoryService(BookingHistoryService bookingHistoryService) {
		this.bookingHistoryService = bookingHistoryService;
	}

	public CityService getCityService() {
		return cityService;
	}

	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

	public DepartureStationService getDepartureStationService() {
		return departureStationService;
	}

	public void setDepartureStationService(DepartureStationService departureStationService) {
		this.departureStationService = departureStationService;
	}

	public DestinationService getDestinationService() {
		return destinationService;
	}

	public void setDestinationService(DestinationService destinationService) {
		this.destinationService = destinationService;
	}

	public GuideService getGuideService() {
		return guideService;
	}

	public void setGuideService(GuideService guideService) {
		this.guideService = guideService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	public boolean isShowMessage() {
		return showMessage;
	}

	public void setShowMessage(boolean showMessage) {
		this.showMessage = showMessage;
	}

	public UserTypeService getUserTypeService() {
		return userTypeService;
	}

	public void setUserTypeService(UserTypeService userTypeService) {
		this.userTypeService = userTypeService;
	}

}
