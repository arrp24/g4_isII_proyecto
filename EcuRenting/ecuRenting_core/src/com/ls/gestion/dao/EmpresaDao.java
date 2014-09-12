package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.Empresa;


@Local
public interface EmpresaDao extends GenericDao<Empresa, Integer> {

}
