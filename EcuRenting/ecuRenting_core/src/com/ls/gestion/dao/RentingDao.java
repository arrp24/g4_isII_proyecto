package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.Renting;

@Local

public interface RentingDao  extends GenericDao<Renting, Integer> {

}
