package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.Ruta;

@Local
public interface RutaDao extends GenericDao<Ruta, Integer> {

}
