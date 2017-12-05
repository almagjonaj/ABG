package com.abg.service;

import java.util.List;

import com.abg.model.City;

public interface CityService {
	
	public List<City> listCities();
	
	public City getCityById(String id);
	
	public void addCity();
	
	public void editCity();
	
	public void deleteCity();
	
	public List<City> getCityList();
	
	public void setCityList(List<City> cityList);
	
	public City getCity();

	public void setCity(City city);

}
