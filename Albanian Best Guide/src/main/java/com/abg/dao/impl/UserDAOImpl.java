package com.abg.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abg.dao.UserDAO;
import com.abg.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {

		this.session = this.sessionFactory.getCurrentSession();

		List<User> userList = this.session.createQuery("from User").list();

		return userList;
	}

	@Override
	public boolean addUser(User user) {
		try {
			this.session = this.sessionFactory.getCurrentSession();
			
			this.session.persist(user);
			
			return true;
			
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean editUser(User user) {
		try {
			this.session = this.sessionFactory.getCurrentSession();
			
			this.session.update(user);
			
			return true;
			
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		try {
			this.session = this.sessionFactory.getCurrentSession();
			
			this.session.remove(user);
			
			return true;
			
		} catch (Exception e) {
			
		}
		return false;
	}

}
