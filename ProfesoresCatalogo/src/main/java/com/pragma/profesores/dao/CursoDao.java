package com.pragma.profesores.dao;

import java.util.List;

import com.pragma.profesores.model.Curso;

public interface CursoDao {

	
	void guardarCurso(Curso curso);
	
	void borrarCursoPorID(Long idCurso);
	
	void actualizarCurso(Curso curso);
	
	List<Curso> listarTodos();
	
	Curso buscarPorID(Long idCurso);
	
	Curso buscarPorNombre(String nombre);
	
	List<Curso> buscarPorProfe(Long idProfesor);
	
}
