package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.SeguroDao;
import com.ls.gestion.entity.Seguro;
import com.ls.gestion.service.SeguroServicioLocal;
import com.ls.gestion.service.SeguroServicioRemoto;

@Stateless
public class SeguroServicioImpl implements SeguroServicioRemoto, SeguroServicioLocal{

	 public SeguroServicioImpl() {

	    }

	    /**
	     * SeguroDao.
	     */
	    @EJB
	    private static SeguroDao seguroDao;

		@Override
		public List<Seguro> getAll() {
			
			return seguroDao.findAll();
		}

		@Override
		public void crearSeguro(Seguro seguro) {
			seguroDao.insert(seguro);
			
		}

		@Override
		public void actualizarSeguro(Seguro seguro) {
		seguroDao.update(seguro);
			
		}

		@Override
		public void eliminarSeguro(Integer codigoSeguro) {
			seguroDao.delete(buscarSeguroPorCodigo(codigoSeguro));
			
		}

		@Override
		public Seguro buscarSeguroPorCodigo(Integer codigo) {
			
			return seguroDao.findByPk(codigo);
		}

	    
}
