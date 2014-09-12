package com.ls.gestion.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.OpcionMenuPorRolDao;
import com.ls.gestion.entity.OpcionMenuPorRol;
import com.ls.gestion.entity.pk.OpcionMenuPorRolPK;

@Stateless
public class OpcionMenuPorRolDaoImpl extends GenericDaoImpl<OpcionMenuPorRol, OpcionMenuPorRolPK> implements
        OpcionMenuPorRolDao {
    /**
     * Constructor
     */
    public OpcionMenuPorRolDaoImpl() {
        super(OpcionMenuPorRol.class);
    }

    @Override
    public List<OpcionMenuPorRol> getOpcionesMenuPorRol(String rolId) {
        List<OpcionMenuPorRol> opcionesMenuPorRol = null;
        try {
            Query q = em.createNamedQuery("OpcionMenuPorRol.getOpcionMenuPorRol", OpcionMenuPorRol.class);
            q.setParameter("usRol", rolId);
            opcionesMenuPorRol = (List<OpcionMenuPorRol>) q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return opcionesMenuPorRol;
    }

    @Override
    public void eliminarPorIdRol(String idRol) {
        try {
            // Query q = em.createNamedQuery("OpcionMenuPorRol.deleteOpcionMenuByRol", OpcionMenuPorRol.class);
            // Por algun motivo no me dejaba aplicar el query desde el archivo de querys asi que toco crearlo
            // directamente
            // TODO: Mandar el query al archivo de querys en META-INF/jpql/querys.xml y que funcione
            Query q = em
                    .createQuery("DELETE FROM OpcionMenuPorRol opcionMenuPorRol WHERE opcionMenuPorRol.id.rolId = :usRol");
            q.setParameter("usRol", idRol);
            q.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
