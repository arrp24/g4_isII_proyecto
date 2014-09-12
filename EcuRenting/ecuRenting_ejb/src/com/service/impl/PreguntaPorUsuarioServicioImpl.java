package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.PreguntaPorUsuarioDao;
import com.ls.gestion.entity.PreguntaPorUsuario;
import com.ls.gestion.service.PreguntaPorUsuarioServicioLocal;
import com.ls.gestion.service.PreguntaPorUsuarioServicioRemoto;


@Stateless
public class PreguntaPorUsuarioServicioImpl implements PreguntaPorUsuarioServicioLocal, PreguntaPorUsuarioServicioRemoto {

	 public PreguntaPorUsuarioServicioImpl() {

	    }

	    @EJB
	    private static PreguntaPorUsuarioDao preguntaPorUsuarioDao;

		@Override
		public List<PreguntaPorUsuario> getAll() {
			return preguntaPorUsuarioDao.findAll();
		}

		@Override
		public void crearPreguntaPorUsuario(PreguntaPorUsuario preguntaPorUsuario) {
		   preguntaPorUsuarioDao.insert(preguntaPorUsuario);
			
		}

		@Override
		public void actualizarPreguntaPorUsuario(
				PreguntaPorUsuario preguntaPorUsuario) {
			preguntaPorUsuarioDao.update(preguntaPorUsuario);
			
		}    
	 
}
