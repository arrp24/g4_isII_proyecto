/*
 * Copyright 2013 LIBRESOFT S.A. - ECUADOR 
 * Todos los derechos reservados
 */

package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.LogDao;
import com.ls.gestion.entity.Log;
import com.ls.gestion.service.LogServicioLocal;
import com.ls.gestion.service.LogServicioRemoto;

/**
 * <b> Implementación del servicio de log de logeo al sistema. </b>
 * 
 * @author joselo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: joselo $, $Date: 08/08/2013 $]
 *          </p>
 */
@Stateless
public class LogServicioImpl implements LogServicioLocal, LogServicioRemoto {

    @EJB
    private static LogDao logDao;

    /**
     * Constructor Vacío de la clase.
     */
    public LogServicioImpl() {

    }

    @Override
    public void crearLog(Log nuevoLog) {
        logDao.insert(nuevoLog);

    }

    @Override
    public List<Log> getAll() {
        return logDao.findAll();
    }

}
