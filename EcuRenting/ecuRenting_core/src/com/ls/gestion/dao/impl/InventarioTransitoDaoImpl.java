package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;
import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.InventarioTransitoDao;
import com.ls.gestion.entity.InventarioTransito;

@Stateless

public class InventarioTransitoDaoImpl extends GenericDaoImpl<InventarioTransito, Integer> implements InventarioTransitoDao  {

	public InventarioTransitoDaoImpl() {
        super(InventarioTransito.class);
    }
}
