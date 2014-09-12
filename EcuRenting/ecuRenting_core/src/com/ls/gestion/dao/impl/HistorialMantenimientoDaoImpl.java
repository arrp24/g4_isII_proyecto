package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.HistorialMantenimientoDao;
import com.ls.gestion.entity.HistorialMantenimiento;


@Stateless
public class HistorialMantenimientoDaoImpl extends GenericDaoImpl<HistorialMantenimiento, Integer> implements HistorialMantenimientoDao {

	
	 /* Constructor
     */
    public HistorialMantenimientoDaoImpl() {
        super(HistorialMantenimiento.class);
    }
}
