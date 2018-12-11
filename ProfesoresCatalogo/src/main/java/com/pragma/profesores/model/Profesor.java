package com.pragma.profesores.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="teacher")
public class Profesor implements Serializable {

	@Id
	@Column(name="id_teacher")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_Profesor;
	
		@Column(name="name")
	private String nombre_P;
	
	@Column(name="avatar")
	private String avatar_P;
	
	
	
	
	@OneToMany(mappedBy="profesor")
	private Set<Curso> cursos;
		
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_teacher")
	private Set<ProfesorSocial> profesor_social;


	public Profesor() {
		super();
	}


	public String getNombre_P() {
		return nombre_P;
	}


	public void setNombre_P(String nombre_P) {
		this.nombre_P = nombre_P;
	}


	public String getAvatar_P() {
		return avatar_P;
	}


	public void setAvatar_P(String avatar_P) {
		this.avatar_P = avatar_P;
	}


	public Set<Curso> getCursos() {
		return cursos;
	}


	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}


	public Set<ProfesorSocial> getProfesor_social() {
		return profesor_social;
	}


	public void setProfesor_social(Set<ProfesorSocial> profesor_social) {
		this.profesor_social = profesor_social;
	}


	public long getId_Profesor() {
		return id_Profesor;
	}


	public Profesor(String nombre_P, String avatar_P) {
		super();
		this.nombre_P = nombre_P;
		this.avatar_P = avatar_P;
	}


	
}
