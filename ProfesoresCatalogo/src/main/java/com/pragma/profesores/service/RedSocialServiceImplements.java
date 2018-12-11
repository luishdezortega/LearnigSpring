package com.pragma.profesores.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pragma.profesores.dao.RedSocialDao;
import com.pragma.profesores.model.ProfesorSocial;
import com.pragma.profesores.model.RedSocial;

@Service("redSocialService")
@Transactional
public class RedSocialServiceImplements implements RedSocialService {

	@Autowired
	private RedSocialDao redSocialDao;
	
	
	@Override
	public void saveSocialMedia(RedSocial redSocial) {
		// TODO Auto-generated method stub
		redSocialDao.saveSocialMedia(redSocial);
	}

	@Override
	public void borrarRedsocialPorID(Long id) {
		// TODO Auto-generated method stub
		redSocialDao.borrarRedsocialPorID(id);
	}

	@Override
	public void actualizarRedSocial(RedSocial redSocial) {
		// TODO Auto-generated method stub
		redSocialDao.actualizarRedSocial(redSocial);
	}

	@Override
	public List<RedSocial> lisarTodasLasRS() {
		// TODO Auto-generated method stub
		return redSocialDao.lisarTodasLasRS();
	}

	@Override
	public RedSocial buscarPorID(Long idRedSocial) {
		// TODO Auto-generated method stub
		return redSocialDao.buscarPorID(idRedSocial);
	}

	@Override
	public RedSocial buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return redSocialDao.buscarPorNombre(nombre);
	}

	@Override
	public ProfesorSocial buscarPorRedYProfe(Long idRedSocial, String nickname) {
		// TODO Auto-generated method stub
		return redSocialDao.buscarPorRedYProfe(idRedSocial, nickname);
	}

}
