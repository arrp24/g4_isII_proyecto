package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;
import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.TallerDao;
import com.ls.gestion.entity.Taller;

@Stateless

public class TallerDaoImpl extends GenericDaoImpl<Taller, Integer> implements TallerDao  {

	public TallerDaoImpl() {
        super(Taller.class);
    }
}

