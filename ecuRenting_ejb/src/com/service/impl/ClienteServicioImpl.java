package com.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.gestion.dao.ClienteDao;
import com.gestion.entity.Cliente;
import com.gestion.service.ClienteServicioLocal;
import com.gestion.service.ClienteServicioRemoto;



@Stateless
public class ClienteServicioImpl implements ClienteServicioRemoto, ClienteServicioLocal{

	 @EJB
	    private static ClienteDao ClienteDao;
	    
	
	@Override
	public List<Cliente> getAll() {
		return ClienteDao.findAll();
	}

	@Override
	public void crearCliente(Cliente Cliente) {
		ClienteDao.insert(Cliente);
		
	}

	@Override
	public void actualizarCliente(Cliente Cliente) {
		ClienteDao.update(Cliente);
		
	}

	@Override
	public void eliminarCliente(Integer codigoCliente) {
		ClienteDao.delete(buscarClientePorCodigo(codigoCliente));		
		
	}

	@Override
	public Cliente buscarClientePorCodigo(Integer codigo) {
		return ClienteDao.findByPk(codigo);
	}

}
