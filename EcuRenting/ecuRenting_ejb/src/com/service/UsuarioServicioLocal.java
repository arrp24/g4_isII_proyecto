package com.ls.gestion.service;

import java.util.List;
import javax.ejb.Local;

import com.ls.gestion.entity.OpcionMenuPorRol;
import com.ls.gestion.entity.Usuario;

@Local
public interface UsuarioServicioLocal {

    /**
     * <b> Devuelve un usuario que coincida con la cedula. </b>
     * <p>
     * [Author: joselo, Date: Jun 10, 2013]
     * </p>
     * 
     * @return List<Usuario>
     */
    Usuario buscarUsuarioPorCedula(String cedula);

    /**
     * <b> Se crea un nuevo Usuario </b>
     * <p>
     * [Author: roberto, Date: Jun 10, 2013]
     * </p>
     * 
     * @param usuario
     * @return
     */
    void crearUsuario(Usuario usuario);

    /**
     * Se actualiza un usuario <b> Incluir aqui­ la descripcion del metodo. </b>
     * <p>
     * [Author: roberto, Date: Jun 10, 2013]
     * </p>
     * 
     * @param usuario
     * @return
     */
    void actualizarUsuario(Usuario usuario);

    /**
     * <b> Elimina el usuario indicado por parametro. </b>
     * <p>
     * [Author: joselo, Date: 03/07/2013]
     * </p>
     * 
     * @param usuario
     *            Ususario a eliminar
     */
    void eliminarUsuario(Usuario usuario);

    /**
     * <b> Método en el cual se optiene las opciones por menú </b>
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
     * <b> Devuelve una lista con todos los usuarios disponibles en la BDD. </b>
     * <p>
     * [Author: joselo, Date: 27/06/2013]
     * </p>
     * 
     * @return List<Usuario>
     */
    public List<Usuario> getAll();

}
