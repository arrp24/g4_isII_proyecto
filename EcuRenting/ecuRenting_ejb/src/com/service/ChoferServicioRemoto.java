package com.ls.gestion.service;

import java.util.List;
import javax.ejb.Remote;

import com.ls.gestion.entity.Chofer;

@Remote
public interface ChoferServicioRemoto {

	 /**
    * <b>
    * Se recupera el listado total de los Choferes
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @return List<Chofer>
    */
   
	List<Chofer> getAll();

   /**
    * <b>
    * Se crea un nuevo Chofer
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @param archivo
    * @return
    */
   void crearChofer(Chofer chofer);

   /**
    * 
    * <b>
    * Se actualiza un chofer
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @param chofer
    * @return
    */
   void actualizarChofer(Chofer chofer);

   /**
    * <b>
    * Elimina el archivo pasado por parámetro.
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @param codigoChofer codigo que pertenece al chofer a borrarse
    *           
    */
   void eliminarChofer(Integer codigoChofer);

   /**
    * <b>
    * Devuelve el chofer buscado por código.
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @param codigo Código del Chofer a buscar.
    * @return Chofer
    */
   Chofer buscarChoferPorCodigo(Integer codigo);
}