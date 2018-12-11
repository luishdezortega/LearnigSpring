package com.pragma.profesores.service;

import java.util.List;

import com.pragma.profesores.model.ProfesorSocial;
import com.pragma.profesores.model.RedSocial;

public interface RedSocialService {

	
	void saveSocialMedia(RedSocial redSocial);
	
	void borrarRedsocialPorID(Long id);
	
	void actualizarRedSocial(RedSocial redSocial);
	
	List<RedSocial> lisarTodasLasRS();
	
	RedSocial buscarPorID(Long idRedSocial);
	
	RedSocial buscarPorNombre(String nombre);
	
	ProfesorSocial buscarPorRedYProfe(Long idRedSocial, String nickname);
}
