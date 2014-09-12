/*
 * Copyright 2013 LIBRESOFT S.A. - ECUADOR 
 * Todos los derechos reservados
 */

package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Local;

import com.ls.gestion.entity.Log;

/**
 * <b> Interfaz del servicio <b>Local</b> para el Log de logeo al sistema. </b>
 * 
 * @author joselo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: joselo $, $Date: 08/08/2013 $]
 *          </p>
 */
@Local
public interface LogServicioLocal {

    /**
     * <b> Crea un log de logeo en la base. </b>
     * <p>
     * [Author: joselo, Date: 08/08/2013]
     * </p>
     * 
     * @param nuevoLog
     *            Log a guardar
     */
    void crearLog(Log nuevoLog);

    /**
     * <b> Devuelve una lista completa de todos los logs del sistema. </b>
     * <p>
     * [Author: joselo, Date: 08/08/2013]
     * </p>
     * 
     * @return List<Log>
     */
    public List<Log> getAll();

}
