package com.abg.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CITY")
public class City{
	
	@Id
	private int idcity;
	
	private String city_name;
	
	public int getIdcity() {
		return idcity;
	}

	public void setIdcity(int idcity) {
		this.idcity = idcity;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	
    @Override
    public String toString() {
        return this.city_name;
    }

}
