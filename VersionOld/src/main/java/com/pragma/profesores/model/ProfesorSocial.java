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
@Table(name="teacher_social_media")
public class ProfesorSocial implements Serializable {
	
	
	@Id
	@Column(name="id_teacher_social_media")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idProfeSocial;
	
	
	@Column(name="nickname")
	private String nickname;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_teacher")
	private Profesor profesorr;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_social_media")
	private RedSocial socialMedia;
	
	
	public ProfesorSocial() {
		super();
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public Profesor getProfesorr() {
		return profesorr;
	}


	public void setProfesorr(Profesor profesorr) {
		this.profesorr = profesorr;
	}


	public RedSocial getSocialMedia() {
		return socialMedia;
	}


	public void setSocialMedia(RedSocial socialMedia) {
		this.socialMedia = socialMedia;
	}


	public long getIdProfeSocial() {
		return idProfeSocial;
	}


	public ProfesorSocial(String nickname, Profesor profesorr, RedSocial socialMedia) {
		super();
		this.nickname = nickname;
		this.profesorr = profesorr;
		this.socialMedia = socialMedia;
	}


	
}
