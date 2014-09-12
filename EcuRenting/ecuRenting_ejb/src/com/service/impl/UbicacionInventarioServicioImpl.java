package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.UbicacionInventarioDao;
import com.ls.gestion.entity.UbicacionInventario;
import com.ls.gestion.service.UbicacionInventarioServicioLocal;
import com.ls.gestion.service.UbicacionInventarioServicioRemoto;



@Stateless
public class UbicacionInventarioServicioImpl implements UbicacionInventarioServicioRemoto, UbicacionInventarioServicioLocal{

	 @EJB
	   private static UbicacionInventarioDao ubicacionInventarioDao;
	    
	
	@Override
	public List<UbicacionInventario> getAll() {
		return ubicacionInventarioDao.findAll();
	}

	@Override
	public void crearInventario(UbicacionInventario inventario) {
		ubicacionInventarioDao.insert(inventario);
		
	}

	@Override
	public void actualizarInventario(UbicacionInventario inventario) {
		ubicacionInventarioDao.update(inventario);
		
	}

	@Override
	public void eliminarInventario(Integer codigoInventario) {
		ubicacionInventarioDao.delete(buscarInventarioPorCodigo(codigoInventario));		
		
	}

	@Override
	public UbicacionInventario buscarInventarioPorCodigo(Integer codigo) {
		return ubicacionInventarioDao.findByPk(codigo);
	}

}
