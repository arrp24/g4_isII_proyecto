package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Local;

import com.ls.gestion.entity.Renting;

@Local
public interface RentingServicioLocal {

	 /**
	    * <b>
	    * Se recupera el listado total de las renting
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @return List<Renting>
	    */
	   
		List<Renting> getAll();

	   /**
	    * <b>
	    * Se crea un nuevo Renting
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param Renting
	    * @return
	    */
	   void crearRenting(Renting renting);

	   /**
	    * 
	    * <b>
	    * Se actualiza un Renting
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param renting
	    * @return
	    */
	   void actualizarRenting(Renting renting);

	   /**
	    * <b>
	    * Elimina el Renting pasada por par�metro.
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param codigoRenting codigo que pertenece a Renting a borrarse
	    *           
	    */
	   void eliminarRenting(Integer codigoRenting);

	   /**
	    * <b>
	    * Devuelve Renting buscada por c�digo.
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param codigo C�digo de Renting a buscar.
	    * @return Renting
	    */
	   Renting buscarRentingPorCodigo(Integer codigo);
}
