package com.abg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_TYPE")
public class UserType {
	@Id
    @Column(name="iduser_type")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iduser_type;
	
	private String user_type_name;

	public int getIduser_type() {
		return iduser_type;
	}

	public void setIduser_type(int iduser_type) {
		this.iduser_type = iduser_type;
	}

	public String getUser_type_name() {
		return user_type_name;
	}

	public void setUser_type_name(String user_type_name) {
		this.user_type_name = user_type_name;
	}
	
	
}
