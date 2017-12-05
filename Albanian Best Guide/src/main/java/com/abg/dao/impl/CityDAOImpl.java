package com.abg.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abg.dao.CityDAO;
import com.abg.model.City;

@Repository
public class CityDAOImpl implements CityDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<City> listCities() {
		this.session = this.sessionFactory.getCurrentSession();

		List<City> cityList = this.session.createQuery("from City").list();

		return cityList;
	}

	@Override
	public boolean addCity(City city) {
		try {
	        this.session = this.sessionFactory.getCurrentSession();
	        this.session.persist(city);
	        return true;
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean editCity(City city) {
		try {
			this.session = this.sessionFactory.getCurrentSession();
			this.session.update(city);
			return true;
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteCity(City city) {
		try {
			this.session = this.sessionFactory.getCurrentSession();
			this.session.remove(city);
			return true;
		} catch (Exception e) {
			
		}
		return false;
	}

}
