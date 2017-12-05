package com.abg.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean (name="functionsBean")
@SessionScoped
public class FunctionsBean implements Serializable{

	private static final long serialVersionUID = 1811852618529389240L;
	
	private ExternalContext externalContext;
	
	private HttpServletRequest request;
	
	public String getIndex() {
		externalContext = FacesContext.getCurrentInstance().getExternalContext();
		request = (HttpServletRequest) externalContext.getRequest();
		if (request.getRequestURI().contains("index")) {
			return "active";
		}
		return "";
	}
	
	public String getDestinations() {
		externalContext = FacesContext.getCurrentInstance().getExternalContext();
		request = (HttpServletRequest) externalContext.getRequest();
		if (request.getRequestURI().contains("destinations")) {
			return "active";
		}
		return "";
	}
	
	public String getSearch() {
		externalContext = FacesContext.getCurrentInstance().getExternalContext();
		request = (HttpServletRequest) externalContext.getRequest();
		if (request.getRequestURI().contains("search")) {
			return "active";
		}
		return "";
	}
	
	public String getContacts() {
		externalContext = FacesContext.getCurrentInstance().getExternalContext();
		request = (HttpServletRequest) externalContext.getRequest();
		if (request.getRequestURI().contains("contact")) {
			return "active";
		}
		return "";
	}

}
