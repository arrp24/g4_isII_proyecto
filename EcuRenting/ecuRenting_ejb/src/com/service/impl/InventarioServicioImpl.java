package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.InventarioDao;
import com.ls.gestion.entity.Inventario;
import com.ls.gestion.service.InventarioServicioLocal;
import com.ls.gestion.service.InventarioServicioRemoto;



@Stateless
public class InventarioServicioImpl implements InventarioServicioRemoto, InventarioServicioLocal{

	 @EJB
	   private static InventarioDao inventarioDao;
	    
	
	@Override
	public List<Inventario> getAll() {
		return inventarioDao.findAll();
	}

	@Override
	public void crearInventario(Inventario inventario) {
		inventarioDao.insert(inventario);
		
	}

	@Override
	public void actualizarInventario(Inventario inventario) {
		inventarioDao.update(inventario);
		
	}

	@Override
	public void eliminarInventario(Integer codigoInventario) {
		inventarioDao.delete(buscarInventarioPorCodigo(codigoInventario));		
		
	}

	@Override
	public Inventario buscarInventarioPorCodigo(Integer codigo) {
		return inventarioDao.findByPk(codigo);
	}

}
