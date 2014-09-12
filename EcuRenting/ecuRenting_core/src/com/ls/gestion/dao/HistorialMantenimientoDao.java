package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.HistorialMantenimiento;


@Local
public interface HistorialMantenimientoDao extends GenericDao<HistorialMantenimiento, Integer> {

}
