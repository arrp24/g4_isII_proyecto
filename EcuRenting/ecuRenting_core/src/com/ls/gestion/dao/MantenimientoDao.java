package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.Mantenimiento;

@Local
public interface MantenimientoDao extends GenericDao<Mantenimiento, Integer> {

}
