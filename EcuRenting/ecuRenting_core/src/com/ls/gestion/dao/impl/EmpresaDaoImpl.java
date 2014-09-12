package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.EmpresaDao;
import com.ls.gestion.entity.Empresa;


@Stateless
public class EmpresaDaoImpl extends GenericDaoImpl<Empresa, Integer> implements EmpresaDao {

	
	 /* Constructor
     */
    public EmpresaDaoImpl() {
        super(Empresa.class);
    }
}

 