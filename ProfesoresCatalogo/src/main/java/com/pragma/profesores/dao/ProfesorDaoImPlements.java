package com.pragma.profesores.dao;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.pragma.profesores.model.Profesor;
import com.pragma.profesores.model.ProfesorSocial;



@Repository
@Transactional
public class ProfesorDaoImPlements extends AbstractSession implements ProfesorDao {
	
	
	

	public void guardarProfesor(Profesor profesor) {
			getSession().persist(profesor);
	}

	public void borrarProfesor(Long id_Profesor) {
		
		Profesor profe = buscarProfeID(id_Profesor);
		if(profe != null) {
			
			Iterator<ProfesorSocial> i = profe.getProfesor_social().iterator();
			while(i.hasNext()) {
				ProfesorSocial profesorSocial = i.next();
				i.remove();
				getSession().delete(profesorSocial);
			}
			
			profe.getProfesor_social().clear();
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
