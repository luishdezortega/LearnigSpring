package com.pragma.profesores.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.pragma.profesores.model.Profesor;
import com.pragma.profesores.service.ProfesorService;
import com.pragma.profesores.util.AdminError;


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
	
	
	// Imagenes del profesor
	public static final String CARGAR_AVATAR_PROFESOR = "imagenes/profesor/";
	
	@RequestMapping(value="/Profesor/imagenes", method = RequestMethod.POST, headers=("content-type=multipart/form-data"))
	public ResponseEntity<byte[]> cargarImagenDelProfe( @RequestParam("id_Profesor") Long id_Profesor,
			@RequestParam("file") MultipartFile multipartFile,
			UriComponentsBuilder componentBuilder){
		
		if(id_Profesor == null) {
			return new ResponseEntity( new AdminError(" Escriba un id valido"), HttpStatus.NO_CONTENT);
		}
		
		if(multipartFile.isEmpty()) {
			return new ResponseEntity( new AdminError(" Agregue una imagen"), HttpStatus.NO_CONTENT);
		}
		
		Profesor profesor = profesorService.buscarProfeID(id_Profesor);
		if(profesor == null) {
			return new ResponseEntity(new AdminError(" No fue encontrado"), HttpStatus.NOT_FOUND);
			
		}
		
		if(!profesor.getAvatar_P().isEmpty() || profesor.getAvatar_P() !=null) {
			String nombreArchivo= profesor.getAvatar_P();
			Path path = Paths.get(nombreArchivo);
			File f = path.toFile();
			
			if(f.exists()) {
				f.delete();
			}
		}
		
		try {
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String dateName = dateFormat.format(date);
			
			String nombreArchivo = String.valueOf(id_Profesor)+ "-pictueProfesor-"+ dateName + "." + multipartFile.getContentType().split("/")[1];
			profesor.setAvatar_P(CARGAR_AVATAR_PROFESOR+nombreArchivo);
			
			byte[] bytes = multipartFile.getBytes();
			Path path = Paths.get(CARGAR_AVATAR_PROFESOR + nombreArchivo);
			Files.write(path, bytes);
			
			profesorService.actualizarProfesor(profesor);
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
		}catch(Exception e) {
			
			e.printStackTrace();
			return new ResponseEntity( new AdminError(" Error al subir imagen"), HttpStatus.NOT_FOUND);
			
		}
		
		
	}
	
}
