package com.abg.service;

import java.io.IOException;
import java.util.List;

import com.abg.model.BookingHistory;

public interface BookingHistoryService {
	
	public List<BookingHistory> listBookingHistory();
	
	public List<BookingHistory> listUserRecords(int userId);
	
	public BookingHistory getBookingHistoryById(String id);
	
	public void addBookingHistory() throws IOException;
	
	public void editBookingHistory() throws IOException;
	
	public void deleteBookingHistory() throws IOException;
	
	public List<BookingHistory> getBookingHistoryList();
	
	public void setBookingHistoryList(List<BookingHistory> bookingHistoryList);
	
	public BookingHistory getBookingHistory();

	public void setBookingHistory(BookingHistory bookingHistory);
	
	public BookingHistory getSelectedBookingHistory();

	public void setSelectedBookingHistory(BookingHistory selectedBookingHistory);

}
