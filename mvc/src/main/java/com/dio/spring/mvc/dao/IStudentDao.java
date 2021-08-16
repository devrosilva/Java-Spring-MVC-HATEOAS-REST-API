package com.dio.spring.mvc.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dio.spring.mvc.model.Student;

public interface IStudentDao extends CrudRepository<Student, Integer>{

	Optional<Student> findByCpf(String cpf);
}
