package com.abg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GUIDE_CATEGORY")
public class GuideCategory {
	
	@Id
	@Column(name="idguide_category")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idguide_category;
	
	private String guide_name;
	
	private String guide_category;

	public int getIdguide_category() {
		return idguide_category;
	}

	public void setIdguide_category(int idguide_category) {
		this.idguide_category = idguide_category;
	}

	public String getGuide_name() {
		return guide_name;
	}

	public void setGuide_name(String guide_name) {
		this.guide_name = guide_name;
	}

	public String getGuide_category() {
		return guide_category;
	}

	public void setGuide_category(String guide_category) {
		this.guide_category = guide_category;
	}
	
	

}
