package com.infy.irs.controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.irs.entity.EntityList;
import com.infy.irs.exception.InfyGoBookException;
import com.infy.irs.model.User;
import com.infy.irs.service.RegistrationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping
public class RegistrationController {
    @Autowired
	private RegistrationService rs;
    
    @Autowired
    Environment env;
    HttpHeaders http;
	@PostMapping(value="/userregister",consumes = "application/json")
	public ResponseEntity<String> createUser(@Valid @RequestBody User user) throws InfyGoBookException {
		//if(br.hasErrors()) {
		//return new ResponseEntity<>("send valid Data",HttpStatus.BAD_REQUEST);
			
		//}
		//try {
			//http = new HttpHeaders();
			//http.add("X-ApiTransId", java.util.UUID.randomUUID().toString());
		rs.registerUser(user);
		//	}
	//	catch(Exception ex){
		//	return new ResponseEntity<>(env.getProperty(ex.getMessage()),HttpStatus.BAD_REQUEST);
		//}
		return  ResponseEntity.ok().headers(http).body("successfully created");
	}
	@GetMapping(value="{query}/getdetails" ,produces = {"application/json","application/xml"})
	public ResponseEntity<EntityList<User>> getuptoFiveIds(@MatrixVariable(pathVar = "query") Map<String,List<String>> ids) throws InfyGoBookException{
		//List<User> usr;
				
		//usr=rs.getAllIds(ids.get("idis"));
		
	
		return new ResponseEntity<>(new EntityList<User>(rs.getAllIds(ids.get("idis"))),HttpStatus.OK);
	}
	

}
