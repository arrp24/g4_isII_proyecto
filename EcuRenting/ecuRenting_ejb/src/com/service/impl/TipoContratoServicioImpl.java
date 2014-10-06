package com.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.gestion.dao.TipoContratoDao;
import com.gestion.entity.TipoContrato;
import com.gestion.service.TipoContratoServicioRemoto;
import com.gestion.service.TipoContratoServicioLocal;

@Stateless

public class TipoContratoServicioImpl implements TipoContratoServicioRemoto, TipoContratoServicioLocal{

	 public TipoContratoServicioImpl() {

	    }
	 
	    @EJB
	    private static TipoContratoDao TipoContratoDao;

		@Override
		public void actualizarTipoContrato(TipoContrato TipoContrato) {
			TipoContratoDao.update(TipoContrato);
			
		}

		@Override
		public void eliminarTipoContrato(Integer codigoTipoContrato) {
			TipoContratoDao.delete(buscarTipoContratoPorCodigo(codigoTipoContrato));
			
		}

		@Override
		public TipoContrato buscarTipoContratoPorCodigo(Integer codigo) {
			
			return TipoContratoDao.findByPk(codigo);
		}

		@Override
		public List<TipoContrato> getAll() {
	
			return TipoContratoDao.findAll();
		}

		@Override
		public void crearTipoContrato(TipoContrato TipoContrato) {
			TipoContratoDao.insert(TipoContrato);
			
		}
 
}

