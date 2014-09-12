package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.RentingDao;
import com.ls.gestion.entity.Flota;
import com.ls.gestion.entity.Renting;

@Stateless
public class RentingDaoImpl extends GenericDaoImpl <Renting, Integer> implements RentingDao {

	/* Constructor
     */
    public RentingDaoImpl() {
        super(Renting.class);
    }
}
