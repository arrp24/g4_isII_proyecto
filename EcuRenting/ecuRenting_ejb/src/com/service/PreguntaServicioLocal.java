package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Local;

import com.ls.gestion.entity.Chofer;
import com.ls.gestion.entity.Pregunta;

@Local
public interface PreguntaServicioLocal {

	 /**
	    * <b>
	    * Se recupera el listado total de las preguntas
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @return List<Pregunta>
	    */
	   
		List<Pregunta> getAll();

	   /**
	    * <b>
	    * Se crea un nuevo Pregunta
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param pregunta
	    * @return
	    */
	   void crearPregunta(Pregunta pregunta);

	   /**
	    * 
	    * <b>
	    * Se actualiza una Pregunta
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param pregunta
	    * @return
	    */
	   void actualizarPregunta(Pregunta pregunta);

	   /**
	    * <b>
	    * Elimina la Pregunta pasada por parámetro.
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param codigoPregunta codigo que pertenece a la Pregunta a borrarse
	    *           
	    */
	   void eliminarPregunta(Integer codigoPregunta);

	   /**
	    * <b>
	    * Devuelve la Pregunta buscado por código.
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param codigo Código de la Pregunta a buscar.
	    * @return Pregunta
	    */
	   Pregunta buscarPreguntaPorCodigo(Integer codigo);

}
