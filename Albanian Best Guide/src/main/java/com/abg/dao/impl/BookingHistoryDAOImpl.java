package com.abg.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abg.dao.BookingHistoryDAO;
import com.abg.model.BookingHistory;

@Repository
public class BookingHistoryDAOImpl implements BookingHistoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookingHistory> listBookingHistory() {

		this.session = this.sessionFactory.getCurrentSession();

		List<BookingHistory> bookingHistoryList = session.createQuery("from BookingHistory").list();

		return bookingHistoryList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookingHistory> listUserRecords(int userId) {

		this.session = this.sessionFactory.getCurrentSession();

		List<BookingHistory> bookingHistoryList = this.session.createQuery("from BookingHistory where client_id=" + userId)
				.list();

		return bookingHistoryList;
	}

	@Override
	public boolean addBookingHistory(BookingHistory bookinghistory) {
		
		try {
	        this.session = this.sessionFactory.getCurrentSession();
	        this.session.persist(bookinghistory);
	        
	        return true;
	        
		} catch (Exception e) {
			
		}
		
		return false;
	}

	@Override
	public boolean editBookingHistory(BookingHistory bookinghistory) {
		try {
			this.session = this.sessionFactory.getCurrentSession();
			this.session.update(bookinghistory);
			return true;
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteBookingHistory(BookingHistory bookinghistory) {
		try {
			this.session = this.sessionFactory.getCurrentSession();
			this.session.remove(bookinghistory);
			return true;			
		} catch (Exception e) {
			
		}
		return false;
	}

}
