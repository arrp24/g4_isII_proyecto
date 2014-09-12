package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Local;

import com.ls.gestion.entity.HistorialMantenimiento;

@Local
public interface HistorialMantenimientoServicioLocal {

	 /**
	    * <b>
	    * Se recupera el listado total de HistorialMantenimientos
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @return List<HistorialMantenimiento>
	    */
	   
		List<HistorialMantenimiento> getAll();

	   /**
	    * <b>
	    * Se crea una nueva HistorialMantenimiento
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param HistorialMantenimiento
	    * @return
	    */
	   void crearHistorialMantenimiento(HistorialMantenimiento HistorialMantenimiento);

	   /**
	    * 
	    * <b>
	    * Se actualiza una HistorialMantenimiento
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param HistorialMantenimiento
	    * @return
	    */
	   void actualizarHistorialMantenimiento(HistorialMantenimiento HistorialMantenimiento);

	   /**
	    * <b>
	    * Elimina la HistorialMantenimiento pasado por parámetro.
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param codigoHistorialMantenimiento codigo que pertenece a la HistorialMantenimiento a borrarse
	    *           
	    */
	   void eliminarHistorialMantenimiento(Integer codigoHistorialMantenimiento);

	   /**
	    * <b>
	    * Devuelve la HistorialMantenimiento buscada por código.
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param codigo Código de la HistorialMantenimiento a buscar.
	    * @return HistorialMantenimiento
	    */
	   HistorialMantenimiento buscarHistorialMantenimientoPorCodigo(Integer codigo);
}
