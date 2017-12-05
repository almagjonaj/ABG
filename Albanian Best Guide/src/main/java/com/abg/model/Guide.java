package com.abg.model;

import java.time.LocalDateTime;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="GUIDE")
public class Guide {
	
	@Id
    @Column(name="idguide")
	private int idguide;
	
	@ManyToOne
    @JoinColumn(name = "departure_station_id")
	private DepartureStation departure_station;
	
	private LocalDateTime departure_time;
	
	@ManyToOne
    @JoinColumn(name = "destination_id")
	private Destination destination;
	
	private LocalDateTime destination_arrival_time;
	
	private LocalDateTime destination_leave_time;
	
	private LocalDateTime arrival_time;
	
	private int max_reservation_nr;
	
	private int reservation_number;
	
	private String guide_description;
	
	@ManyToOne
    @JoinColumn(name = "guidecategory_id")
	private GuideCategory guideCategory;

	public int getIdguide() {
		return idguide;
	}

	public void setIdguide(int idguide) {
		this.idguide = idguide;
	}

	public DepartureStation getDeparture_station() {
		return departure_station;
	}

	public void setDeparture_station(DepartureStation departure_station) {
		this.departure_station = departure_station;
	}

	public LocalDateTime getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(LocalDateTime departure_time) {
		this.departure_time = departure_time;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public LocalDateTime getDestination_arrival_time() {
		return destination_arrival_time;
	}

	public void setDestination_arrival_time(LocalDateTime destination_arrival_time) {
		this.destination_arrival_time = destination_arrival_time;
	}

	public LocalDateTime getDestination_leave_time() {
		return destination_leave_time;
	}

	public void setDestination_leave_time(LocalDateTime destination_leave_time) {
		this.destination_leave_time = destination_leave_time;
	}

	public LocalDateTime getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(LocalDateTime arrival_time) {
		this.arrival_time = arrival_time;
	}

	public int getMax_reservation_nr() {
		return max_reservation_nr;
	}

	public void setMax_reservation_nr(int max_reservation_nr) {
		this.max_reservation_nr = max_reservation_nr;
	}

	public int getReservation_number() {
		return reservation_number;
	}

	public void setReservation_number(int reservation_number) {
		this.reservation_number = reservation_number;
	}

	public String getGuide_description() {
		return guide_description;
	}

	public void setGuide_description(String guide_description) {
		this.guide_description = guide_description;
	}

	public GuideCategory getGuideCategory() {
		return guideCategory;
	}

	public void setGuideCategory(GuideCategory guideCategory) {
		this.guideCategory = guideCategory;
	}
	
}
