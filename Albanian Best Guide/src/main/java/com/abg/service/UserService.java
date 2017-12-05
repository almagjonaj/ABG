package com.abg.service;

import java.io.IOException;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.servlet.http.HttpSession;

import com.abg.model.User;

public interface UserService {
	
	public List<User> listUsers();
	
	public void addUser() throws IOException;
	
	public void editUser();
	
	public void deleteUser() throws IOException;
	
	public void adminLogIn() throws IOException;
	
	public void adminLogOut() throws IOException;
	
	public void userLogIn() throws IOException;
	
	public void userLogOut() throws IOException;
	
	public int UserLog();
	
	public List<User> getAdmins();
	
	public List<User> getClients();
	
	public User getUserById(String id);
	
	public String getEmail();

	public void setEmail(String email);

	public String getPassword();

	public void setPassword(String password);

	public User getLogged_user();

	public void setLogged_user(User logged_user);

	public HttpSession getSession();

	public void setSession(HttpSession session);

	public ExternalContext getExternalContext();

	public void setExternalContext(ExternalContext externalContext);
	
	public boolean isAdmin_logged();
	
	public void setAdmin_logged(boolean admin_logged);
	
	public boolean isUser_logged();

	public void setUser_logged(boolean user_logged);

	public boolean isSuperadmin_logged();

	public void setSuperadmin_logged(boolean superadmin_logged);
	
	public List<User> getUserList();

	public void setUserList(List<User> userList);
	
	public User getUser();

	public void setUser(User user);
	
	public User getRemovedUser();

	public void setRemovedUser(User removedUser);
	
}
