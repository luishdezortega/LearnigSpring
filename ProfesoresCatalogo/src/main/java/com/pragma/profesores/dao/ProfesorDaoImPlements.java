package com.pragma.profesores.dao;

import java.util.List;

import com.pragma.profesores.model.Profesor;




public class ProfesorDaoImPlements extends AbstractSession implements ProfesorDao {
	
	
	

	public void guardarProfesor(Profesor profesor) {
			getSession().persist(profesor);
	}

	public void borrarProfesor(Long id_Profesor) {
		
		Profesor profe = buscarProfeID(id_Profesor);
		if(profe != null) {
			getSession().delete(profe);
		}
	}

	public void actualizarProfesor(Profesor profesor) {
		
		getSession().update(profesor);
	}

	public List<Profesor> listarProfes() {
		
		return getSession().createQuery("from Profesor").list();
	}

	public Profesor buscarProfeID(Long id_Profesor) {
		
		return (Profesor) getSession().get(Profesor.class,id_Profesor);
	}

	public Profesor buscarProfeNombre(String nombre) {
		
		return (Profesor) getSession().createQuery("from Profesor where nombre_P = :nombre_P").setParameter("nombre_P", nombre).uniqueResult();
	}

}
