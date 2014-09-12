package com.ls.gestion.dao;

import java.util.List;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.OpcionMenuPorRol;
import com.ls.gestion.entity.pk.OpcionMenuPorRolPK;

@Local
public interface OpcionMenuPorRolDao extends GenericDao<OpcionMenuPorRol, OpcionMenuPorRolPK> {
    /**
     * <b> Devuelve una lista de OpcionMenuPorRol de acuerdo a un rol especifico. </b>
     * <p>
     * [Author: joselo, Date: 25/06/2013]
     * </p>
     * 
     * @param rolId
     *            Rol que sera buscado
     * @return List<OpcionMenuPorRol>
     */
    public List<OpcionMenuPorRol> getOpcionesMenuPorRol(String rolId);

    /**
     * <b> Elimina las opciones asignadas a unrol. </b>
     * <p>
     * [Author: joselo, Date: 05/07/2013]
     * </p>
     * 
     * @param idRol
     */
    public void eliminarPorIdRol(String idRol);
}
