package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.FlotaDao;
import com.ls.gestion.entity.Flota;

@Stateless
public class FlotaDaoImpl extends GenericDaoImpl <Flota, Integer> implements FlotaDao {

	
	/* Constructor
     */
    public FlotaDaoImpl() {
        super(Flota.class);
    }
}


	
 