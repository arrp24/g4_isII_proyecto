package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.RolDao;
import com.ls.gestion.entity.Rol;
import com.ls.gestion.service.RolServicioLocal;
import com.ls.gestion.service.RolServicioRemoto;

@Stateless
public class RolServicioImpl implements RolServicioRemoto, RolServicioLocal {

    public RolServicioImpl() {

    }

    /**
     * RolDao.
     */
    @EJB
    private static RolDao rolDao;

    @Override
    public List<Rol> getAll() {
        return rolDao.findAll();
    }

    @Override
    public void crearRol(Rol rol) {
        rolDao.insert(rol);
    }

    @Override
    public void actualizarRol(Rol rol) {
        rolDao.update(rol);
    }

    @Override
    public Rol buscarRolPorCodigo(String codigo) {
        return rolDao.findByPk(codigo);
    }

    @Override
    public void eliminarRol(String codigoRol) {
        rolDao.delete(buscarRolPorCodigo(codigoRol));
    }

}
