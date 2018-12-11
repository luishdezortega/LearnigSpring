package com.pragma.profesores.dao;

import java.util.List;

import com.pragma.profesores.model.Curso;
import com.pragma.profesores.model.Profesor;

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

	@Override
	public Curso buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return (Curso) getSession().createQuery("from Curso where nombre_Curso = :nombre_Curso").setParameter("nombre_Curso", nombre).uniqueResult();
	}

	@Override
	public List<Curso> buscarPorProfe(Long idProfesor) {
		// TODO Auto-generated method stub
		return(List<Curso>) getSession().createQuery(
				"from Curso c join c.profesor p where p.id_Profesor = :id_Profesor")
				.setParameter("id_Profesor", idProfesor).list();
				
	}

}
