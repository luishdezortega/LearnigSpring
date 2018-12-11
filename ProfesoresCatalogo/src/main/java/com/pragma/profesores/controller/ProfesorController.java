package com.pragma.profesores.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pragma.profesores.model.Profesor;
import com.pragma.profesores.model.RedSocial;
import com.pragma.profesores.service.ProfesorService;

@Controller
@RequestMapping("/v1")
public class ProfesorController {

	
	@Autowired
	private ProfesorService profesorService;
	
	@RequestMapping(value="/profesor", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Profesor>> getProfesor(){
		List<Profesor> profesor = new ArrayList<>();
		profesor = profesorService.listarProfes();
		if(profesor.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Profesor>>(profesor, HttpStatus.OK);
	}
	
}
