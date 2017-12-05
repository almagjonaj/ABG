package com.abg.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abg.dao.UserTypeDAO;
import com.abg.model.UserType;
import com.abg.service.UserTypeService;

@Service
public class UserTypeServiceImpl implements UserTypeService {
	
	@Autowired
	private UserTypeDAO userTypeDAO;
	
	private List<UserType> userTypeList;

	@Override
	public List<UserType> listUserTypes() {
		return this.userTypeDAO.listUserTypes();
	}
	
	public List<UserType> listAdminTypes(){
		List<UserType> adminTypes = new ArrayList<>();
		for (UserType type: userTypeList) {
			if (type.getIduser_type() == 2 || type.getIduser_type() == 3) {
				adminTypes.add(type);
			}
		}
		return adminTypes;
	}
	
	public UserType getUserTypeById(String id) {
		for (UserType t : userTypeList) {
			if (t.getIduser_type() == Integer.valueOf(id)) {
				return t;
			}
		}
		return null;
	}

	public UserTypeDAO getUserTypeDAO() {
		return userTypeDAO;
	}

	public void setUserTypeDAO(UserTypeDAO userTypeDAO) {
		this.userTypeDAO = userTypeDAO;
	}

	public List<UserType> getUserTypeList() {
		return userTypeList;
	}

	public void setUserTypeList(List<UserType> userTypeList) {
		this.userTypeList = userTypeList;
	}

}
