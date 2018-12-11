package com.pragma.profesores.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pragma.profesores.dao.CursoDao;
import com.pragma.profesores.model.Curso;

@Service("cursoService")
@Transactional
public class CursoServiceImplements implements CursoService{
	
	
	@Autowired
	private CursoDao cursoDao;

	@Override
	public void guardarCurso(Curso curso) {
		
		cursoDao.guardarCurso(curso);
	}

	@Override
	public void borrarCursoPorID(Long idCurso) {
		// TODO Auto-generated method stub
		cursoDao.borrarCursoPorID(idCurso);
	}

	@Override
	public void actualizarCurso(Curso curso) {
		// TODO Auto-generated method stub
		cursoDao.actualizarCurso(curso);
	}

	@Override
	public List<Curso> listarTodos() {
		// TODO Auto-generated method stub
		return cursoDao.listarTodos();
	}

	@Override
	public Curso buscarPorID(Long idCurso) {
		// TODO Auto-generated method stub
		return cursoDao.buscarPorID(idCurso);
	}

	@Override
	public Curso buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return cursoDao.buscarPorNombre(nombre);
	}

	@Override
	public List<Curso> buscarPorProfe(Long idProfesor) {
		// TODO Auto-generated method stub
		return cursoDao.buscarPorProfe(idProfesor);
	}
	
	

}
