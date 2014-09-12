package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Local;

import com.ls.gestion.entity.Ruta;

@Local
public interface RutaServicioLocal {

	 /**
	    * <b>
	    * Se recupera el listado total de Rutas
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
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
	    * [Author: katy, Date: Jun 18, 2014]
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
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param ruta
	    * @return
	    */
	   void actualizarRuta(Ruta ruta);

	   /**
	    * <b>
	    * Elimina la ruta pasado por par�metro.
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param codigoRuta codigo que pertenece a la Ruta a borrarse
	    *           
	    */
	   void eliminarRuta(Integer codigoRuta);

	   /**
	    * <b>
	    * Devuelve la Ruta buscada por c�digo.
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param codigo C�digo de la Ruta a buscar.
	    * @return Ruta
	    */
	   Ruta buscarRutaPorCodigo(Integer codigo);
}
