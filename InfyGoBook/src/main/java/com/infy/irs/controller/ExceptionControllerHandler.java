package com.infy.irs.controller;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infy.irs.exception.InfyGoBookException;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionControllerHandler {

	@Autowired
	private Environment en;
	
	private static final Logger logger= LoggerFactory.getLogger(ExceptionControllerHandler.class);
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exceptions2(Exception ex){
	
		logger.info(ex.getMessage() +"  this is the error");
	return new ResponseEntity<>(en.getProperty(ex.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InfyGoBookException.class)
	public ResponseEntity<String> exceptions(InfyGoBookException ex){
	logger.info(en.getProperty(ex.getMessage()) +"  this is the error");
	
	return new ResponseEntity<>(en.getProperty(ex.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> exceptins3(MethodArgumentNotValidException ex){
		String error=ex.getAllErrors().stream().map(x->x.getDefaultMessage()).collect(Collectors.joining(","));
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> exceptins3(ConstraintViolationException ex){
		String error=ex.getConstraintViolations().stream().map(x->x.getMessage()).collect(Collectors.joining(","));
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);	
	}
}
