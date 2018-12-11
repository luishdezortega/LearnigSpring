package com.pragma.hibernate.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author luis.hernandez
 *
 */


@Entity
@Table(name="social_media")
public class RedSocial implements Serializable{

	@Id
	@Column(name="id_social_media")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_SocialMedia;
	
	@Column(name="name")
	private String nombreRS;
	
	@Column(name="icon")
	private String icono_RS;
	
	
	@OneToMany
	@JoinColumn(name="id_social_media")
	private Set<ProfesorSocial> profesor_social;

		
	public RedSocial() {
		super();
	}


	public long getId_SocialMedia() {
		return id_SocialMedia;
	}


	public String getNombreRS() {
		return nombreRS;
	}


	public void setNombreRS(String nombreRS) {
		this.nombreRS = nombreRS;
	}


	public String getIcono_RS() {
		return icono_RS;
	}


	public void setIcono_RS(String icono_RS) {
		this.icono_RS = icono_RS;
	}


	public Set<ProfesorSocial> getProfesor_social() {
		return profesor_social;
	}


	public void setProfesor_social(Set<ProfesorSocial> profesor_social) {
		this.profesor_social = profesor_social;
	}


	public RedSocial(String nombreRS, String icono_RS, Set<ProfesorSocial> profesor_social) {
		super();
		this.nombreRS = nombreRS;
		this.icono_RS = icono_RS;
		this.profesor_social = profesor_social;
	}


}
