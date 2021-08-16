package com.dio.spring.mvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dio.spring.mvc.dao.IDisciplineDao;
import com.dio.spring.mvc.dao.IStudentDao;
import com.dio.spring.mvc.exception.DisciplineAlreadyRegisteredException;
import com.dio.spring.mvc.model.Discipline;
import com.dio.spring.mvc.model.Student;
import com.dio.spring.mvc.resource.StudentResource;

@Service
public class StudentService implements IStudentService{

	@Autowired
	private IStudentDao sDao;
	
	@Autowired
	private IDisciplineDao dDao;

	public ResponseEntity<Student> createStudent(Student student){
		
		if( (student.getName().trim() != null && 
			 student.getLastName().trim() != null && 
			 student.getCpf().trim() != null)){
			
			Optional<Student> result = sDao.findByCpf(student.getCpf());
			
			if(result.isEmpty()) {
				return ResponseEntity.status(HttpStatus.CREATED).body(sDao.save(student));
			}
		}
		return ResponseEntity.badRequest().build();
	}
	
	public ResponseEntity<Student> addDisciplineToStudent(Integer id, Integer code) throws DisciplineAlreadyRegisteredException {
		
		if(sDao.existsById(id) && dDao.existsByCode(code)) {

			Optional<Student> student = sDao.findById(id);
			Optional<Discipline> discipline = dDao.findByCode(code);
			
			if(student.get().getDisciplines().contains(discipline.get())) {
				throw new DisciplineAlreadyRegisteredException(code);
			}
			else {
				student.get().getDisciplines().add(discipline.get());
				sDao.save(student.get());
			}
			return ResponseEntity.ok(student.get());
		}
		return ResponseEntity.badRequest().build();
	}

	@Override
	public ResponseEntity<List<Student>> getStudentList() {

		Iterable<Student> iterable = sDao.findAll();
		
		List<Student> students = new ArrayList<Student>();
		
		for(Student student : iterable) {
			StudentResource.addResourcesToStudent(student);
			students.add(student);
		}
		return ResponseEntity.ok(students);
	}

	@Override
	public ResponseEntity<Student> getStudent(Integer id) {

		Optional<Student> result = sDao.findById(id);
		
		if(result.isPresent()) {
			StudentResource.addResourcesToStudent(result.get());
			return ResponseEntity.ok(result.get());
		}
		return ResponseEntity.badRequest().build();
	}

}
