package com.pragma.hibernate.model;

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
	private Profesor profesor;
	
	
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
		return profesor;
	}


	public void setProfesorr(Profesor profesor) {
		this.profesor = profesor;
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


	public ProfesorSocial(String nickname, Profesor profesor, RedSocial socialMedia) {
		super();
		this.nickname = nickname;
		this.profesor = profesor;
		this.socialMedia = socialMedia;
	}


	
}
