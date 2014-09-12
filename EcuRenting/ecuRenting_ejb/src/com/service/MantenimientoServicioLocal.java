package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Local;

import com.ls.gestion.entity.Mantenimiento;;
@Local
public interface MantenimientoServicioLocal {
	
	/**
     * <b>
     * Se recupera el listado total de los mantenimientos
     * </b>
     * <p>
     * [Author: katy, Date: Jun 18, 2014]
     * </p>
     * 
     * @return List<Mantenimiento>
     */
    
	List<Mantenimiento> getAll();

    /**
     * <b>
     * Se crea un nuevo Mantenimiento
     * </b>
     * <p>
     * [Author: katy, Date: Jun 18, 2014]
     * </p>
     * 
     * @param mantenimiento
     * @return
     */
    void crearMantenimiento(Mantenimiento matenimiento);

    /**
     * 
     * <b>
     * Se actualiza mantenimiento
     * </b>
     * <p>
     * [Author: katy, Date: Jun 18, 2014]
     * </p>
     * 
     * @param mantenimiento
     * @return
     */
    void actualizarMantenimiento(Mantenimiento mantenimiento);

    /**
     * <b>
     * Elimina el mantenimiento pasado por parámetro.
     * </b>
     * <p>
     * [Author: katy, Date: Jun 18, 2014]
     * </p>
     * 
     * @param codigoMatenimiento codigo que pertenece al Mantenimiento a borrarse
     *           
     */
    void eliminarMantenimiento(Integer codigoMantenimiento);

    /**
     * <b>
     * Devuelve el Mantenimiento buscado por código.
     * </b>
     * <p>
     * [Author: katy, Date: Jun 18, 2014]
     * </p>
     * 
     * @param codigo Código del Mantenimiento a buscar.
     * @return Mantenimiento
     */
    Mantenimiento buscarMantenimientoPorCodigo(Integer codigo);
    

}
