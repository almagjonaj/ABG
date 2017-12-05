package com.abg.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abg.dao.UserDAO;
import com.abg.model.User;
import com.abg.security.SessionUtils;
import com.abg.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	private String email;

	private String password;

	private List<User> userList;

	private User logged_user;

	private User user = new User();

	private User removedUser = new User();

	private boolean admin_logged = false;

	private boolean user_logged = false;

	private boolean superadmin_logged = false;

	private HttpSession session;

	private ExternalContext externalContext;

	@Override
	@Transactional
	public List<User> listUsers() {
		return this.userDAO.listUsers();
	}

	@Transactional
	private void update() throws IOException {
		this.userList = listUsers();
		this.user = new User();
		this.removedUser = new User();
		this.externalContext = FacesContext.getCurrentInstance().getExternalContext();
		this.externalContext
				.redirect(this.externalContext.getRequestContextPath() + this.externalContext.getRequestServletPath());
	}
	
	private boolean doesExist(User user) {
		for (User u : userList) {
			if (u.getUser_email().equals(user.getUser_email())){
				return true;
			}
		}
		return false;
	}

	@Transactional
	private User passWordCheck() {

		List<User> users = this.userDAO.listUsers();

		for (User usr : users) {
			if (usr.getUser_email().equals(this.email) && usr.getUser_password().equals(this.password)) {
				return usr;
			}
		}

		return null;
	}

	// User Log-- returns 0 for no match, returns 1 for client, return 2 for admin

	public int UserLog() {
		this.logged_user = passWordCheck();

		if (this.logged_user != null) {
			if (this.logged_user.getUser_type().getIduser_type() == 2
					|| this.logged_user.getUser_type().getIduser_type() == 3) {
				return 2;
			}

			else if (this.logged_user.getUser_type().getIduser_type() == 1) {
				return 1;
			}
		}

		return 0;
	}

	public void adminLogIn() throws IOException {
		if (this.logged_user.getUser_type().getIduser_type() == 3) {
			this.superadmin_logged = true;
		}
		this.admin_logged = true;
		this.session = SessionUtils.getSession();
		this.session.setAttribute("admin", logged_user);
		this.externalContext = FacesContext.getCurrentInstance().getExternalContext();
		this.externalContext.redirect(externalContext.getRequestContextPath() + "/adminPages/adminPage.xhtml");

	}

	@Override
	public void adminLogOut() throws IOException {
		this.session.removeAttribute("admin");
		this.admin_logged = false;
		this.superadmin_logged = false;
		this.externalContext = FacesContext.getCurrentInstance().getExternalContext();
		this.externalContext.redirect(this.externalContext.getRequestContextPath() + "/userPages/index.xhtml");
	}

	public void userLogIn() throws IOException {
		this.user_logged = true;

		this.session.setAttribute("user", logged_user);

		this.externalContext = FacesContext.getCurrentInstance().getExternalContext();

		this.externalContext
				.redirect(this.externalContext.getRequestContextPath() + this.externalContext.getRequestServletPath());
	}

	@Override
	public void userLogOut() throws IOException {

		this.session.removeAttribute("user");

		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

		if (request.getRequestURI().contains("llogaria")) {
			this.externalContext.redirect(externalContext.getRequestContextPath() + "/userPages/index.xhtml");
		}

		else
			this.externalContext.redirect(((HttpServletRequest) externalContext.getRequest()).getRequestURI());

	}

	public List<User> getAdmins() {

		List<User> admins = new ArrayList<>();

		for (User user : userList) {
			if (user.getUser_type().getIduser_type() == 2 || user.getUser_type().getIduser_type() == 3) {
				admins.add(user);
			}
		}

		return admins;
	}

	public List<User> getClients() {

		List<User> clients = new ArrayList<>();

		for (User user : userList) {
			if (user.getUser_type().getIduser_type() == 1) {
				clients.add(user);
			}
		}

		return clients;
	}

	public User getUserById(String id) {
		for (User user : this.userList) {
			if (user.getIduser() == Integer.parseInt(id)) {
				return user;
			}
		}
		return null;
	}

	// CRUDES

	@Override
	@Transactional
	public void addUser() throws IOException {
		
		if (!doesExist(this.user)) {
			if (this.userDAO.addUser(this.user)) {
				update();
			} else {

			}
		}

	}

	@Override
	@Transactional
	public void editUser() {

		if (this.userDAO.editUser(this.user)) {
			this.user = new User();
		} else {

		}
	}

	@Override
	@Transactional
	public void deleteUser() throws IOException {

		if (this.userDAO.deleteUser(this.removedUser)) {
			update();
		} else {

		}
	}

	// Getters and Setters

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getLogged_user() {
		return logged_user;
	}

	public void setLogged_user(User logged_user) {
		this.logged_user = logged_user;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public ExternalContext getExternalContext() {
		return externalContext;
	}

	public void setExternalContext(ExternalContext externalContext) {
		this.externalContext = externalContext;
	}

	public boolean isAdmin_logged() {
		return admin_logged;
	}

	public void setAdmin_logged(boolean admin_logged) {
		this.admin_logged = admin_logged;
	}

	public boolean isUser_logged() {
		return user_logged;
	}

	public void setUser_logged(boolean user_logged) {
		this.user_logged = user_logged;
	}

	public boolean isSuperadmin_logged() {
		return superadmin_logged;
	}

	public void setSuperadmin_logged(boolean superadmin_logged) {
		this.superadmin_logged = superadmin_logged;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getRemovedUser() {
		return removedUser;
	}

	public void setRemovedUser(User removedUser) {
		this.removedUser = removedUser;
	}
}
