package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.OpcionMenu;

@Local
public interface OpcionMenuDao extends GenericDao<OpcionMenu, String> {
}
