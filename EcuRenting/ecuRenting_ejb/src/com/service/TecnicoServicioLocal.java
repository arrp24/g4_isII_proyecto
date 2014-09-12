package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Local;

import com.ls.gestion.entity.Tecnico;

@Local
public interface TecnicoServicioLocal {

	 /**
	    * <b>
	    * Se recupera el listado total de Tecnicos
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @return List<Tecnico>
	    */
	   
		List<Tecnico> getAll();

	   /**
	    * <b>
	    * Se crea una nueva Tecnico
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param tecnico
	    * @return
	    */
	   void crearTecnico(Tecnico tecnico);

	   /**
	    * 
	    * <b>
	    * Se actualiza una tecnico
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param tecnico
	    * @return
	    */
	   void actualizarTecnico(Tecnico tecnico);

	   /**
	    * <b>
	    * Elimina la tecnico pasado por parámetro.
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param codigoTecnico codigo que pertenece a la tecnico a borrarse
	    *           
	    */
	   void eliminarTecnico(Integer codigoTecnico);

	   /**
	    * <b>
	    * Devuelve la tecnico buscada por código.
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param codigo Código de la Tecnico a buscar.
	    * @return Tecnico
	    */
	   Tecnico buscarTecnicoPorCodigo(Integer codigo);
}
