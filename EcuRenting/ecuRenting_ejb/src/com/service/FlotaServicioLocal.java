package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Local;

import com.ls.gestion.entity.Flota;

@Local
public interface FlotaServicioLocal {


	 /**
    * <b>
    * Se recupera el listado total de las Flotas
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @return List<Flota>
    */
   
	List<Flota> getAll();

   /**
    * <b>
    * Se crea una nueva Flota
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @param flota
    * @return
    */
   void crearFlota(Flota flota);

   /**
    * 
    * <b>
    * Se actualiza una flota
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @param flota
    * @return
    */
   void actualizarFlota(Flota flota);

   /**
    * <b>
    * Elimina la flota pasada por parámetro.
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @param codigoFlota codigo que pertenece a la Flota a borrarse
    *           
    */
   void eliminarFlota(Integer codigoFlota);

   /**
    * <b>
    * Devuelve la Flota buscada por código.
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @param codigo Código de la Flota a buscar.
    * @return Flota
    */
   Flota buscarFlotaPorCodigo(Integer codigo);
   
}
