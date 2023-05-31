package com.infy.irs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.irs.entity.UserEntity;
import com.infy.irs.exception.InfyGoBookException;
import com.infy.irs.exception.InvalidCityException;
import com.infy.irs.exception.InvalidEmailException;
import com.infy.irs.exception.InvalidNameException;
import com.infy.irs.exception.InvalidPasswordException;
import com.infy.irs.exception.InvalidPhoneException;
import com.infy.irs.exception.InvalidUserIdException;
import com.infy.irs.exception.UserIdAlreadyPresentException;
import com.infy.irs.model.User;
import com.infy.irs.repository.UserRepository;

@Service("registrationService")
public class RegistrationService {


	@Autowired
	private UserRepository usr;
	
	
	
	String regex1 = "^[a-zA-Z0-9]{4,15}+$";
	//private String successMessage = "UserRespository.REGISTRATION_SUCCESS";
	public void registerUser(User user) throws InfyGoBookException {
		//validateUser(user);
		boolean b= usr.existsById(user.getUserId());
		if (b)
			throw new UserIdAlreadyPresentException("RegistrationService.USERID_PRESENT");
			
		UserEntity ue = new UserEntity();
		ue.setCity(user.getCity());
		ue.setEmail(user.getName());
		ue.setName(user.getName());
		ue.setPassword(user.getPassword());
		ue.setPhone(user.getPhone());
		ue.setUserId(user.getUserId());
		usr.saveAndFlush(ue);
		
		
	}
	
	public List<User> getAllIds(List<String> ids) throws InfyGoBookException{
		List<User> users = new ArrayList<>();
		int errorCount=0;
		UserEntity e=new UserEntity();
		for(String s:ids) {
			Optional<UserEntity>  op=usr.findById(s);
			if(op.isPresent()) {
				users.add(e.entityConversiontoUser(op.get()));
			}
			else {
				errorCount++;
			}
			
		}
		if(errorCount==ids.size()) {
			throw new InfyGoBookException("All are Invalid ids, Please Send Valid Ids.");
		}
		
		
		return users;
	}

	public void validateUser(User user) throws InfyGoBookException {
	
		if(!isValidUserId(user.getName()))	
			throw new InvalidUserIdException("RegistrationService.INVALID_USER_ID");
		if (!isValidPassword(user.getPassword()))
			throw new InvalidPasswordException("RegistrationService.INVALID_PASSWORD");
		if (!isValidName(user.getName()))
			throw new InvalidNameException("RegistrationService.INVALID_NAME");
		if (!isValidCity(user.getCity()))
			throw new InvalidCityException("RegistrationService.INVALID_CITY");
		if (!isValidEmail(user.getEmail()))
			throw new InvalidEmailException("RegistrationService.INVALID_EMAIL");
		if (!isValidPhoneNumber(user.getPhone()))
			throw new InvalidPhoneException("RegistrationService.INVALID_PHONE_NUMBER");
		
		
	}

	public boolean isValidUserId(String userId) {
		Pattern p1= Pattern.compile(regex1);
		Matcher m1= p1.matcher(userId);
		if(m1.matches()) 
			return true;
		return false;
	}
	public Boolean isValidPassword(String password) {
		Boolean b1 = false;
		String regex2 = "^[a-zA-Z0-9]{8,15}+$";
		Pattern pattern2 = Pattern.compile(regex2);
		Matcher matcher2 = pattern2.matcher(password);
		if (matcher2.matches())
			b1 = true;
		return b1;
	}
	public Boolean isValidName(String name) {
		Boolean b1 = false;
		Pattern pattern3 = Pattern.compile(regex1);
		Matcher matcher3 = pattern3.matcher(name);
		if (matcher3.matches())
			b1 = true;
		return b1;
	}
	public Boolean isValidCity(String city) {
		Boolean b1 = false;
		Pattern pattern4 = Pattern.compile(regex1);
		Matcher matcher4 = pattern4.matcher(city);
		if (matcher4.matches())
			b1 = true;
		return b1;
	}
	public Boolean isValidEmail(String email) {
		Boolean b1 = false;
		String regex5 = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern5 = Pattern.compile(regex5);
		Matcher matcher5 = pattern5.matcher(email);
		if (matcher5.matches())
			b1 = true;
		return b1;
	}
	public Boolean isValidPhoneNumber(String number) {
		Boolean b1 = false;
		String regex6 = "[0-9]{10}";
		Pattern pattern6 = Pattern.compile(regex6);
		Matcher matcher6 = pattern6.matcher(number);
		if (matcher6.matches())
			b1 = true;
		return b1;
	}
}
