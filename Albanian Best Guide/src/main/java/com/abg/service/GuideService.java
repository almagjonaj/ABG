package com.abg.service;

import java.io.IOException;
import java.util.List;

import com.abg.model.Guide;

public interface GuideService {
	
	public List<Guide> listGuides();
	
	public Guide getGuideById(String id);
	
	public void addGuide() throws IOException;
	
	public void editGuide() throws IOException;
	
	public void deleteGuide();
	
	public List<Guide> getAvailableGuides();
	
	public List<Guide> getGuideList();

	public void setGuideList(List<Guide> guideList);
	
	public Guide getGuide();

	public void setGuide(Guide guide);
	
	public Guide getSelectedGuide();

	public void setSelectedGuide(Guide selectedGuide);

}
