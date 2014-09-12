package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.MantenimientoDao;
import com.ls.gestion.entity.Mantenimiento;


@Stateless
public class MantenimientoDaoImpl extends GenericDaoImpl<Mantenimiento, Integer> implements MantenimientoDao {

	
	 /* Constructor
    */
   public MantenimientoDaoImpl() {
       super(Mantenimiento.class);
   }
}
