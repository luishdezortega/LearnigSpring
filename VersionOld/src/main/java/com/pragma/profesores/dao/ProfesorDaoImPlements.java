package com.pragma.profesores.dao;

import java.util.Iterator;
import java.util.List;

import com.pragma.profesores.model.Profesor;
import com.pragma.profesores.model.ProfesorSocial;



public class ProfesorDaoImPlements extends AbstractSession implements ProfesorDao {
	
	
	

	public void guardarProfesor(Profesor profesor) {
		getSession().persist(profesor);
	}

	public void borrarProfesor(Long id_Profesor) {
		// TODO Auto-generated method stub
		Profesor profesor = buscarProfeID(id_Profesor);
		if(profesor !=null) {
			
			Iterator<ProfesorSocial> i = profesor.getProfesor_social().iterator();
			while(i.hasNext()) {
				ProfesorSocial profesorSocial = i.next();
				i.remove();
				getSession().delete(profesorSocial);
			}
			profesor.getProfesor_social().getClass();
			getSession().delete(profesor);
		}
	}

	public void actualizarProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		getSession().update(profesor);
	}

	@SuppressWarnings("unchecked")
	public List<Profesor> listarProfes() {
		return getSession().createQuery("from Profesor").list();
	}

	public Profesor buscarProfeID(Long id_Profesor) {
		// TODO Auto-generated method stub
		return (Profesor) getSession().get(Profesor.class, id_Profesor);
	}

	public Profesor buscarProfeNombre(String nombre_Profesor) {
		// TODO Auto-generated method stub
		return (Profesor) getSession().createQuery("from Profesor where nombre_P = :nombre_P").setParameter("nombre_P",nombre_Profesor).uniqueResult();
				
	}

	
	
	
	
}
