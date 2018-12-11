package com.pragma.profesores.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pragma.profesores.dao.ProfesorDao;
import com.pragma.profesores.model.Profesor;

@Service("profesorService")
@Transactional
public class ProfesorServiceImplements implements ProfesorService {

	@Autowired
	private ProfesorDao profesorDao;
	
	
	@Override
	public void guardarProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		profesorDao.guardarProfesor(profesor);
	}

	@Override
	public void borrarProfesor(Long id_Profesor) {
		// TODO Auto-generated method stub
		profesorDao.borrarProfesor(id_Profesor);
	}

	@Override
	public void actualizarProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		profesorDao.actualizarProfesor(profesor);
	}

	@Override
	public List<Profesor> listarProfes() {
		// TODO Auto-generated method stub
		return profesorDao.listarProfes();
	}

	@Override
	public Profesor buscarProfeID(Long id_Profesor) {
		// TODO Auto-generated method stub
		return profesorDao.buscarProfeID(id_Profesor);
	}

	@Override
	public Profesor buscarProfeNombre(String name) {
		// TODO Auto-generated method stub
		return profesorDao.buscarProfeNombre(name);
	}

}
