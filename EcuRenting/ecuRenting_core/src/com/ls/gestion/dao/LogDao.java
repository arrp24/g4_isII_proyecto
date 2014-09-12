/*
 * Copyright 2013 LIBRESOFT S.A. - ECUADOR 
 * Todos los derechos reservados
 */

package com.ls.gestion.dao;

import javax.ejb.Local;

import com.ls.gestion.commons.dao.GenericDao;
import com.ls.gestion.entity.Log;

/**
 * <b> Interfaz LogDao para el manejo de datos de la entidad Log. </b>
 * 
 * @author joselo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: joselo $, $Date: 08/08/2013 $]
 *          </p>
 */
@Local
public interface LogDao extends GenericDao<Log, Integer> {

}