package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Local;

import com.gestion.entity.Cliente;

@Local
public interface ClienteServicioLocal {

	 /**
     * <b>
     * Se recupera el listado total de los Clientes
     * </b>
     * <p>
     * [Author: L�der, Date: Oct 04, 2013]
     * </p>
     * 
     * @return List<Cliente>
     */
    
	List<Cliente> getAll();

    /**
     * <b>
     * Se crea un nuevo Cliente
     * </b>
     * <p>
     * [Author: L�der, Date: Oct 04, 2013]
     * </p>
     * 
     * @param Cliente
     * @return
     */
    void crearCliente(Cliente Cliente);

    /**
     * 
     * <b>
     * Se actualiza un Cliente
     * </b>
     * <p>
     * [Author: L�der, Date: Oct 04, 2013]
     * </p>
     * 
     * @param Cliente
     * @return
     */
    void actualizarCliente(Cliente Cliente);

    /**
     * <b>
     * Elimina el Cliente pasado por par�metro.
     * </b>
     * <p>
     * [Author: L�der, Date: Oct 04, 2013]
     * </p>
     * 
     * @param codigoCliente codigo que pertenece al Cliente a borrarse
     *           
     */
    void eliminarCliente(Integer codigoCliente);

    /**
     * <b>
     * Devuelve el Cliente buscado por c�digo.
     * </b>
     * <p>
     * [Author: L�der, Date: Oct 04, 2013]
     * </p>
     * 
     * @param codigo C�digo del Cliente a buscar.
     * @return Cliente
     */
    Cliente buscarClientePorCodigo(Integer codigo);
    
   
}
