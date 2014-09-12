package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.Tecnico;


@Local
public interface TecnicoDao extends GenericDao<Tecnico, Integer> {

}
