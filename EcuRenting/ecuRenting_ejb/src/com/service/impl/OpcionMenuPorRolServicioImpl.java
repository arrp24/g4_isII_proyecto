package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.OpcionMenuPorRolDao;
import com.ls.gestion.entity.OpcionMenuPorRol;
import com.ls.gestion.service.OpcionMenuPorRolServicioLocal;
import com.ls.gestion.service.OpcionMenuPorRolServicioRemoto;

@Stateless
public class OpcionMenuPorRolServicioImpl implements OpcionMenuPorRolServicioRemoto, OpcionMenuPorRolServicioLocal {

    public OpcionMenuPorRolServicioImpl() {

    }

    /**
     * OpcionMenuDao.
     */
    @EJB
    private static OpcionMenuPorRolDao opcionMenuPorRolDao;

    @Override
    public List<OpcionMenuPorRol> getOpcionesMenuPorRol(String rolId) {
        return opcionMenuPorRolDao.getOpcionesMenuPorRol(rolId);
    }

    @Override
    public void eliminarPorIdRol(String idRol) {
        opcionMenuPorRolDao.eliminarPorIdRol(idRol);
    }

}
