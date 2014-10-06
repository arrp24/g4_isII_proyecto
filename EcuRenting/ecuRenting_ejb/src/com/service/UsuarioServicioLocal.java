package com.service;

import java.util.List;
import javax.ejb.Local;

import com.gestion.entity.Usuario;

@Local
public interface UsuarioServicioLocal {
    /**
     * <b> Devuelve un usuario que coincida con la cedula. </b>
     * <p>
     * [Author: Planificación, Date: Oct 10, 2013]
     * </p>
     * 
     * @return List<Usuario>
     */
    Usuario buscarUsuarioPorCedula(String cedula);

    /**
     * <b> Se crea un nuevo Usuario </b>
     * <p>
     * [Author: Planificación, Date: Oct 10, 2013]
     * </p>
     * 
     * @param usuario
     * @return
     */
    void crearUsuario(Usuario usuario);

    /**
     * <b>Se actualiza un usuario</b>
     * <p>
     * [Author: Planificación, Date: Oct 10, 2013]
     * </p>
     * 
     * @param usuario
     * @return
     */
    void actualizarUsuario(Usuario usuario);

    /**
     * <b> Elimina el usuario indicado por parametro. </b>
     * <p>
     * [Author: Planificación, Date: Oct 04, 2014]
     * </p>
     * 
     * @param usuario Ususario a eliminar
     */
    void eliminarUsuario(Usuario usuario);

    /**
     * <b> MÃ©todo en el cual se optiene una lista de Usuarios </b>
     * <p>
     * [Author: Planificación, Date: Oct 04, 2014]
     * </p>
     * 
     * @param nombre
     * @param clave
     * @return
     */
    
    public List<Usuario> getAll();
}