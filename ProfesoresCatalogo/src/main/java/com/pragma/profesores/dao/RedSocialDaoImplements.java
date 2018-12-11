package com.pragma.profesores.dao;

import java.util.List;

import com.pragma.profesores.model.RedSocial;

public class RedSocialDaoImplements extends AbstractSession implements RedSocialDao {

	@Override
	public void saveSocialMedia(RedSocial redSocial) {
		// TODO Auto-generated method stub
		getSession().persist(redSocial);
	}

	@Override
	public void borrarRedsocialPorID(Long id) {
		// TODO Auto-generated method stub
		RedSocial redSocial = buscarPorID(id);
		if (redSocial  != null) {
			getSession().delete(redSocial);
		}
	}

	@Override
	public void actualizarRedSocial(RedSocial redSocial) {
		// TODO Auto-generated method stub
		getSession().update(redSocial);
	}

	@Override
	public List<RedSocial> lisarTodasLasRS() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from RedSocial").list();
	}

	@Override
	public RedSocial buscarPorID(Long idRedSocial) {
		// TODO Auto-generated method stub
		return (RedSocial) getSession().get(RedSocial.class, idRedSocial);
	}

}
