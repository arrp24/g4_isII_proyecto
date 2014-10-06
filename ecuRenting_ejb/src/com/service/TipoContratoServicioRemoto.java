package com.service;

import java.util.List;

import javax.ejb.Remote;

import com.gestion.entity.TipoContrato;;

@Remote
public interface TipoContratoServicioRemoto {

	 /**
     * <b>
     * Se recupera el listado total de las TipoContratos
     * </b>
     * <p>
     * [Author: L�der, Date: Oct 04, 2014]
     * </p>
     * 
     * @return List<TipoContrato>
     */
    
	List<TipoContrato> getAll();

    /**
     * <b>
     * Se crea una nueva TipoContrato
     * </b>
     * <p>
     * [Author: L�der, Date: Oct 04, 2014]
     * </p>
     * 
     * @param tipoContrato
     * @return
     */
    void crearTipoContrato(TipoContrato tipoContrato);

    /**
     * 
     * <b>
     * Se actualiza una tipoContrato
     * </b>
     * <p>
     * [Author: L�der, Date: Oct 04, 2014]
     * </p>
     * 
     * @param tipoContrato
     * @return
     */
    void actualizarTipoContrato(TipoContrato tipoContrato);

    /**
     * <b>
     * Elimina la tipoContrato pasada por par�metro.
     * </b>
     * <p>
     * [Author: L�der, Date: Oct 04, 2014]
     * </p>
     * 
     * @param codigoTipoContrato codigo a borrarse
     *           
     */
    void eliminarTipoContrato(Integer codigoTipoContrato);

    /**
     * <b>
     * Devuelve la tipoContrato buscada por c�digo.
     * </b>
     * <p>
     * [Author: L�der, Date: Oct 04, 2014]
     * </p>
     * 
     * @param codigo C�digo de la TipoContrato a buscar.
     * @return TipoContrato
     */
     TipoContrato buscarTipoContratoPorCodigo(Integer codigo);
}
