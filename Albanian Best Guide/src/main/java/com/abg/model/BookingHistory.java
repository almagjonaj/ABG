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
@Table(name="BOOKING_HISTORY")
public class BookingHistory {
	
	@Id
    @Column(name="idbooking_history")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idbooking_history;
	
	@ManyToOne
    @JoinColumn(name = "guide_id")
	private Guide guide;
	
	@ManyToOne
    @JoinColumn(name = "client_id")
	private User user;

	public int getIdbooking_history() {
		return idbooking_history;
	}

	public void setIdbooking_history(int idbooking_history) {
		this.idbooking_history = idbooking_history;
	}

	public Guide getGuide() {
		return guide;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
