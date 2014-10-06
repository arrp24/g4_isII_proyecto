package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.TipoContrato;


@Local
public interface TipoContratoDao extends GenericDao<TipoContrato, Integer> {

}
