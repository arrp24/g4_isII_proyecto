package com.ls.gestion.service;

import java.util.List;
import javax.ejb.Remote;

import com.ls.gestion.entity.InventarioTransito;

@Remote
public interface InventarioTransitoServicioRemoto {

	 /**
    * <b>
    * Se recupera el listado total de los Inventarioes
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @return List<Inventario>
    */
   
	List<InventarioTransito> getAll();

   /**
    * <b>
    * Se crea un nuevo Inventario
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @param archivo
    * @return
    */
   void crearInventarioTransito(InventarioTransito inventarioTransito);

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
   void actualizarInventarioTransito(InventarioTransito inventarioTransito);

   /**
    * <b>
    * Elimina el archivo pasado por parámetro.
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @param codigoInventario codigo que pertenece al chofer a borrarse
    *           
    */
   void eliminarInventarioTransito(Integer codigoInventarioTransito);

   /**
    * <b>
    * Devuelve el chofer buscado por código.
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @param codigo Código del Inventario a buscar.
    * @return Inventario
    */
   InventarioTransito buscarInventarioTransitoPorCodigo(Integer codigo);

}
