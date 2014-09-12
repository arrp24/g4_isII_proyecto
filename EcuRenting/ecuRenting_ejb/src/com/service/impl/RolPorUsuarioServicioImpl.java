package com.ls.gestion.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.RolPorUsuarioDao;
import com.ls.gestion.entity.RolPorUsuario;
import com.ls.gestion.service.RolPorUsuarioServicioLocal;
import com.ls.gestion.service.RolPorUsuarioServicioRemoto;

@Stateless
public class RolPorUsuarioServicioImpl implements RolPorUsuarioServicioLocal, RolPorUsuarioServicioRemoto {

    public RolPorUsuarioServicioImpl() {

    }

    @EJB
    private static RolPorUsuarioDao rolPorUsuarioDao;

    @Override
    public RolPorUsuario buscarUsuarioPorCedulaYClave(String cedula, String clave) {
        return rolPorUsuarioDao.buscarUsuarioPorCedulaYClave(cedula, clave);
    }

    @Override
    public void eliminarPorUsuarioId(Integer usuId) {
        rolPorUsuarioDao.eliminarPorUsuarioId(usuId);
    }

    @Override
    public void actualizarRolPorUsuario(RolPorUsuario rolPorUsuario) {
        rolPorUsuarioDao.update(rolPorUsuario);
        
    }

}
