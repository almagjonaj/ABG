package com.abg.dao;

import java.util.List;

import com.abg.model.BookingHistory;

public interface BookingHistoryDAO {
	
	public List<BookingHistory> listBookingHistory();
	
	public List<BookingHistory> listUserRecords(int userId);
	
	public boolean addBookingHistory(BookingHistory bookinghistory);
	
	public boolean editBookingHistory(BookingHistory bookinghistory);
	
	public boolean deleteBookingHistory(BookingHistory bookinghistory);

}
