package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Remoto;

import com.gestion.entity.Ruta;

@Remoto
public interface RutaServicioRemoto {

	 /**
	    * <b>
	    * Se recupera el listado total de Rutas
	    * </b>
	    * <p>
	    * [Author: Desarrollo, Date: Oct 03, 2014]
	    * </p>
	    * 
	    * @return List<Ruta>
	    */
	   
		List<Ruta> getAll();

	   /**
	    * <b>
	    * Se crea una nueva Ruta
	    * </b>
	    * <p>
	    * [Author: Desarrollo, Date: Oct 03, 2014]
	    * </p>
	    * 
	    * @param ruta
	    * @return
	    */
	   void crearRuta(Ruta ruta);

	   /**
	    * 
	    * <b>
	    * Se actualiza una ruta
	    * </b>
	    * <p>
	    * [Author: Desarrollo, Date: Oct 03, 2014]
	    * </p>
	    * 
	    * @param ruta
	    * @return
	    */
	   void actualizarRuta(Ruta ruta);

	   /**
	    * <b>
	    * Elimina la ruta pasado por parámetro.
	    * </b>
	    * <p>
	    * [Author: Desarrollo, Date: Oct 03, 2014]
	    * </p>
	    * 
	    * @param codigoRuta codigo que pertenece a la Ruta a borrarse
	    *           
	    */
	   void eliminarRuta(Integer codigoRuta);

	   /**
	    * <b>
	    * Devuelve la Ruta buscada por código.
	    * </b>
	    * <p>
	    * [Author: Desarrollo, Date: Oct 03, 2014]
	    * </p>
	    * 
	    * @param codigo Código de la Ruta a buscar.
	    * @return Ruta
	    */
	   Ruta buscarRutaPorCodigo(Integer codigo);
}
