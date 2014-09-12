package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.PedidoRetiroDao;
import com.ls.gestion.entity.PedidoRetiro;

@Stateless
public class PedidoRetiroDaoImpl extends GenericDaoImpl <PedidoRetiro, Integer> implements PedidoRetiroDao {

	
	/* Constructor
     */
    public PedidoRetiroDaoImpl() {
        super(PedidoRetiro.class);
    }
}
