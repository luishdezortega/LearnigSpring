package com.pragma.profesores.dao;

import java.util.List;

import com.pragma.profesores.model.ProfesorSocial;
import com.pragma.profesores.model.RedSocial;

public interface RedSocialDao {
	
	
	void guadarRedSocial(RedSocial redSocial);
	
	void borrarRedSocial(Long id_RedSocial);
	
	void actualizarRedSocial(RedSocial redSocial);
	
	List<RedSocial> listarRedSocial();
	
	RedSocial buscarPorID_RS(Long idRedSocial);
	
	RedSocial buscarPorNombre_P(String nombre_P);
	
	ProfesorSocial buscarRS_ID_NProfesor(Long id_RedSocial, String nickName );
}
