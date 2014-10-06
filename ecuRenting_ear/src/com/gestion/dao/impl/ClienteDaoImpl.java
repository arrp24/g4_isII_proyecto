package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;
import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.ClienteDao;
import com.ls.gestion.entity.Cliente;

@Stateless

public class ClienteDaoImpl extends GenericDaoImpl<Cliente, Integer> implements ClienteDao  {

	public ClienteDaoImpl() {
        super(Cliente.class);
    }
}
