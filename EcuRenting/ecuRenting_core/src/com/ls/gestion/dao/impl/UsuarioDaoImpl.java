package com.ls.gestion.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.UsuarioDao;
import com.ls.gestion.entity.OpcionMenuPorRol;
import com.ls.gestion.entity.RolPorUsuario;
import com.ls.gestion.entity.Usuario;

@Stateless
public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Integer> implements UsuarioDao {
    /**
     * Constructor
     */
    public UsuarioDaoImpl() {
        super(Usuario.class);
    }

    /**
     * <b>
     * Método en el cual se optiene las opciones por menú
     * </b>
     * <p>
     * [Author: roberto, Date: Jun 14, 2013]
     * </p>
     * 
     * @param nombre
     * @param clave
     * @return
     */
    public List<OpcionMenuPorRol> obtenerUsuarioRol(String nombre, String clave) {
        List<OpcionMenuPorRol> listaOpcionMenuPorRol = new ArrayList<OpcionMenuPorRol>();
        try {
            List<RolPorUsuario> rolPorUsuarioLista = new ArrayList<RolPorUsuario>();
            Query q = em.createNamedQuery("RolPorUsuario.getByClave", RolPorUsuario.class);
            q.setParameter("ruClave", clave);
            q.setParameter("ruNombre", nombre);
            rolPorUsuarioLista = (List<RolPorUsuario>) q.getResultList();

            if (listaOpcionMenuPorRol != null && rolPorUsuarioLista.size() > 0) {
                listaOpcionMenuPorRol = rolPorUsuarioLista.get(0).getRol().getOpcionMenuPorRol();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaOpcionMenuPorRol;
    }

    @Override
    public Usuario buscarUsuarioPorCedula(String cedula) {
        Usuario usuarioEncontrado = null;
        try {
            Query q = em.createNamedQuery("Usuario.getByCedula", Usuario.class);
            q.setParameter("usCedula", cedula);
            usuarioEncontrado = (Usuario) q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarioEncontrado;
    }
}
