/*
 * Copyright 2013 LIBRESOFT S.A. - ECUADOR 
 * Todos los derechos reservados
 */

package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.LogDao;
import com.ls.gestion.entity.Log;

/**
 * <b>Clase que implementa la interfaz LogDao para el manejo de datos de la entidad Log. </b>
 * 
 * @author joselo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: joselo $, $Date: 08/08/2013 $]
 *          </p>
 */
@Stateless
public class LogDaoImpl extends GenericDaoImpl<Log, Integer> implements LogDao {
    /**
     * Constructor
     */
    public LogDaoImpl() {
        super(Log.class);
    }

}
