package com.infy.irs.model;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotNull(message = "user id must not be null")
    @Size(min = 4,max = 15,message = "user id must be between 4 to 15 characters")
	private String userId;
	@NotNull(message = "password must not be null")
    @Size(min = 8,max = 15,message = "password must be between 8 to 15 characters")
	private String password;
	@NotNull(message = "name must not be null")
    @Size(min = 4,max = 15,message = "name must be between 4 to 15 characters")
	private String name;
	@NotNull(message = "city must not be null")
	private String city;
	@NotNull(message = "email must not be null")
	@Email(message = "email should be valid")
	private String email;

	@NotNull(message = "phone must not be null")
    @Size(min = 10,max = 10,message = "phone must be between 10 to 10 characters")
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
	
	
	
}
