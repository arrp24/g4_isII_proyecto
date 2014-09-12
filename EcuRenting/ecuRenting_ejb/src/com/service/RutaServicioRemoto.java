package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Remote;

import com.ls.gestion.entity.Ruta;

@Remote
public interface RutaServicioRemoto {
	
	/**
     * <b>
     * Se recupera el listado total de las rutas
     * </b>
     * <p>
     * [Author: katy, Date: Jun 14, 2014]
     * </p>
     * 
     * @return List<Ruta>
     */
    List<Ruta> getAll();

    /**
     * <b>
     * Se crea una nueva Ruta
     * </b>
     * <p>
     * [Author: katy, Date: Jun 14, 2014]
     * </p>
     * 
     * @param ruta
     * @return
     */
    void crearRuta (Ruta ruta);

    /**
     * Se actualiza una empresa
     * <b>
     * <p>
     * [Author: katy, Date: Jun 14, 2014]
     * </p>
     * 
     * @param empresa
     * @return
     */
    void actualizarRuta(Ruta ruta);

    /**
     * <b>
     * Elimina la ruta pasada por parámetro.
     * </b>
     * <p>
     * [Author: katy, Date: Jun 14, 2014]
     * </p>
     * 
     * @param codigoRuta
     *            Codigo de la Ruta a ser borrado
     */
    void eliminarRuta(Integer codigoRuta);

    /**
     * <b>
     * Devuelve una ruta busacada por código.
     * </b>
     * <p>
     * [Author: katy, Date: Jun 14, 2014]
     * </p>
     * 
     * @param codigo
     *            Código a buscar.
     * @return Ruta
     */
    Ruta buscarRutaPorCodigo(Integer codigo);

}
