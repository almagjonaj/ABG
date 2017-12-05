package com.abg.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abg.dao.GuideDAO;
import com.abg.model.Guide;

@Repository
public class GuideDAOImpl implements GuideDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Guide> listGuides() {
		
		this.session = this.sessionFactory.getCurrentSession();

		List<Guide> guideList = this.session.createQuery("from Guide").list();

		return guideList;
	}

	@Override
	public boolean addGuide(Guide guide) {
		try {
			this.session = this.sessionFactory.getCurrentSession();
			
			this.session.persist(guide);
			
			return true;
			
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean editGuide(Guide guide) {
		try {
			this.session = this.sessionFactory.getCurrentSession();
			
			this.session.update(guide);
			
			return true;
			
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteGuide(Guide guide) {
		try {
			this.session = this.sessionFactory.getCurrentSession();
			
			this.session.remove(guide);
			
			return true;
			
		} catch (Exception e) {
			
		}
		return false;
	}

}
