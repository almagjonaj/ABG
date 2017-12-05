package com.abg.dao;

import java.util.List;

import com.abg.model.User;

public interface UserDAO {
	
	public List<User> listUsers();
	
	public boolean addUser(User user);
	
	public boolean editUser(User user);
	
	public boolean deleteUser(User user);
	
}
