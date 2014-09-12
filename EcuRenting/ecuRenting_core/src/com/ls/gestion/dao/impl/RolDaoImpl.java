package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.RolDao;
import com.ls.gestion.entity.Rol;

@Stateless
public class RolDaoImpl extends GenericDaoImpl<Rol, String> implements RolDao {
    /**
     * Constructor
     */
    public RolDaoImpl() {
        super(Rol.class);
    }
}
