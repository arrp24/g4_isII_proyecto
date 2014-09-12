package com.ls.gestion.web.backing.converter;
 
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.ls.gestion.entity.Inventario;
import com.ls.gestion.service.InventarioServicioLocal;
import com.ls.gestion.web.backing.InventarioBacking;
 
@FacesConverter("inventarioConvertor")
public class inventarioConvertor implements Converter {
	
	@EJB
	private InventarioServicioLocal inventarioServicio;
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
        	InventarioBacking invB = (InventarioBacking) fc.getExternalContext().getApplicationMap().get("inventarioBacking");
            return invB.getInventarios().get(Integer.parseInt(value));
        }
        else {
        	System.out.println("retorno nulo.....");
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Inventario) object).getId());
        }
        else {
            return null;
        }
    }   
}         
 
