package com.dio.spring.mvc.service;

import org.springframework.http.ResponseEntity;

import com.dio.spring.mvc.model.Discipline;

public interface IDisciplineService {

	public ResponseEntity<Discipline> createDiscipline(Discipline discipline);
	
	public ResponseEntity<Discipline> getDiscipline(Integer code);
}
