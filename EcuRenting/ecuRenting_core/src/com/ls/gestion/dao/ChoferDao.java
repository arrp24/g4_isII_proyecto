package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.Chofer;

@Local
public interface ChoferDao extends GenericDao<Chofer, Integer>{

}
