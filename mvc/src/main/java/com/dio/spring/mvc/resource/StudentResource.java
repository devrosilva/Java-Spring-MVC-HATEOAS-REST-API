package com.dio.spring.mvc.resource;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.dio.spring.mvc.controller.DisciplineController;
import com.dio.spring.mvc.controller.StudentController;
import com.dio.spring.mvc.model.Discipline;
import com.dio.spring.mvc.model.Student;

public class StudentResource {
	
	private StudentResource() {
		
	}

	public static Student addResourcesToStudent(Student student) {
		
		addLinkToStudent(student);
		addLinkToDisciplines(student);
		return student;
	}
	
	public static Student addLinkToStudent(Student student) {
		
		return student.add(linkTo(methodOn(StudentController.class, student).getStudent(student.getId())).withSelfRel());
	}
	
	public static Student addLinkToDisciplines(Student student) {
		
		if(student.getDisciplines() != null) {
			
			for(Discipline discipline : student.getDisciplines()) {
				
				student.add(linkTo(methodOn(DisciplineController.class, student).getDiscipline(discipline.getCode())).withRel("Disciplines"));
			}
		}
		
		return student;
	}
}
