package com.dio.spring.mvc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dio.spring.mvc.exception.DisciplineAlreadyRegisteredException;
import com.dio.spring.mvc.model.Student;
import com.dio.spring.mvc.service.IStudentService;

@RestController
@RequestMapping("/")
public class StudentController{
	
	private IStudentService service;
	
	public StudentController(IStudentService service) {
		this.service = service;
	}

	@PostMapping("students")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){

		return service.createStudent(student);
	}
	
	@PutMapping("students")
	public ResponseEntity<Student> addDiscipline(@RequestParam(name="id") Integer id, @RequestParam(name="discipline") Integer code) throws DisciplineAlreadyRegisteredException{

		return service.addDisciplineToStudent(id, code);
	}
	
	@GetMapping("students")
	public ResponseEntity<List<Student>> getStudentList(){
		
		return service.getStudentList();
	}
	
	@GetMapping("students/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") Integer id) {
		
		return service.getStudent(id);
	}
}
