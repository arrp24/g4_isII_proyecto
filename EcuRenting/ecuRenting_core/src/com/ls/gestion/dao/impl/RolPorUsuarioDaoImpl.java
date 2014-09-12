package com.ls.gestion.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.RolPorUsuarioDao;
import com.ls.gestion.entity.RolPorUsuario;
import com.ls.gestion.entity.pk.RolPorUsuarioPK;

@Stateless
public class RolPorUsuarioDaoImpl extends GenericDaoImpl<RolPorUsuario, RolPorUsuarioPK> implements RolPorUsuarioDao {
    /**
     * Constructor
     */
    public RolPorUsuarioDaoImpl() {
        super(RolPorUsuario.class);
    }

    @Override
    public RolPorUsuario buscarUsuarioPorCedulaYClave(String cedula, String clave) {
        // TODO: Verificar que el usuario este activo
        RolPorUsuario rolPorUsuarioEncontrado = null;
        try {
            Query q = em.createNamedQuery("RolPorUsuario.getByCedulaAndClave", RolPorUsuario.class);
            q.setParameter("roCedula", cedula);
            q.setParameter("roClave", clave);
            List<RolPorUsuario> temp = (List<RolPorUsuario>) q.getResultList();
            if (!temp.isEmpty())
                rolPorUsuarioEncontrado = temp.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rolPorUsuarioEncontrado;
    }

    @Override
    public void eliminarPorUsuarioId(Integer usuId) {
        try {
            // Query q = em.createNamedQuery("OpcionMenuPorRol.deleteOpcionMenuByRol", OpcionMenuPorRol.class);
            // Por algun motivo no me dejaba aplicar el query desde el archivo de querys asi que toco crearlo
            // directamente
            // TODO: Mandar el query al archivo de querys en META-INF/jpql/querys.xml y que funcione
            Query q = em
                    .createQuery("DELETE FROM RolPorUsuario rolPorUsuario WHERE rolPorUsuario.id.usuarioId = :usuId");
            q.setParameter("usuId", usuId);
            q.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
