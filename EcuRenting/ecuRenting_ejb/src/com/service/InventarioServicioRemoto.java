package com.ls.gestion.service;

import java.util.List;
import javax.ejb.Remote;

import com.ls.gestion.entity.Inventario;

@Remote
public interface InventarioServicioRemoto {

	 /**
    * <b>
    * Se recupera el listado total de los Inventarioes
    * </b>
    * <p>
    * [Author: Andres, Date: Jun 18, 2014]
    * </p>
    * 
    * @return List<Inventario>
    */
   
	List<Inventario> getAll();

   /**
    * <b>
    * Se crea un nuevo Inventario
    * </b>
    * <p>
    * [Author: Andres, Date: Jun 18, 2014]
    * </p>
    * 
    * @param archivo
    * @return
    */
   void crearInventario(Inventario inventario);

   /**
    * 
    * <b>
    * Se actualiza un inventario
    * </b>
    * <p>
    * [Author: Andres, Date: Jun 18, 2014]
    * </p>
    * 
    * @param inventario
    * @return
    */
   void actualizarInventario(Inventario inventario);

   /**
    * <b>
    * Elimina el archivo pasado por parámetro.
    * </b>
    * <p>
    * [Author: Andres, Date: Jun 18, 2014]
    * </p>
    * 
    * @param codigoInventario codigo que pertenece al inventario a borrarse
    *           
    */
   void eliminarInventario(Integer codigoInventario);

   /**
    * <b>
    * Devuelve el inventario buscado por código.
    * </b>
    * <p>
    * [Author: Andres, Date: Jun 18, 2014]
    * </p>
    * 
    * @param codigo Código del Inventario a buscar.
    * @return Inventario
    */
   Inventario buscarInventarioPorCodigo(Integer codigo);

}
