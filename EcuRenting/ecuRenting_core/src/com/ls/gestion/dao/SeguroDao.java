package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.Seguro;

@Local
public interface SeguroDao extends GenericDao<Seguro, Integer>{

}