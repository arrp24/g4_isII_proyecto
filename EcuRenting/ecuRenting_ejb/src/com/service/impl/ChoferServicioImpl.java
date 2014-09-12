package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.ChoferDao;
import com.ls.gestion.entity.Chofer;
import com.ls.gestion.service.ChoferServicioLocal;
import com.ls.gestion.service.ChoferServicioRemoto;



@Stateless
public class ChoferServicioImpl implements ChoferServicioRemoto, ChoferServicioLocal{

	 @EJB
	    private static ChoferDao choferDao;
	    
	
	@Override
	public List<Chofer> getAll() {
		return choferDao.findAll();
	}

	@Override
	public void crearChofer(Chofer chofer) {
		choferDao.insert(chofer);
		
	}

	@Override
	public void actualizarChofer(Chofer chofer) {
		choferDao.update(chofer);
		
	}

	@Override
	public void eliminarChofer(Integer codigoChofer) {
		choferDao.delete(buscarChoferPorCodigo(codigoChofer));		
		
	}

	@Override
	public Chofer buscarChoferPorCodigo(Integer codigo) {
		return choferDao.findByPk(codigo);
	}

}
