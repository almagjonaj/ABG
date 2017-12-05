package com.abg.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abg.dao.DepartureStationDAO;
import com.abg.model.DepartureStation;

@Repository
public class DepartureStationDAOImpl implements DepartureStationDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DepartureStation> listDepartureStations() {
		
		this.session = this.sessionFactory.getCurrentSession();

		List<DepartureStation> departureStationList = this.session.createQuery("from DepartureStation").list();

		return departureStationList;
	}

	@Override
	public boolean addDepartureStation(DepartureStation departure_station) {
		try {
			this.session = this.sessionFactory.getCurrentSession();
			
			this.session.persist(departure_station);
			
			return true;
			
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean editDepartureStation(DepartureStation departure_station) {
		try {
			this.session = this.sessionFactory.getCurrentSession();
			
			this.session.update(departure_station);
			
			return true;
			
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteDepartureStation(DepartureStation departure_station) {
		try {
			this.session = this.sessionFactory.getCurrentSession();
			
			this.session.remove(departure_station);
			
			return true;
			
		} catch (Exception e) {
			
		}
		return false;
	}

}
