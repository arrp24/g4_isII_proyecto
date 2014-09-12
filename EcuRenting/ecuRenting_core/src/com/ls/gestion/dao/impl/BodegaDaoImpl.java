package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;
import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.BodegaDao;
import com.ls.gestion.entity.Bodega;

@Stateless

public class BodegaDaoImpl extends GenericDaoImpl<Bodega, Integer> implements BodegaDao  {

	public BodegaDaoImpl() {
        super(Bodega.class);
    }
}

