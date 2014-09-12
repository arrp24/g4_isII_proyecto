package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.HistorialMantenimientoDao;
import com.ls.gestion.entity.HistorialMantenimiento;
import com.ls.gestion.service.HistorialMantenimientoServicioRemoto;
import com.ls.gestion.service.HistorialMantenimientoServicioLocal;

@Stateless

public class HistorialMantenimientoServicioImpl implements HistorialMantenimientoServicioRemoto, HistorialMantenimientoServicioLocal{

	 public HistorialMantenimientoServicioImpl() {

	    }

	    /**
	     * HistorialMantenimientoDao.
	     */
	    @EJB
	    private static HistorialMantenimientoDao HistorialMantenimientoDao;

		@Override
		public void actualizarHistorialMantenimiento(HistorialMantenimiento HistorialMantenimiento) {
			HistorialMantenimientoDao.update(HistorialMantenimiento);
			
		}

		@Override
		public void eliminarHistorialMantenimiento(Integer codigoHistorialMantenimiento) {
			HistorialMantenimientoDao.delete(buscarHistorialMantenimientoPorCodigo(codigoHistorialMantenimiento));
			
		}

		@Override
		public HistorialMantenimiento buscarHistorialMantenimientoPorCodigo(Integer codigo) {
			
			return HistorialMantenimientoDao.findByPk(codigo);
		}

		@Override
		public List<HistorialMantenimiento> getAll() {
	
			return HistorialMantenimientoDao.findAll();
		}

		@Override
		public void crearHistorialMantenimiento(HistorialMantenimiento HistorialMantenimiento) {
			HistorialMantenimientoDao.insert(HistorialMantenimiento);
			
		}
 
}
