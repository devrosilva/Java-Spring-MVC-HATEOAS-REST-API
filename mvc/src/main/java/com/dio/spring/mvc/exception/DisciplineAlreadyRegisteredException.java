package com.dio.spring.mvc.exception;

public class DisciplineAlreadyRegisteredException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3669508708768347434L;
	
	public DisciplineAlreadyRegisteredException(Integer code){
		
		super("Disciplina número " + code + " já cadastrada.");
	}

}
