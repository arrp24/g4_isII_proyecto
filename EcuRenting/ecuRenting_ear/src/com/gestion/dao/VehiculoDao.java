package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.Archivo;

@Local
public interface ArchivoDao extends GenericDao<Archivo, Integer> {

}