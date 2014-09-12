package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.Pregunta;


@Local
public interface PreguntaDao extends GenericDao<Pregunta, Integer> {

}
