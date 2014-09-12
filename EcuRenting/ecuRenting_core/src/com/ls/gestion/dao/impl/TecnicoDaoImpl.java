package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.TecnicoDao;
import com.ls.gestion.entity.Tecnico;


@Stateless
public class TecnicoDaoImpl extends GenericDaoImpl<Tecnico, Integer> implements TecnicoDao {

	
	 /* Constructor
     */
    public TecnicoDaoImpl() {
        super(Tecnico.class);
    }
}

 
