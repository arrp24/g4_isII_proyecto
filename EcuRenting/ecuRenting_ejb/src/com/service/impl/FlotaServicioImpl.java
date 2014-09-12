package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.FlotaDao;
import com.ls.gestion.entity.Flota;
import com.ls.gestion.service.FlotaServicioLocal;
import com.ls.gestion.service.FlotaServicioRemoto;

@Stateless
public class FlotaServicioImpl implements FlotaServicioRemoto, FlotaServicioLocal{

	public FlotaServicioImpl() {

    }

    /**
     * FlotaDao.
     */
    @EJB
    private static FlotaDao flotaDao;
	
	
	@Override
	public List<Flota> getAll() {
		
		return flotaDao.findAll();
	}

	@Override
	public void crearFlota(Flota flota) {
		flotaDao.insert(flota);
		
	}

	@Override
	public void actualizarFlota(Flota flota) {
		flotaDao.update(flota);
		
	}

	@Override
	public void eliminarFlota(Integer codigoFlota) {
		flotaDao.delete(buscarFlotaPorCodigo(codigoFlota));
		
	}

	@Override
	public Flota buscarFlotaPorCodigo(Integer codigo) {
		
		return flotaDao.findByPk(codigo);
	}

}
