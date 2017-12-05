package com.abg.service;

import java.util.List;

import com.abg.dao.UserTypeDAO;
import com.abg.model.UserType;

public interface UserTypeService {
	
	public List<UserType> listUserTypes();
	
	public List<UserType> listAdminTypes();
	
	public UserType getUserTypeById(String id);
	
	public UserTypeDAO getUserTypeDAO();

	public void setUserTypeDAO(UserTypeDAO userTypeDAO);

	public List<UserType> getUserTypeList();

	public void setUserTypeList(List<UserType> userTypeList);

}
