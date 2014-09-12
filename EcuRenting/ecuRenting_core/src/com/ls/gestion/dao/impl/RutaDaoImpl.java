package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.RutaDao;
import com.ls.gestion.entity.Ruta;


@Stateless
public class RutaDaoImpl extends GenericDaoImpl<Ruta, Integer> implements RutaDao {

	
	 /* Constructor
    */
   public RutaDaoImpl() {
       super(Ruta.class);
   }

}
