package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.InventarioTransitoDao;
import com.ls.gestion.entity.InventarioTransito;
import com.ls.gestion.service.InventarioTransitoServicioLocal;
import com.ls.gestion.service.InventarioTransitoServicioRemoto;



@Stateless
public class InventarioTransitoServicioImpl implements InventarioTransitoServicioRemoto, InventarioTransitoServicioLocal{

	 @EJB
	   private static InventarioTransitoDao inventarioTransitoDao;
	    
	
	@Override
	public List<InventarioTransito> getAll() {
		return inventarioTransitoDao.findAll();
	}

	@Override
	public void crearInventarioTransito(InventarioTransito inventarioTransito) {
		inventarioTransitoDao.insert(inventarioTransito);
		
	}

	@Override
	public void actualizarInventarioTransito(InventarioTransito inventarioTransito) {
		inventarioTransitoDao.update(inventarioTransito);
		
	}

	@Override
	public void eliminarInventarioTransito(Integer codigoInventarioTransito) {
		inventarioTransitoDao.delete(buscarInventarioTransitoPorCodigo(codigoInventarioTransito));		
		
	}

	@Override
	public InventarioTransito buscarInventarioTransitoPorCodigo(Integer codigo) {
		return inventarioTransitoDao.findByPk(codigo);
	}

}
