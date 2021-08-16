package com.dio.spring.mvc.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dio.spring.mvc.dao.IDisciplineDao;
import com.dio.spring.mvc.model.Discipline;

@Service
public class DisciplineService implements IDisciplineService {
	
	private IDisciplineDao dao;
	
	public DisciplineService(IDisciplineDao dao) {
		this.dao = dao;
	}

	@Override
	public ResponseEntity<Discipline> createDiscipline(Discipline discipline) {

		if(discipline.getName().trim() != null && discipline.getCode() != null) {
			
			Optional<Discipline> result = dao.findByCode(discipline.getCode());
			if(result.isPresent()) {
				return ResponseEntity.badRequest().build();
			}
			else {
				return ResponseEntity.status(HttpStatus.CREATED).body(dao.save(discipline));
			}
		}
		return ResponseEntity.badRequest().build();
	}

	@Override
	public ResponseEntity<Discipline> getDiscipline(Integer code) {

		Optional<Discipline> discipline = dao.findByCode(code);
		
		if(discipline.isPresent()) {
			return ResponseEntity.ok(discipline.get());
		}
		return ResponseEntity.badRequest().build();
	}	
}


