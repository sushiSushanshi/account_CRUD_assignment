package com.account.exception.handler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hibernate.TransientPropertyValueException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(ConstraintViolationException.class)
	public Set<String> handleInvalidArguments(ConstraintViolationException e){
		Set<String> errorSet = new HashSet();
		e.getConstraintViolations().forEach(error ->{
			errorSet.add(error.getMessage());
		});
		return errorSet;
	}
	
	@ExceptionHandler(SQLException.class)
	public String handleInvalidArgumentsa(SQLException e){
		return e.getLocalizedMessage();
	}
	
	@ExceptionHandler(TransientPropertyValueException.class)
	public String handleInvalidArgumentsa(TransientPropertyValueException e){
		return e.getLocalizedMessage();
	}
}
