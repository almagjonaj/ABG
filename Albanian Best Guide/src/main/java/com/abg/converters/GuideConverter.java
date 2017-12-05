package com.abg.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;

import com.abg.model.Guide;
import com.abg.service.GuideService;

public class GuideConverter implements Converter{
	
	@Autowired
	private GuideService guideService;

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		
		if (value != null && value.trim().length() > 0) {
			try {
				return guideService.getGuideById(value);
			} catch (NumberFormatException e) {
				throw new ConverterException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
			}
		} else {
			return null;
		}
	}
	
	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((Guide) object).getIdguide());
		} else {
			return null;
		}
	}

	public GuideService getGuideService() {
		return guideService;
	}

	public void setGuideService(GuideService guideService) {
		this.guideService = guideService;
	}

}
