package com.dio.spring.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DisciplineAlreadyRegisteredAdvice {

	@ResponseBody
	@ExceptionHandler(DisciplineAlreadyRegisteredException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String disciplineAlreadyRegisteredHandler(DisciplineAlreadyRegisteredException ex) {
		
		return ex.getMessage();
	}
}
