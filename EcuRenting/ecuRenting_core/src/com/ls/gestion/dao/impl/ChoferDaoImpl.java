package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;
import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.ChoferDao;
import com.ls.gestion.entity.Chofer;

@Stateless

public class ChoferDaoImpl extends GenericDaoImpl<Chofer, Integer> implements ChoferDao  {

	public ChoferDaoImpl() {
        super(Chofer.class);
    }
}
