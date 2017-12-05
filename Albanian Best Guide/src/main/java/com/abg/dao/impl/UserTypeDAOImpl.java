package com.abg.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abg.dao.UserTypeDAO;
import com.abg.model.UserType;

@Repository
public class UserTypeDAOImpl implements UserTypeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserType> listUserTypes() {
		Session session = this.sessionFactory.getCurrentSession();
		
		List<UserType> userTypeList = session.createQuery(" from UserType").list();
		
		return userTypeList;

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

}
