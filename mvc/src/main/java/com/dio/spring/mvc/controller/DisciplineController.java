package com.dio.spring.mvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.spring.mvc.model.Discipline;
import com.dio.spring.mvc.service.IDisciplineService;

@RestController
@RequestMapping("/")
public class DisciplineController {

	private IDisciplineService service;
	
	public DisciplineController(IDisciplineService service) {
		
		this.service = service;
	}
	
	@PostMapping("disciplines")
	public ResponseEntity<Discipline> createDiscipline(@RequestBody Discipline discipline){

		return service.createDiscipline(discipline);
	}

	@GetMapping("disciplines/{code}")
	public ResponseEntity<Discipline> getDiscipline(@PathVariable("code") Integer code) {

		return service.getDiscipline(code);
	}
}
