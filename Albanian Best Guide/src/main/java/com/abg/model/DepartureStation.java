package com.abg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTURE_STATION")
public class DepartureStation {
	
	@Id
    @Column(name="iddeparture_station")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddeparture_station;
	
	@ManyToOne
	@JoinColumn(name="departurecity_id")
	private City city;
	
	private String station_address;

	public int getIddeparture_station() {
		return iddeparture_station;
	}

	public void setIddeparture_station(int iddeparture_station) {
		this.iddeparture_station = iddeparture_station;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getStation_address() {
		return station_address;
	}

	public void setStation_address(String station_address) {
		this.station_address = station_address;
	}

}
