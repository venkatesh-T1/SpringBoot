package com.infy.irs.entity;

import com.infy.irs.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USER_DETAILS")

public class UserEntity {

	@Id
	@Column(name="userid")
	private String userId;
	private String password;
	private String name;
	private String city;
	private String email;
	private String phone;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public User entityConversiontoUser(UserEntity user) {
		
		User ue = new User();
		ue.setCity(user.getCity());
		ue.setEmail(user.getName());
		ue.setName(user.getName());
		ue.setPassword(user.getPassword());
		ue.setPhone(user.getPhone());
		ue.setUserId(user.getUserId());
		
		return ue;
	}
	
}
