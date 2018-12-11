package com.pragma.profesores.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.pragma.profesores.model.RedSocial;
import com.pragma.profesores.service.RedSocialService;


@Controller
@RequestMapping("/v1")
public class RedSocialController {

	@Autowired
	RedSocialService redSocialService;
	//METODOS GET
	
	@RequestMapping(value="/redSocial", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<RedSocial>> getRedSocial(){
		List<RedSocial> redSocial = new ArrayList<>();
		redSocial = redSocialService.lisarTodasLasRS();
		if(redSocial.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<RedSocial>>(redSocial, HttpStatus.OK);
	}

	
	
	
}
