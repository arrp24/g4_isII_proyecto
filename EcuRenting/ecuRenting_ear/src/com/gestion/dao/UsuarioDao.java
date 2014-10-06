package com.ls.gestion.dao;

import java.util.List;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.OpcionMenuPorRol;
import com.ls.gestion.entity.Usuario;

@Local
public interface UsuarioDao extends GenericDao<Usuario, Integer> {

}