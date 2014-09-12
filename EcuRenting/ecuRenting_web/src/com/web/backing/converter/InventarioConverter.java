package com.ls.gestion.web.backing.converter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import com.ls.gestion.entity.Inventario;
import com.ls.gestion.service.InventarioServicioLocal;


/**
 * <b> Convertor de Empresa. </b>
 * 
 * @author Pablo Herrera
 * @version $Revision: 1.0 $
 *          <p>
 * [Author: Pablo Herrera, Date: 02/07/2014]
 *          </p>
 */
@ManagedBean
public class InventarioConverter implements Converter {

    @EJB
    private InventarioServicioLocal inventarioServicio;

    /**
     * <b> Devuelve como objeto el codigo indicado. </b>
     * <p>
     * [Author: Pablo Herrera, Date: 02/07/2014]
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
        
  
       return inventarioServicio.buscarInventarioPorCodigo(Integer.parseInt(value));
    }

    /**
     * <b> Devuelve como String el Objeto Entregado. </b>
     * <p>
     * [Author: Pablo Herrera, Date: 02/07/2014]
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
            id = ""+((Inventario) value).getId();
            
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
        System.out.println("length.. id "+id);
        return (id == null) ? null : id.toString();
    }

}
