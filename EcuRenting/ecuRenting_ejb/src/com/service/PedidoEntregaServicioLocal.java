package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Local;

import com.ls.gestion.entity.PedidoEntrega;

@Local
public interface PedidoEntregaServicioLocal {


	 /**
    * <b>
    * Se recupera el listado total de las PedidoEntregas
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @return List<PedidoEntrega>
    */
   
	List<PedidoEntrega> getAll();

   /**
    * <b>
    * Se crea una nueva PedidoEntrega
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @param flota
    * @return
    */
   void crearPedidoEntrega(PedidoEntrega flota);

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
   void actualizarPedidoEntrega(PedidoEntrega flota);

   /**
    * <b>
    * Elimina la flota pasada por parámetro.
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @param codigoPedidoEntrega codigo que pertenece a la PedidoEntrega a borrarse
    *           
    */
   void eliminarPedidoEntrega(Integer codigoPedidoEntrega);

   /**
    * <b>
    * Devuelve la PedidoEntrega buscada por código.
    * </b>
    * <p>
    * [Author: katy, Date: Jun 18, 2014]
    * </p>
    * 
    * @param codigo Código de la PedidoEntrega a buscar.
    * @return PedidoEntrega
    */
   PedidoEntrega buscarPedidoEntregaPorCodigo(Integer codigo);
   
}
