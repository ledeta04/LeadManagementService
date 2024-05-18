package com.craft.LeadManagementService.BadRequestException;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class exceptionHandler {
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	
	public Map<String, String> exceptionHandlerMethod(MethodArgumentNotValidException exceptionVariable){
		
		Map<String, String> errors = new HashMap<>();
		
		exceptionVariable.getBindingResult().getFieldErrors().forEach(e ->{
			
			errors.put(e.getField(), e.getDefaultMessage());
		});
		
		return errors;
	}
	
}
