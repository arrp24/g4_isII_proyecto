package com.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.gestion.dao.TallerDao;
import com.gestion.entity.Taller;
import com.gestion.service.TallerServicioLocal;
import com.gestion.service.TallerServicioRemoto;

@Stateless
public class TallerServicioImpl implements TallerServicioRemoto, TallerServicioLocal{

	 public TallerServicioImpl() {

	    }

	    /**
	     * TallerDao.
	     */
	    @EJB
	    private static TallerDao TallerDao;

		@Override
		public List<Taller> getAll() {
			
			return TallerDao.findAll();
		}

		@Override
		public void crearTaller(Taller Taller) {
			TallerDao.insert(Taller);
			
		}

		@Override
		public void actualizarTaller(Taller Taller) {
		TallerDao.update(Taller);
			
		}

		@Override
		public void eliminarTaller(Integer codigoTaller) {
			TallerDao.delete(buscarTallerPorCodigo(codigoTaller));
			
		}

		@Override
		public Taller buscarTallerPorCodigo(Integer codigo) {
			
			return TallerDao.findByPk(codigo);
		}

	    
}
