package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.RutaDao;
import com.ls.gestion.entity.Ruta;
import com.ls.gestion.service.RutaServicioLocal;
import com.ls.gestion.service.RutaServicioRemoto;


@Stateless
public class RutaServicioImpl implements RutaServicioRemoto, RutaServicioLocal{

	 public RutaServicioImpl() {

	    }

	    /**
	     * RutaDao.
	     */
	    @EJB
	    private static RutaDao rutaDao;

		@Override
		public List<Ruta> getAll() {
			
			return rutaDao.findAll();
		}

		@Override
		public void crearRuta(Ruta ruta) {
			rutaDao.insert(ruta);
			
		}

		@Override
		public void actualizarRuta(Ruta ruta) {
			rutaDao.update(ruta);
			
		}

		@Override
		public void eliminarRuta(Integer codigoRuta) {
			rutaDao.delete(buscarRutaPorCodigo(codigoRuta));
			
		}

		@Override
		public Ruta buscarRutaPorCodigo(Integer codigo) {
			
			return rutaDao.findByPk(codigo);
		}

}
