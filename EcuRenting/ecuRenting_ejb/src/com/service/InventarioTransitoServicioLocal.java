package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Local;

import com.ls.gestion.entity.InventarioTransito;

@Local
public interface InventarioTransitoServicioLocal {

	 /**
    * <b>
    * Se recupera el listado total de los InventarioTransito
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @return List<InventarioTransito>
    */
   
	List<InventarioTransito> getAll();

   /**
    * <b>
    * Se crea un nuevo InventarioTransito
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
    * Se actualiza un inventarioTransito
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
    * @param codigoInventarioTransito codigo que pertenece al inventarioTransito a borrarse
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
    * @param codigo Código del InventarioTransito a buscar.
    * @return InventarioTransito
    */
   InventarioTransito buscarInventarioTransitoPorCodigo(Integer codigo);
}

