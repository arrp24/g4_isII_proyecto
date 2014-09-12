package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Remote;

import com.ls.gestion.entity.Mantenimiento;;


@Remote
public interface MantenimientoServicioRemoto {

	
	 /**
	    * <b>
	    * Se recupera el listado total de los Mantenimientos
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @return List<Mantenimiento>
	    */
	   
		List<Mantenimiento> getAll();

	   /**
	    * <b>
	    * Se crea un nuevo Mantenimiento
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param mantenimiento
	    * @return
	    */
	   void crearMantenimiento(Mantenimiento mantenimiento);

	   /**
	    * 
	    * <b>
	    * Se actualiza un Mantenimiento
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param mantenimiento
	    * @return
	    */
	   void actualizarMantenimiento(Mantenimiento chofer);

	   /**
	    * <b>
	    * Elimina el Mantenimiento pasado por parámetro.
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param codigoMantenimiento codigo que pertenece al Mantenimiento a borrarse
	    *           
	    */
	   void eliminarMantenimiento(Integer codigoMantenimiento);

	   /**
	    * <b>
	    * Devuelve el Mantenimiento buscado por código.
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param codigo Código del Mantenimiento a buscar.
	    * @return Mantenimiento
	    */
	   Mantenimiento buscarMantenimientoPorCodigo(Integer codigo);
}
