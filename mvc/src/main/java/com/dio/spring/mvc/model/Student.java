package com.dio.spring.mvc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_students")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student extends RepresentationModel<Student>{

	@Id
	@GeneratedValue(generator = "student_id_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "student_id_sequence", sequenceName = "student_id_sequence", allocationSize = 10)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "cpf")
	private String cpf;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tb_students_disciplines", joinColumns = {@JoinColumn(name = "tb_students_id")}, inverseJoinColumns = {@JoinColumn(name = "tb_disciplines_id")})
	@JsonIgnoreProperties("students")
	private List<Discipline> disciplines;

	public Student() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public List<Discipline> getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(List<Discipline> disciplines) {
		this.disciplines = disciplines;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
