package com.pragma.profesores.dao;

import java.util.List;

import com.pragma.profesores.model.Curso;
import com.pragma.profesores.model.ProfesorSocial;
import com.pragma.profesores.model.RedSocial;

public class RedSocialDaoImplements extends AbstractSession implements RedSocialDao{

	@Override
	public void guadarRedSocial(RedSocial redSocial) {
		// TODO Auto-generated method stub
		getSession().persist(redSocial);
	}

	@Override
	public void borrarRedSocial(Long id_RedSocial) {
		// TODO Auto-generated method stub
		RedSocial redSocial = buscarPorID_RS(id_RedSocial);
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
	public List<RedSocial> listarRedSocial() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from RedSocial").list();
	}

	@Override
	public RedSocial buscarPorID_RS(Long idRedSocial) {
		// TODO Auto-generated method stub
		return (RedSocial) getSession().get(RedSocial.class, idRedSocial);
	}

	@Override
	public RedSocial buscarPorNombre_P(String nombre_RS) {
		// TODO Auto-generated method stub
		return (RedSocial) getSession().createQuery("from RedSocial where nombreRS = :nombreRS").setParameter("nombreRS",nombre_RS).uniqueResult();
	}

	@Override
	public ProfesorSocial buscarRS_ID_NProfesor(Long id_RedSocial, String nickName) {
		// TODO Auto-generated method stub
		List<Object[]> objects = getSession().createQuery(
								"from ProfesorSocial ps join ps.socialMedia rs"
				+ " where rs.id_social_media = :id_social_media and ps.nickname = :nickname")
				.setParameter("id_social_media",id_RedSocial)
				.setParameter("nickname",nickName).list();
				
			if(objects.size()>0) {
				for(Object[] objects2 : objects ) {
					for(Object object : objects2) {
						if(object instanceof ProfesorSocial) {
							return (ProfesorSocial) object;
						}
					}
				}
			}
			return null;
		}

}
