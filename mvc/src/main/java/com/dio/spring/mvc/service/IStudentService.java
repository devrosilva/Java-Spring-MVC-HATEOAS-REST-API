package com.dio.spring.mvc.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dio.spring.mvc.exception.DisciplineAlreadyRegisteredException;
import com.dio.spring.mvc.model.Student;

public interface IStudentService {

	public ResponseEntity<Student> createStudent(Student student);
	
	public ResponseEntity<Student> addDisciplineToStudent(Integer id, Integer code) throws DisciplineAlreadyRegisteredException;
	
	public ResponseEntity<List<Student>> getStudentList();

	public ResponseEntity<Student> getStudent(Integer id);
}
