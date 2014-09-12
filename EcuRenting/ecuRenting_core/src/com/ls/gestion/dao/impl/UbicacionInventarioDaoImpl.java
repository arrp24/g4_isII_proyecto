package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;
import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.UbicacionInventarioDao;
import com.ls.gestion.entity.UbicacionInventario;

@Stateless

public class UbicacionInventarioDaoImpl extends GenericDaoImpl<UbicacionInventario, Integer> implements UbicacionInventarioDao  {

	public UbicacionInventarioDaoImpl() {
        super(UbicacionInventario.class);
    }
}
