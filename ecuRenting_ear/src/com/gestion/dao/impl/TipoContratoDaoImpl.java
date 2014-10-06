package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.TipoContratoDao;
import com.ls.gestion.entity.TipoContrato;


@Stateless
public class TipoContratoDaoImpl extends GenericDaoImpl<TipoContrato, Integer> implements TipoContratoDao {

    public TipoContratoDaoImpl() {
        super(TipoContrato.class);
    }
}

 