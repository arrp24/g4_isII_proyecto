package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.Inventario;

@Local
public interface InventarioDao extends GenericDao<Inventario, Integer>{

}

