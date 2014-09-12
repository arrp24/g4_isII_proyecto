package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.PedidoEntregaDao;
import com.ls.gestion.entity.PedidoEntrega;
import com.ls.gestion.service.PedidoEntregaServicioLocal;
import com.ls.gestion.service.PedidoEntregaServicioRemoto;

@Stateless
public class PedidoEntregaServicioImpl implements PedidoEntregaServicioRemoto, PedidoEntregaServicioLocal{

	public PedidoEntregaServicioImpl() {

    }

    /**
     * PedidoEntregaDao.
     */
    @EJB
    private static PedidoEntregaDao flotaDao;
	
	
	@Override
	public List<PedidoEntrega> getAll() {
		
		return flotaDao.findAll();
	}

	@Override
	public void crearPedidoEntrega(PedidoEntrega flota) {
		flotaDao.insert(flota);
		
	}

	@Override
	public void actualizarPedidoEntrega(PedidoEntrega flota) {
		flotaDao.update(flota);
		
	}

	@Override
	public void eliminarPedidoEntrega(Integer codigoPedidoEntrega) {
		flotaDao.delete(buscarPedidoEntregaPorCodigo(codigoPedidoEntrega));
		
	}

	@Override
	public PedidoEntrega buscarPedidoEntregaPorCodigo(Integer codigo) {
		
		return flotaDao.findByPk(codigo);
	}

}
