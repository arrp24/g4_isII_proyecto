package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.UsuarioDao;
import com.ls.gestion.entity.OpcionMenuPorRol;
import com.ls.gestion.entity.Usuario;
import com.ls.gestion.service.UsuarioServicioLocal;
import com.ls.gestion.service.UsuarioServicioRemoto;

@Stateless
public class UsuarioServicioImpl implements UsuarioServicioRemoto,
        UsuarioServicioLocal {

    public UsuarioServicioImpl()
    {

    }

    /**
     * UsuarioDao.
     */
    @EJB
    private static UsuarioDao usuarioDao;

    @Override
    public Usuario buscarUsuarioPorCedula(String cedula) {
        return usuarioDao.buscarUsuarioPorCedula(cedula);
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        usuarioDao.insert(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuarioDao.update(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDao.delete(usuarioDao.findByPk(usuario.getId()));

    }

    @Override
    public List<OpcionMenuPorRol> obtenerUsuarioRol(String nombre, String clave) {
        return usuarioDao.obtenerUsuarioRol(nombre, clave);
    }

    @Override
    public List<Usuario> getAll() {
        return usuarioDao.findAll();
    }
}
