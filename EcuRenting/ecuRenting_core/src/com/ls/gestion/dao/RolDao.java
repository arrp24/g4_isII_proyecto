package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.Rol;

@Local
public interface RolDao extends GenericDao<Rol, String> {

    

}