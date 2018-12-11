package com.pragma.profesores.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="course")
public class Curso implements Serializable{
	
	
	@Id
	@Column(name="id_course")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_Curso;
	
	@Column(name="name")
	private String nombre_Curso;
	
	@Column(name="themes")
	private String tema;
	
	@Column(name="project")
	private String project;
	
	
	@ManyToOne(optional=true, fetch=FetchType.EAGER)
	@JoinColumn(name= "id_teacher")
	private Profesor profesor; 
	
	
	public Curso() {
		super();
	}


	public String getNombre_Curso() {
		return nombre_Curso;
	}


	public void setNombre_Curso(String nombre_Curso) {
		this.nombre_Curso = nombre_Curso;
	}


	public String getTema() {
		return tema;
	}


	public void setTema(String tema) {
		this.tema = tema;
	}


	public String getProject() {
		return project;
	}


	public void setProject(String project) {
		this.project = project;
	}


	public Profesor getProfesor() {
		return profesor;
	}


	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}


	public long getId_Curso() {
		return id_Curso;
	}


	public Curso(String nombre_Curso, String tema, String project) {
		super();
		this.nombre_Curso = nombre_Curso;
		this.tema = tema;
		this.project = project;
		
	}


	
}
