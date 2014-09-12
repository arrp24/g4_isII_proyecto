package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Remote;

import com.ls.gestion.entity.Seguro;

@Remote
public interface SeguroServicioRemoto {
	
	 /**
     * <b>
     * Se recupera el listado total de los Seguros
     * </b>
     * <p>
     * [Author: katy, Date: Jun 14, 2014]
     * </p>
     * 
     * @return List<Seguro>
     */
    List<Seguro> getAll();

    /**
     * <b>
     * Se crea una nueva Seguro
     * </b>
     * <p>
     * [Author: katy, Date: Jun 14, 2014]
     * </p>
     * 
     * @param seguro
     * @return
     */
    void crearSeguro (Seguro seguro);

    /**
     * Se actualiza un Seguro
     * <b>
     * <p>
     * [Author: katy, Date: Jun 14, 2014]
     * </p>
     * 
     * @param seguro
     * @return
     */
    void actualizarSeguro(Seguro seguro);

    /**
     * <b>
     * Elimina el Seguro pasada por parámetro.
     * </b>
     * <p>
     * [Author: katy, Date: Jun 14, 2014]
     * </p>
     * 
     * @param codigoSeguro
     *            Codigo del Seguro a ser borrado
     */
    void eliminarSeguro(Integer codigoSeguro);

    /**
     * <b>
     * Devuelve un Seguro busacada por código.
     * </b>
     * <p>
     * [Author: katy, Date: Jun 14, 2014]
     * </p>
     * 
     * @param codigo
     *            Código a buscar.
     * @return Seguro
     */
    Seguro buscarSeguroPorCodigo(Integer codigo);

}
