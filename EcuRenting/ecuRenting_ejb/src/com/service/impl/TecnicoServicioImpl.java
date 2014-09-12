package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.TecnicoDao;
import com.ls.gestion.entity.Tecnico;
import com.ls.gestion.service.TecnicoServicioRemoto;
import com.ls.gestion.service.TecnicoServicioLocal;

@Stateless

public class TecnicoServicioImpl implements TecnicoServicioRemoto, TecnicoServicioLocal{

	 public TecnicoServicioImpl() {

	    }

	    /**
	     * TecnicoDao.
	     */
	    @EJB
	    private static TecnicoDao tecnicoDao;

		@Override
		public void actualizarTecnico(Tecnico tecnico) {
			tecnicoDao.update(tecnico);
			
		}

		@Override
		public void eliminarTecnico(Integer codigoTecnico) {
			tecnicoDao.delete(buscarTecnicoPorCodigo(codigoTecnico));
			
		}

		@Override
		public Tecnico buscarTecnicoPorCodigo(Integer codigo) {
			
			return tecnicoDao.findByPk(codigo);
		}

		@Override
		public List<Tecnico> getAll() {
	
			return tecnicoDao.findAll();
		}

		@Override
		public void crearTecnico(Tecnico tecnico) {
			tecnicoDao.insert(tecnico);
			
		}
 
}

