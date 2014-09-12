package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.SeguroDao;
import com.ls.gestion.entity.Seguro;


@Stateless
public class SeguroDaoImpl extends GenericDaoImpl<Seguro, Integer> implements SeguroDao {

	
	 /* Constructor
    */
   public SeguroDaoImpl() {
       super(Seguro.class);
   } 

}
