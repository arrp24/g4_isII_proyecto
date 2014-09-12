package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.PreguntaDao;
import com.ls.gestion.entity.Pregunta;
import com.ls.gestion.service.PreguntaServicioLocal;
import com.ls.gestion.service.PreguntaServicioRemoto;


@Stateless
public class PreguntaServicioImpl implements PreguntaServicioRemoto, PreguntaServicioLocal{

	
	 public PreguntaServicioImpl() {

	    }

	    /**
	     * PreguntaDao.
	     */
	    @EJB
	    private static PreguntaDao preguntaDao;

		@Override
		public void actualizarPregunta(Pregunta pregunta) {
			preguntaDao.update(pregunta);
			
		}

		@Override
		public List<Pregunta> getAll() {
			// TODO Auto-generated method stub
			return preguntaDao.findAll();
		}

		@Override
		public void crearPregunta(Pregunta pregunta) {
			preguntaDao.insert(pregunta);
			
		}

		@Override
		public void eliminarPregunta(Integer codigoPregunta) {
			preguntaDao.delete(buscarPreguntaPorCodigo(codigoPregunta));
			
			
		}

		@Override
		public Pregunta buscarPreguntaPorCodigo(Integer codigo) {
			// TODO Auto-generated method stub
			return preguntaDao.findByPk(codigo);
		}
		
	
		
}


