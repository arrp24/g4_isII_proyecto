package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.PreguntaPorUsuario;
import com.ls.gestion.entity.pk.PreguntaPorUsuarioPK;

@Local
public interface PreguntaPorUsuarioDao extends GenericDao<PreguntaPorUsuario, PreguntaPorUsuarioPK>{

	 void eliminarPorUsuarioId(Integer usuId);
}
