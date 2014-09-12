package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;
import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.InventarioDao;
import com.ls.gestion.entity.Inventario;

@Stateless

public class InventarioDaoImpl extends GenericDaoImpl<Inventario, Integer> implements InventarioDao  {

	public InventarioDaoImpl() {
        super(Inventario.class);
    }
}
