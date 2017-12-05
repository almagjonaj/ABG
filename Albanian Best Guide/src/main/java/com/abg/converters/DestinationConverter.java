package com.abg.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;

import com.abg.model.Destination;
import com.abg.service.DestinationService;

public class DestinationConverter implements Converter{
	
	@Autowired
	private DestinationService destinationService;

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		
		if (value != null && value.trim().length() > 0) {
			try {
				return destinationService.getDestinationById(value);
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
			return String.valueOf(((Destination) object).getIddestination());
		} else {
			return null;
		}
	}

	public DestinationService getDestinationService() {
		return destinationService;
	}

	public void setDestinationService(DestinationService destinationService) {
		this.destinationService = destinationService;
	}

}
