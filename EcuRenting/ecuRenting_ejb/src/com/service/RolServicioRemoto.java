package com.ls.gestion.service;

import java.util.List;
import javax.ejb.Remote;
import com.ls.gestion.entity.Rol;

@Remote
public interface RolServicioRemoto {
    /**
     * <b>
     * Se recupera el listado total de los roles
     * </b>
     * <p>
     * [Author: roberto, Date: Jun 10, 2013]
     * </p>
     * 
     * @return List<Rol>
     */
    List<Rol> getAll();

    /**
     * <b>
     * Se crea un nuevo Rol
     * </b>
     * <p>
     * [Author: roberto, Date: Jun 10, 2013]
     * </p>
     * 
     * @param rol
     * @return
     */
    void crearRol(Rol rol);

    /**
     * Se actualiza un rol
     * <b>
     * Incluir aquiÂ­ la descripcion del metodo.
     * </b>
     * <p>
     * [Author: roberto, Date: Jun 10, 2013]
     * </p>
     * 
     * @param rol
     * @return
     */
    void actualizarRol(Rol rol);

    /**
     * <b>
     * Elimina el rol pasado por parámetro.
     * </b>
     * <p>
     * [Author: joselo, Date: 28/06/2013]
     * </p>
     * 
     * @param codigoRol
     *            Codigo del Rol a ser borrado
     */
    void eliminarRol(String codigoRol);

    /**
     * <b>
     * Devuelve un rol busacado por código.
     * </b>
     * <p>
     * [Author: joselo, Date: 28/06/2013]
     * </p>
     * 
     * @param codigo
     *            Código a buscar.
     * @return Rol
     */
    Rol buscarRolPorCodigo(String codigo);
}
