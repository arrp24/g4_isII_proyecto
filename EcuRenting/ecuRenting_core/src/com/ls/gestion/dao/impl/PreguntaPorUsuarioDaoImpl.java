package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.PreguntaPorUsuarioDao;
import com.ls.gestion.entity.PreguntaPorUsuario;
import com.ls.gestion.entity.pk.PreguntaPorUsuarioPK;

@Stateless
public class PreguntaPorUsuarioDaoImpl  extends GenericDaoImpl<PreguntaPorUsuario, PreguntaPorUsuarioPK> implements PreguntaPorUsuarioDao {
	
	public PreguntaPorUsuarioDaoImpl() {
	        super(PreguntaPorUsuario.class);
	    }


	    @Override
	    public void eliminarPorUsuarioId(Integer usuId) {
	        try {
	            // Query q = em.createNamedQuery("OpcionMenuPorRol.deleteOpcionMenuByRol", OpcionMenuPorRol.class);
	            // Por algun motivo no me dejaba aplicar el query desde el archivo de querys asi que toco crearlo
	            // directamente
	            // TODO: Mandar el query al archivo de querys en META-INF/jpql/querys.xml y que funcione
	            Query q = em
	                    .createQuery("DELETE FROM PreguntaPorUsuario preguntaPorUsuario WHERE preguntaPorUsuario.id.usuarioId = :usuId");
	            q.setParameter("usuId", usuId);
	            q.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	        
}


