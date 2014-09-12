package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Local;

import com.ls.gestion.entity.Empresa;
import com.ls.gestion.entity.PreguntaPorUsuario;

@Local
public interface PreguntaPorUsuarioServicioLocal {
	
	 /**
	    * <b>
	    * Se recupera el listado total de Preguntas por usuario
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @return List<PreguntaPorUsuario>
	    */
	   
		List<PreguntaPorUsuario> getAll();

	   /**
	    * <b>
	    * Se crea una nueva PreguntaPorUsuario
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param preguntaPorUsuario
	    * @return
	    */
	   void crearPreguntaPorUsuario(PreguntaPorUsuario preguntaPorUsuario);

	   /**
	    * 
	    * <b>
	    * Se actualiza una PreguntaPorUsuario
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param preguntaPorUsuario
	    * @return
	    */
	   void actualizarPreguntaPorUsuario(PreguntaPorUsuario preguntaPorUsuario);

	   /**
	    * <b>
	    * Elimina la PreguntaPorUsuario pasado por parámetro.
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param codigoPreguntaPorUsuario codigo que pertenece a la PreguntaPorUsuario a borrarse
	    *           
	    */
	  // void eliminarPreguntaPorUsuario(Integer codigoPreguntaPorUsuario);

	   /**
	    * <b>
	    * Devuelve la PreguntaPorUsuario buscada por código.
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param codigo Código de la PreguntaPorUsuario a buscar.
	    * @return PreguntaPorUsuario
	    */
	   //PreguntaPorUsuario buscarPreguntaPorUsuarioPorCodigo(Integer codigo);


}
