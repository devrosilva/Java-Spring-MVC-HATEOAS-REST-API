package com.dio.spring.mvc.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dio.spring.mvc.model.Discipline;


public interface IDisciplineDao extends CrudRepository<Discipline,Integer> {

	Optional<Discipline> findByCode(Integer code);
	boolean existsByCode(Integer code);
}
