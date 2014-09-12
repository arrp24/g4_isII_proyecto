package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Local;

import com.ls.gestion.entity.Seguro;

@Local
public interface SeguroServicioLocal {

	 /**
	    * <b>
	    * Se recupera el listado total de Seguros
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @return List<Seguro>
	    */
	   
		List<Seguro> getAll();

	   /**
	    * <b>
	    * Se crea un nuevo Seguro
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param seguro
	    * @return
	    */
	   void crearSeguro(Seguro seguro);

	   /**
	    * 
	    * <b>
	    * Se actualiza un Seguro
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param seguro
	    * @return
	    */
	   void actualizarSeguro(Seguro seguro);

	   /**
	    * <b>
	    * Elimina el Seguro pasado por parámetro.
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param codigoSeguro codigo que pertenece al Seguro a borrarse
	    *           
	    */
	   void eliminarSeguro (Integer codigoSeguro);

	   /**
	    * <b>
	    * Devuelve el Seguro buscada por código.
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param codigo Código del Seguro a buscar.
	    * @return Seguro
	    */
	   Seguro buscarSeguroPorCodigo(Integer codigo);
}
