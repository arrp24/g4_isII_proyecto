package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.FlotaRentingDao;
import com.ls.gestion.entity.FlotaRenting;

@Stateless
public class FlotaRentingDaoImpl extends GenericDaoImpl <FlotaRenting, Integer> implements FlotaRentingDao {

	
	/* Constructor
     */
    public FlotaRentingDaoImpl() {
        super(FlotaRenting.class);
    }
}
