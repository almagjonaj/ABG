package com.abg.dao;

import java.util.List;
import com.abg.model.City;

public interface CityDAO {
	
	public List<City> listCities();
	
	public boolean addCity(City city);
	
	public boolean editCity(City city);
	
	public boolean deleteCity(City city);

}
