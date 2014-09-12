package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.BodegaDao;
import com.ls.gestion.entity.Bodega;
import com.ls.gestion.service.BodegaServicioLocal;
import com.ls.gestion.service.BodegaServicioRemoto;



@Stateless
public class BodegaServicioImpl implements BodegaServicioRemoto, BodegaServicioLocal{

	 @EJB
	    private static BodegaDao choferDao;
	    
	
	@Override
	public List<Bodega> getAll() {
		return choferDao.findAll();
	}

	@Override
	public void crearBodega(Bodega chofer) {
		choferDao.insert(chofer);
		
	}

	@Override
	public void actualizarBodega(Bodega chofer) {
		choferDao.update(chofer);
		
	}

	@Override
	public void eliminarBodega(Integer codigoBodega) {
		choferDao.delete(buscarBodegaPorCodigo(codigoBodega));		
		
	}

	@Override
	public Bodega buscarBodegaPorCodigo(Integer codigo) {
		return choferDao.findByPk(codigo);
	}

}
