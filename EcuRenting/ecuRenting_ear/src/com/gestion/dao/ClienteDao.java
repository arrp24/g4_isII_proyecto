package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.Bodega;

@Local
public interface BodegaDao extends GenericDao<Bodega, Integer>{

}
