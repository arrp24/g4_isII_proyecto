package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.Cliente;

@Local
public interface ClienteDao extends GenericDao<Cliente, Integer>{

}
