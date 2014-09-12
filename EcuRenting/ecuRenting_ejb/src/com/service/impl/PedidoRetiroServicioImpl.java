package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.PedidoRetiroDao;
import com.ls.gestion.entity.PedidoRetiro;
import com.ls.gestion.service.PedidoRetiroServicioLocal;
import com.ls.gestion.service.PedidoRetiroServicioRemoto;

@Stateless
public class PedidoRetiroServicioImpl implements PedidoRetiroServicioRemoto, PedidoRetiroServicioLocal{

	public PedidoRetiroServicioImpl() {

    }

    /**
     * PedidoRetiroDao.
     */
    @EJB
    private static PedidoRetiroDao flotaDao;
	
	
	@Override
	public List<PedidoRetiro> getAll() {
		
		return flotaDao.findAll();
	}

	@Override
	public void crearPedidoRetiro(PedidoRetiro flota) {
		flotaDao.insert(flota);
		
	}

	@Override
	public void actualizarPedidoRetiro(PedidoRetiro flota) {
		flotaDao.update(flota);
		
	}

	@Override
	public void eliminarPedidoRetiro(Integer codigoPedidoRetiro) {
		flotaDao.delete(buscarPedidoRetiroPorCodigo(codigoPedidoRetiro));
		
	}

	@Override
	public PedidoRetiro buscarPedidoRetiroPorCodigo(Integer codigo) {
		
		return flotaDao.findByPk(codigo);
	}

}
