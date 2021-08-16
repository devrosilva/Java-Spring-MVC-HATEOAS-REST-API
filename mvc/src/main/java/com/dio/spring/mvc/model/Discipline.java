package com.dio.spring.mvc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_disciplines")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Discipline extends RepresentationModel<Discipline>{

	@Id
	@GeneratedValue(generator = "disciplines_id_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "disciplines_id_sequence", sequenceName = "disciplines_id_sequence", allocationSize = 10)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "code")
	private Integer code;
	
	@ManyToMany(mappedBy = "disciplines", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("disciplines")
	private List<Student> students;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
