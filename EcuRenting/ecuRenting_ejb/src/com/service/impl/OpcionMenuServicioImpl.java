package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.OpcionMenuDao;
import com.ls.gestion.entity.OpcionMenu;
import com.ls.gestion.service.OpcionMenuServicioLocal;
import com.ls.gestion.service.OpcionMenuServicioRemoto;

@Stateless
public class OpcionMenuServicioImpl implements OpcionMenuServicioRemoto,
        OpcionMenuServicioLocal {

    public OpcionMenuServicioImpl() {

    }

    /**
     * OpcionMenuDao.
     */
    @EJB
    private static OpcionMenuDao opcionMenuDao;

    @Override
    public List<OpcionMenu> buscarOpcionMenu() {
        return opcionMenuDao.findAll();
    }

    @Override
    public void crearOpcionMenu(OpcionMenu opcionMenu) {
        opcionMenuDao.insert(opcionMenu);
    }

    @Override
    public void actualizarOpcionMenu(OpcionMenu opcionMenu) {
        opcionMenuDao.update(opcionMenu);
    }

    @Override
    public OpcionMenu buscarPorId(String id) {
        return opcionMenuDao.findByPk(id);
    }

}
