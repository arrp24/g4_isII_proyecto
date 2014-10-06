package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.Vehiculo;

@Local
public interface VehiculoDao extends GenericDao<Vehiculo, Integer> {

}
