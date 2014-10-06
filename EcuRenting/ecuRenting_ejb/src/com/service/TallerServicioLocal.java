package com.service;

import java.util.List;

import javax.ejb.Local;

import com.ls.gestion.entity.Taller;

/**
 * <b> Interfaz del servicio <b>Remoto</b> para el Taller de Tallereo al sistema. </b>
 * 
 * @author Calidad
 * <p>
 * [$Author: Calidad $, $Date: 05 del 2014 $]
 * </p>
 */
@Local
public interface TallerServicioRemoto {
    /**
     * <b> Crea un Taller de Tallereo en la base. </b>
     * <p>
     * [Author: Calidad, Date: 05 del 2014]
     * </p>
     * 
     * @param nuevoTaller
     *            Taller a guardar
     */
    void crearTaller(Taller nuevoTaller);

    /**
     * <b> Devuelve una lista completa de todos los Tallers del sistema. </b>
     * <p>
     * [Author: Calidad, Date: 05 del 2014]
     * </p>
     * 
     * @return List<Taller>
     */
    public List<Taller> getAll();
}
