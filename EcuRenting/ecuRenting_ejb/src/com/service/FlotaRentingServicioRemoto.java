package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Remote;

import com.ls.gestion.entity.FlotaRenting;

@Remote
public interface FlotaRentingServicioRemoto {

	 /**
	    * <b>
	    * Se recupera el listado total de las Flotas
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @return List<Flota>
	    */
	   
		List<FlotaRenting> getAll();

	   /**
	    * <b>
	    * Se crea una nueva Flota
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param flota
	    * @return
	    */
	   void crearFlota(FlotaRenting flotaRenting);

	   /**
	    * 
	    * <b>
	    * Se actualiza una flota
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param flota
	    * @return
	    */
	   void actualizarFlotaRenting(FlotaRenting flotaRenting);

	   /**
	    * <b>
	    * Elimina la flota pasada por parámetro.
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param codigoFlota codigo que pertenece a la Flota a borrarse
	    *           
	    */
	   void eliminarFlotaRenting(Integer codigoFlotaRenting);

	   /**
	    * <b>
	    * Devuelve la Flota buscada por código.
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param codigo Código de la Flota a buscar.
	    * @return Flota
	    */
	   FlotaRenting buscarFlotaRentingPorCodigo(Integer codigo);
}
