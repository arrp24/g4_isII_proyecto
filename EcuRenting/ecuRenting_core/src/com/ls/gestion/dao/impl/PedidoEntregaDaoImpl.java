package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.PedidoEntregaDao;
import com.ls.gestion.entity.PedidoEntrega;

@Stateless
public class PedidoEntregaDaoImpl extends GenericDaoImpl <PedidoEntrega, Integer> implements PedidoEntregaDao {

	
	/* Constructor
     */
    public PedidoEntregaDaoImpl() {
        super(PedidoEntrega.class);
    }
}
