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
@Table(name = "DESTINATION")
public class Destination {

	@Id
	@Column(name = "iddestination")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddestination;

	@ManyToOne
    @JoinColumn(name = "destinationcity_id")
	private City city;

	private String destination_address;

	public int getIddestination() {
		return iddestination;
	}

	public void setIddestination(int iddestination) {
		this.iddestination = iddestination;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getDestination_address() {
		return destination_address;
	}

	public void setDestination_address(String destination_address) {
		this.destination_address = destination_address;
	}
}
