package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.MantenimientoDao;
import com.ls.gestion.entity.Mantenimiento;
import com.ls.gestion.service.MantenimientoServicioLocal;
import com.ls.gestion.service.MantenimientoServicioRemoto;

@Stateless
public class MantenimientoServicioImpl implements MantenimientoServicioRemoto, MantenimientoServicioLocal{


	 @EJB
	    private static MantenimientoDao mantenimientoDao;
	    
	
	@Override
	public List<Mantenimiento> getAll() {
		return mantenimientoDao.findAll();
		
		
	}


	@Override
	public void actualizarMantenimiento(Mantenimiento mantenimiento) {
		mantenimientoDao.update(mantenimiento);
		
	}


	@Override
	public void crearMantenimiento(Mantenimiento mantenimiento) {
		mantenimientoDao.insert(mantenimiento);
		
	}


	@Override
	public void eliminarMantenimiento(Integer codigoMantenimiento) {
		mantenimientoDao.delete(buscarMantenimientoPorCodigo(codigoMantenimiento));		

		
	}


	@Override
	public Mantenimiento buscarMantenimientoPorCodigo(Integer codigo) {
		// TODO Auto-generated method stub
		return mantenimientoDao.findByPk(codigo);
	}


	
}
