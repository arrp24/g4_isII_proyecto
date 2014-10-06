package com.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.gestion.dao.vehiculoDao;
import com.gestion.entity.Vehiculo;
import com.gestion.service.VehiculoServicioLocal;
import com.gestion.service.VehiculoServicioRemoto;



@Stateless
public class VehiculoServicioImpl implements VehiculoServicioRemoto, VehiculoServicioLocal{

	 @EJB
	   private static vehiculoDao vehiculoDao;
	    
	
	@Override
	public List<Vehiculo> getAll() {
		return vehiculoDao.findAll();
	}

	@Override
	public void crearVehiculo(Vehiculo vehiculo) {
		vehiculoDao.insert(vehiculo);
		
	}

	@Override
	public void actualizarVehiculo(Vehiculo vehiculo) {
		vehiculoDao.update(vehiculo);
		
	}

	@Override
	public void eliminarVehiculo(Integer codigoVehiculo) {
		vehiculoDao.delete(buscarVehiculoPorCodigo(codigoVehiculo));		
		
	}

	@Override
	public Vehiculo buscarVehiculoPorCodigo(Integer codigo) {
		return vehiculoDao.findByPk(codigo);
	}

}
