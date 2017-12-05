package com.abg.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abg.dao.DestinationDAO;
import com.abg.model.Destination;

@Repository
public class DestinationDAOImpl implements DestinationDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Destination> listDestinations() {

		this.session = this.sessionFactory.getCurrentSession();

		List<Destination> destinationList = this.session.createQuery("from Destination").list();

		return destinationList;
	}

	@Override
	public boolean addDestination(Destination destination) {
		try {
			this.session = this.sessionFactory.getCurrentSession();
			
			this.session.persist(destination);
			
			return true;
			
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean editDestination(Destination destination) {
		try {
			
			this.session = this.sessionFactory.getCurrentSession();
			
			this.session.update(destination);
			
			return true;
			
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteDestination(Destination destination) {
		try {
			this.session = this.sessionFactory.getCurrentSession();
			
			this.session.remove(destination);
			
			return true;
			
		} catch (Exception e) {
			
		}
		return false;
	}

}
