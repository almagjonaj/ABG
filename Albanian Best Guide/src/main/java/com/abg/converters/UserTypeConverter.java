package com.abg.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;

import com.abg.model.UserType;
import com.abg.service.UserTypeService;

public class UserTypeConverter implements Converter {
	
	@Autowired
	private UserTypeService userTypeService;
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		
		if (value != null && value.trim().length() > 0) {
			try {
				return userTypeService.getUserTypeById(value);
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
			return String.valueOf(((UserType) object).getIduser_type());
		} else {
			return null;
		}
	}

	public UserTypeService getUserTypeService() {
		return userTypeService;
	}

	public void setUserTypeService(UserTypeService userTypeService) {
		this.userTypeService = userTypeService;
	}

}
