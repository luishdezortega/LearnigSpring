package com.pragma.profesores.dao;

import java.util.List;

import com.pragma.profesores.model.Curso;

public interface CursoDao {
	
	void guardarCurso(Curso course);
	
	void borrarCurso(Long idCourse);
	
	void actualizarCurso(Curso course);
	
	List<Curso> listarCursos();
	
	Curso buscarCursoPorID(Long idCourse);
	
	Curso buscarPorNombre(String nombre_Curso);
	
	List<Curso> buscarCursosPorProfesor(Long id_Profesor);

}
