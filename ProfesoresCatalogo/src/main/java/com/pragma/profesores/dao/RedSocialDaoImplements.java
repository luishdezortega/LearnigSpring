package com.pragma.profesores.dao;

import java.util.List;

import com.pragma.profesores.model.Curso;
import com.pragma.profesores.model.ProfesorSocial;
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

	@Override
	public RedSocial buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return (RedSocial) getSession().createQuery("from RedSocial where nombreRS = :nombreRS").setParameter("nombreRS", nombre).uniqueResult();
	}

	@Override
	public ProfesorSocial buscarPorRedYProfe(Long idRedSocial, String nickname) {
		// TODO Auto-generated method stub
		List<Object[]> objects = getSession().createQuery(
				"from ProfesorSocial ps join ps.socialMedia sm"
				+ "where sm.id_socialMedia = :id_SocialMedia and ps.nickname = :nickname")
				.setParameter("id_SocialMedia",idRedSocial)
				.setParameter("nickname", nickname).list();
			
		if(objects.size()>0) {
			for (Object[] objects2 : objects) {
				for (Object object : objects2) {
					if(object instanceof ProfesorSocial) {
						return (ProfesorSocial) object;
					}
				}
				
			}
		}
		return null;
	}
	
}
