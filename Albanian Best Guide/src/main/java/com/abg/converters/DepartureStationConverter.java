package com.abg.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;

import com.abg.model.DepartureStation;
import com.abg.service.DepartureStationService;

public class DepartureStationConverter implements Converter{
	
	@Autowired
	private DepartureStationService departureStationService;

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		
		if (value != null && value.trim().length() > 0) {
			try {
				return departureStationService.getDepartureStationById(value);
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
			return String.valueOf(((DepartureStation) object).getIddeparture_station());
		} else {
			return null;
		}
	}

	public DepartureStationService getDepartureStationService() {
		return departureStationService;
	}

	public void setDepartureStationService(DepartureStationService departureStationService) {
		this.departureStationService = departureStationService;
	}

}
