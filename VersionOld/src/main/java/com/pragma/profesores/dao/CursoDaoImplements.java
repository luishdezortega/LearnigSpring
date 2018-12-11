package com.pragma.profesores.dao;

import java.util.List;

import com.pragma.profesores.model.Curso;
import com.pragma.profesores.model.Profesor;

public class CursoDaoImplements extends AbstractSession implements CursoDao {

	@Override
	public void guardarCurso(Curso course) {
		
		getSession().persist(course);
		
	}

	@Override
	public void borrarCurso(Long idCurso) {

		Curso curso = buscarCursoPorID(idCurso);
		if(curso !=null) {
			getSession().delete(curso);
		}
	}

	@Override
	public void actualizarCurso(Curso curso) {
		
		getSession().update(curso);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> listarCursos() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Curso").list();
	}

	@Override
	public Curso buscarCursoPorID(Long idCurso) {
		// TODO Auto-generated method stub
		return (Curso) getSession().get(Curso.class, idCurso);
	}

	@Override
	public Curso buscarPorNombre(String nombre_Curso) {
		// TODO Auto-generated method stub
		return (Curso) getSession().createQuery("from Curso where nombre_Curso = :nombre_Curso").setParameter("nombre_Curso",nombre_Curso).uniqueResult();
	}

	@Override
	public List<Curso> buscarCursosPorProfesor(Long id_Profesor) {
		// TODO Auto-generated method stub
		return (List<Curso>) getSession().createQuery(
				"from Curso c join c.profesor t where t.id_Profesor = :id_Profesor")
				.setParameter("id_Profesor", id_Profesor).list();
	}


}
