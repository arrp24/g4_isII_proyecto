package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.UsuarioDao;
import com.ls.gestion.entity.Usuario;


@Stateless
public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Integer> implements UsuarioDao {
    
    public UsuarioDaoImpl() {
        super(Usuario.class);
    }
}
