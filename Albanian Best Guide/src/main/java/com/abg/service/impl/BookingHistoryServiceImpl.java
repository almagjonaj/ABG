package com.abg.service.impl;

import java.io.IOException;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abg.dao.BookingHistoryDAO;
import com.abg.model.BookingHistory;
import com.abg.service.BookingHistoryService;

@Service
public class BookingHistoryServiceImpl implements BookingHistoryService {

	@Autowired
	private BookingHistoryDAO bookingHistoryDAO;

	private List<BookingHistory> bookingHistoryList;

	private BookingHistory bookingHistory = new BookingHistory();

	private BookingHistory selectedBookingHistory = new BookingHistory();

	private ExternalContext externalContext;

	@Override
	@Transactional
	public List<BookingHistory> listBookingHistory() {
		return this.bookingHistoryDAO.listBookingHistory();
	}

	@Override
	@Transactional
	public List<BookingHistory> listUserRecords(int userId) {
		return this.bookingHistoryDAO.listUserRecords(userId);
	}

	@Transactional
	private void update() throws IOException {
		this.bookingHistoryList = listBookingHistory();
		this.bookingHistory = new BookingHistory();
		this.selectedBookingHistory = new BookingHistory();
		this.externalContext = FacesContext.getCurrentInstance().getExternalContext();
		this.externalContext
				.redirect(this.externalContext.getRequestContextPath() + this.externalContext.getRequestServletPath());
	}

	public BookingHistory getBookingHistoryById(String id) {
		for (BookingHistory b : this.bookingHistoryList) {
			if (b.getIdbooking_history() == Integer.parseInt(id)) {
				return b;
			}
		}

		return null;
	}

	private boolean doesExist(BookingHistory bookingHistory) {
		for (BookingHistory b : bookingHistoryList) {
			if (b.getGuide().getIdguide() == bookingHistory.getGuide().getIdguide()
					&& b.getUser().getIduser() == bookingHistory.getUser().getIduser()) {
				return true;
			}
		}

		return false;
	}

	@Override
	@Transactional
	public void addBookingHistory() throws IOException {

		if (!doesExist(this.bookingHistory)) {
			if (this.bookingHistoryDAO.addBookingHistory(this.bookingHistory)) {
				this.bookingHistory = new BookingHistory();
				update();
				RequestContext.getCurrentInstance().execute("PF('AddBookingHistoryDialog').hide()");
			} else {

			}
		}
		else {
			
		}
	}

	@Override
	@Transactional
	public void editBookingHistory() throws IOException {

		if (this.bookingHistoryDAO.editBookingHistory(this.selectedBookingHistory)) {
			update();
		} else {

		}
	}

	@Override
	@Transactional
	public void deleteBookingHistory() throws IOException {

		if (this.bookingHistoryDAO.deleteBookingHistory(this.bookingHistory)) {
			update();
		} else {

		}
	}

	public BookingHistoryDAO getBookingHistoryDAO() {
		return bookingHistoryDAO;
	}

	public void setBookingHistoryDAO(BookingHistoryDAO bookingHistoryDAO) {
		this.bookingHistoryDAO = bookingHistoryDAO;
	}

	public List<BookingHistory> getBookingHistoryList() {
		return bookingHistoryList;
	}

	public void setBookingHistoryList(List<BookingHistory> bookingHistoryList) {
		this.bookingHistoryList = bookingHistoryList;
	}

	public BookingHistory getBookingHistory() {
		return bookingHistory;
	}

	public void setBookingHistory(BookingHistory bookingHistory) {
		this.bookingHistory = bookingHistory;
	}

	public BookingHistory getSelectedBookingHistory() {
		return selectedBookingHistory;
	}

	public void setSelectedBookingHistory(BookingHistory selectedBookingHistory) {
		this.selectedBookingHistory = selectedBookingHistory;
	}

}
