package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Local;

import com.ls.gestion.entity.OpcionMenuPorRol;

@Local
public interface OpcionMenuPorRolServicioLocal {
    /**
     * <b> Devuelve una lista de OpcionesMenuPorRol. </b>
     * <p>
     * [Author: joselo, Date: 25/06/2013]
     * </p>
     * 
     * @param rolId
     *            Rol a ser buscado
     * @return List<OpcionMenuPorRol>
     */
    public List<OpcionMenuPorRol> getOpcionesMenuPorRol(String rolId);

    /**
     * <b> Elimina las opcion de menu por rol por id del Rol. </b>
     * <p>
     * [Author: joselo, Date: 05/07/2013]
     * </p>
     * 
     * @param id
     *            de la opcio
     */
    public void eliminarPorIdRol(String idRol);

}
