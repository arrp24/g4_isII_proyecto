package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Remote;

import com.ls.gestion.entity.PedidoEntrega;;

@Remote
public interface PedidoEntregaServicioRemoto {

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
     * Elimina la flota pasada por par�metro.
     * </b>
     * <p>
     * [Author: katy, Date: Jun 18, 2014]
     * </p>
     * 
     * @param codigoPedidoEntrega codigo que pertenece a la flota a borrarse
     *           
     */
    void eliminarPedidoEntrega(Integer codigoPedidoEntrega);

    /**
     * <b>
     * Devuelve la flota buscada por c�digo.
     * </b>
     * <p>
     * [Author: katy, Date: Jun 18, 2014]
     * </p>
     * 
     * @param codigo C�digo de la PedidoEntrega a buscar.
     * @return PedidoEntrega
     */
     PedidoEntrega buscarPedidoEntregaPorCodigo(Integer codigo);
}