package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Remote;

import com.ls.gestion.entity.Pregunta;

@Remote
public interface PreguntaServicioRemoto {

	 /**
	    * <b>
	    * Se recupera el listado total de las Preguntas
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
	   void crearPregunta(Pregunta regunta);

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
	    * Elimina la Pregunta pasado por parámetro.
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
