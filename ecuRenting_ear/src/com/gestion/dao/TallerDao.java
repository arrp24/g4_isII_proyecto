package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.Taller;

@Local
public interface TallerDao extends GenericDao<Taller, Integer>{

}
