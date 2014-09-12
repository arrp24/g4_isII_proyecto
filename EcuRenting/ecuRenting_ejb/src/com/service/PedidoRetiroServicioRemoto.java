package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Remote;

import com.ls.gestion.entity.PedidoRetiro;;

@Remote
public interface PedidoRetiroServicioRemoto {

	 /**
     * <b>
     * Se recupera el listado total de las PedidoRetiros
     * </b>
     * <p>
     * [Author: katy, Date: Jun 18, 2014]
     * </p>
     * 
     * @return List<PedidoRetiro>
     */
    
	List<PedidoRetiro> getAll();

    /**
     * <b>
     * Se crea una nueva PedidoRetiro
     * </b>
     * <p>
     * [Author: katy, Date: Jun 18, 2014]
     * </p>
     * 
     * @param flota
     * @return
     */
    void crearPedidoRetiro(PedidoRetiro flota);

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
    void actualizarPedidoRetiro(PedidoRetiro flota);

    /**
     * <b>
     * Elimina la flota pasada por parámetro.
     * </b>
     * <p>
     * [Author: katy, Date: Jun 18, 2014]
     * </p>
     * 
     * @param codigoPedidoRetiro codigo que pertenece a la flota a borrarse
     *           
     */
    void eliminarPedidoRetiro(Integer codigoPedidoRetiro);

    /**
     * <b>
     * Devuelve la flota buscada por código.
     * </b>
     * <p>
     * [Author: katy, Date: Jun 18, 2014]
     * </p>
     * 
     * @param codigo Código de la PedidoRetiro a buscar.
     * @return PedidoRetiro
     */
     PedidoRetiro buscarPedidoRetiroPorCodigo(Integer codigo);
}
