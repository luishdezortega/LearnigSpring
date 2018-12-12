package com.pragma.profesores.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

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
	
	//Metodo GET
	@RequestMapping(value="/redSocial/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<RedSocial> getRedSocialPorId(@PathVariable("id") Long idRedSocial){
		
		if(idRedSocial == null || idRedSocial <=0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		RedSocial redSocial = redSocialService.buscarPorID(idRedSocial);
		
		if(redSocial ==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<RedSocial>(redSocial, HttpStatus.OK);
	}
	
	//Metodos POST
	
	
	@RequestMapping(value="/redSocial", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> crearRedSocial(@RequestBody RedSocial redSocial, UriComponentsBuilder uriComponentsBuilder){
		if(redSocial.getNombreRS().equals(null) || redSocial.getNombreRS().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		if(redSocialService.buscarPorID(redSocial.getId_SocialMedia()) !=null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		redSocialService.saveSocialMedia(redSocial);
		RedSocial auxRedSocial = redSocialService.buscarPorNombre(redSocial.getNombreRS());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder.path("/v1/redSocial/{id}").buildAndExpand(auxRedSocial.getId_SocialMedia()).toUri());

	
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	
	}
	
	//Metodo Update
	@RequestMapping(value="/redSocial/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<RedSocial> actualizarRedSocial(@PathVariable("id") Long id_RedSocial, @RequestBody RedSocial redSocial){
	
		
		RedSocial auxRedSocial = redSocialService.buscarPorID(id_RedSocial);
		
		if(auxRedSocial == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		auxRedSocial.setNombreRS(redSocial.getNombreRS());
		auxRedSocial.setIcono_RS(redSocial.getIcono_RS());
		
		redSocialService.actualizarRedSocial(auxRedSocial);
		return new ResponseEntity<RedSocial>(auxRedSocial, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/redSocial/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> borrarRedSocial(@PathVariable("id") Long idRedSocial){
		
		if(idRedSocial == null || idRedSocial <=0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	
		RedSocial redSocial = redSocialService.buscarPorID(idRedSocial);
		if(redSocial == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		redSocialService.borrarRedsocialPorID(idRedSocial);
		return new ResponseEntity<RedSocial>(HttpStatus.OK);
		
	}
	
	

	
	
	
}
