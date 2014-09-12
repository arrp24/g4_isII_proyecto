package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Remote;

import com.ls.gestion.entity.PreguntaPorUsuario;

@Remote
public interface PreguntaPorUsuarioServicioRemoto {

	/**
     * <b>
     * Se recupera el listado total de las PreguntaPorUsuario
     * </b>
     * <p>
     * [Author: katy, Date: Jun 14, 2014]
     * </p>
     * 
     * @return List<PreguntaPorUsuario>
     */
    List<PreguntaPorUsuario> getAll();

    /**
     * <b>
     * Se crea una nueva PreguntaPorUsuario
     * </b>
     * <p>
     * [Author: katy, Date: Jun 14, 2014]
     * </p>
     * 
     * @param preguntaPorUsuario
     * @return
     */
    void crearPreguntaPorUsuario (PreguntaPorUsuario preguntaPorUsuario);

    /**
     * Se actualiza una PreguntaPorUsuario
     * <b>
     * <p>
     * [Author: katy, Date: Jun 14, 2014]
     * </p>
     * 
     * @param preguntaPorUsuario
     * @return
     */
    void actualizarPreguntaPorUsuario(PreguntaPorUsuario preguntaPorUsuario);

    /**
     * <b>
     * Elimina la PreguntaPorUsuario pasada por parámetro.
     * </b>
     * <p>
     * [Author: katy, Date: Jun 14, 2014]
     * </p>
     * 
     * @param codigoPreguntaPorUsuario
     *            Codigo de la PreguntaPorUsuario a ser borrado
     */
  //  void eliminarPreguntaPorUsuario(Integer codigoPreguntaPorUsuario);

    /**
     * <b>
     * Devuelve una PreguntaPorUsuario busacada por código.
     * </b>
     * <p>
     * [Author: katy, Date: Jun 14, 2014]
     * </p>
     * 
     * @param codigo
     *            Código a buscar.
     * @return PreguntaPorUsuario
     */
    //PreguntaPorUsuario buscarPreguntaPorUsuarioPorCodigo(Integer codigo);

}
