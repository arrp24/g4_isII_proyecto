package com.ls.gestion.service;

import java.util.List;
import javax.ejb.Remote;

import com.ls.gestion.entity.Bodega;

@Remote
public interface BodegaServicioRemoto {

	 /**
    * <b>
    * Se recupera el listado total de los Bodegaes
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @return List<Bodega>
    */
   
	List<Bodega> getAll();

   /**
    * <b>
    * Se crea un nuevo Bodega
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @param archivo
    * @return
    */
   void crearBodega(Bodega chofer);

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
   void actualizarBodega(Bodega chofer);

   /**
    * <b>
    * Elimina el archivo pasado por parámetro.
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @param codigoBodega codigo que pertenece al chofer a borrarse
    *           
    */
   void eliminarBodega(Integer codigoBodega);

   /**
    * <b>
    * Devuelve el chofer buscado por código.
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @param codigo Código del Bodega a buscar.
    * @return Bodega
    */
   Bodega buscarBodegaPorCodigo(Integer codigo);
}