package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.FlotaRenting;

@Local
public interface FlotaRentingDao  extends GenericDao<FlotaRenting, Integer> {

}
