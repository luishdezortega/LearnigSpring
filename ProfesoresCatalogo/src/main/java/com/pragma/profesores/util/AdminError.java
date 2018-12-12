package com.pragma.profesores.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AdminError {
	
	
	private String errorMensaje;
	
	

	public AdminError(String errorMensaje) {
		super();
		this.errorMensaje = errorMensaje;
	}



	public String getErrorMensaje() {
		return errorMensaje;
	}
	
	
// return new ResponseEntity(new AdminError("Se requiere el id de la red social"), HttpStatus.CONFLICT); Se emplea para cada error!
}
