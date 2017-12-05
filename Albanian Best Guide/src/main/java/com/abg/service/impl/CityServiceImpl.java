package com.abg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abg.dao.CityDAO;
import com.abg.model.City;
import com.abg.service.CityService;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityDAO cityDAO;
	
	private List<City> cityList;
	
	private City city = new City();

	@Override
	@Transactional
	public List<City> listCities() {
		return this.cityDAO.listCities();
	}
	
	public City getCityById(String id) {
		for (City city : this.cityList) {
			if (city.getIdcity() == Integer.parseInt(id)) {
				return city;
			}
		}
		
		return null;
	}

	@Override
	@Transactional
	public void addCity() {
		
		if (this.cityDAO.addCity(this.city)) {
			this.city = new City();
		}
		else {
			
		}
	}

	@Override
	@Transactional
	public void editCity() {
		;
		
		if (this.cityDAO.editCity(this.city)) {
			this.city = new City();
		}
		else {
			
		}
	}

	@Override
	@Transactional
	public void deleteCity() {
		
		if (this.cityDAO.deleteCity(this.city)) {
			this.city = new City();
		}
		else {
			
		}
	}

	public CityDAO getCityDAO() {
		return cityDAO;
	}

	public void setCityDAO(CityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
