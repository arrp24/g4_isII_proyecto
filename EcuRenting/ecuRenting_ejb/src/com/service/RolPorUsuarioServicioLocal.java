package com.ls.gestion.service;

import javax.ejb.Local;

import com.ls.gestion.entity.RolPorUsuario;

@Local
public interface RolPorUsuarioServicioLocal {

    /**
     * <b> Devuelve un usuario que coincida con la cedula y clave indicadas. </b>
     * <p>
     * [Author: joselo, Date: Jun 10, 2013]
     * </p>
     * 
     * @return List<Usuario>
     */
    RolPorUsuario buscarUsuarioPorCedulaYClave(String cedula, String clave);

    /**
     * <b>Elimina todos los roles de un usuario. </b>
     * <p>
     * [Author: joselo, Date: 15/07/2013]
     * </p>
     * 
     * @param usuId
     *            Iddel Usuario
     */
    void eliminarPorUsuarioId(Integer usuId);

    /**
     * <b> Actualiza la info del rol por usuario. </b>
     * <p>
     * [Author: joselo, Date: 15/07/2013]
     * </p>
     * 
     * @param rolPorUsuario
     *            Entidad a ser actualizada
     */
    void actualizarRolPorUsuario(RolPorUsuario rolPorUsuario);

}
