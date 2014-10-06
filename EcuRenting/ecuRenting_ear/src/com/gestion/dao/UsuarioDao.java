package com.ls.gestion.dao;

import java.util.List;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.OpcionMenuPorRol;
import com.ls.gestion.entity.Usuario;

@Local
public interface UsuarioDao extends GenericDao<Usuario, Integer> {

    /**
     * <b>
     * Metodo en el cual se optiene las opciones por menú
     * </b>
     * <p>
     * [Author: roberto, Date: Jun 14, 2013]
     * </p>
     * 
     * @param nombre
     * @param clave
     * @return
     */
    public List<OpcionMenuPorRol> obtenerUsuarioRol(String nombre, String clave);

    /**
     * <b>
     * Devuelve un usuario buscado por cedula.
     * </b>
     * <p>
     * [Author: joselo, Date: 25/06/2013]
     * </p>
     * 
     * @param cedula Cedula a buscar
     * @return Usuario
     */
    public Usuario buscarUsuarioPorCedula(String cedula);

}