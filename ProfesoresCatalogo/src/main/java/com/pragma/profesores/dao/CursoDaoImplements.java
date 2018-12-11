package com.pragma.profesores.dao;

import java.util.List;

import com.pragma.profesores.model.Curso;

public class CursoDaoImplements extends AbstractSession implements CursoDao {

	@Override
	public void guardarCurso(Curso curso) {
		// TODO Auto-generated method stub
		getSession().persist(curso);
	}

	@Override
	public void borrarCursoPorID(Long idCurso) {
		// TODO Auto-generated method stub
		Curso curso = buscarPorID(idCurso);
		if (curso  != null) {
			getSession().delete(curso);
		}
	}

	@Override
	public void actualizarCurso(Curso curso) {
		// TODO Auto-generated method stub
		getSession().update(curso);
	}

	@Override
	public List<Curso> listarTodos() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Curso").list();
	}

	@Override
	public Curso buscarPorID(Long idCurso) {
		// TODO Auto-generated method stub
		return (Curso) getSession().get(Curso.class, idCurso);
	}

}
