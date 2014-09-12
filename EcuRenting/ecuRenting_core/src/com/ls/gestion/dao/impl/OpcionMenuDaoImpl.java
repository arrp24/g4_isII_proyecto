package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.OpcionMenuDao;
import com.ls.gestion.entity.OpcionMenu;

@Stateless
public class OpcionMenuDaoImpl extends GenericDaoImpl<OpcionMenu, String> implements OpcionMenuDao {
    /**
     * Constructor
     */
    public OpcionMenuDaoImpl() {
        super(OpcionMenu.class);
    }
}
