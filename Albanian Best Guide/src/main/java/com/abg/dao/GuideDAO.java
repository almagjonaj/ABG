package com.abg.dao;

import java.util.List;

import com.abg.model.Guide;

public interface GuideDAO {
	
	public List<Guide> listGuides();
	
	public boolean addGuide(Guide guide);
	
	public boolean editGuide(Guide guide);
	
	public boolean deleteGuide(Guide guide);

}
