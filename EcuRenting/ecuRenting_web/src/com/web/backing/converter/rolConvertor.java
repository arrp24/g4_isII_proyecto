/*
 * Copyright 2013 LIBRESOFT S.A. - ECUADOR 
 * Todos los derechos reservados
 */

package com.ls.gestion.web.backing.converter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.ls.gestion.entity.Rol;
import com.ls.gestion.service.RolServicioLocal;

/**
 * <b> Convertor de Cargo. </b>
 * 
 * @author joselo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: joselo $, $Date: 02/07/2013 $]
 *          </p>
 */
@ManagedBean
public class rolConvertor implements Converter {

    @EJB
    private RolServicioLocal rolServicio;

    /**
     * <b> Devuelve como objeto el codigo indicado. </b>
     * <p>
     * [Author: joselo, Date: 02/07/2013]
     * </p>
     * 
     * @param context
     *            Contexto
     * @param component
     *            Componente
     * @param value
     *            Valor del Codigo
     * @return Objeto encontrado
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        return rolServicio.buscarRolPorCodigo(value);
    }

    /**
     * <b> Devuevle como String el Objeto Entregado. </b>
     * <p>
     * [Author: joselo, Date: 02/07/2013]
     * </p>
     * 
     * @param context
     *            Contexto
     * @param component
     *            Componente
     * @param value
     *            Valor del Codigo
     * @return String del objeto
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        String id = null;
        try {
            id = ((Rol) value).getId();
        } catch (Exception e) {
            e.getMessage();
        }
        return (id == null) ? null : id.toString();
    }

}
