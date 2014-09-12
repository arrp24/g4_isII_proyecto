package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.RolPorUsuario;
import com.ls.gestion.entity.pk.RolPorUsuarioPK;

@Local
public interface RolPorUsuarioDao extends GenericDao<RolPorUsuario, RolPorUsuarioPK> {
    /**
     * <b> Devuelve un RolPorUsuario buscado por cedula y clave. </b>
     * <p>
     * [Author: joselo, Date: 25/06/2013]
     * </p>
     * 
     * @param cedula
     *            Cedula a Buscar
     * @param clave
     *            Clave a buscar
     * @return RolPorUsuario
     */
    public RolPorUsuario buscarUsuarioPorCedulaYClave(String cedula, String clave);

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
}