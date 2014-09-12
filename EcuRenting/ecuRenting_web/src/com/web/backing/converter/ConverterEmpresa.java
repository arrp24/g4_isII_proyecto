package com.ls.gestion.web.backing.converter;
 
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
 


import com.ls.gestion.entity.Empresa;
import com.ls.gestion.service.EmpresaServicioLocal;
 
@FacesConverter("converterEmpresa")
public class ConverterEmpresa implements Converter {
	@EJB
	private EmpresaServicioLocal empresaServicio;
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
         
            return empresaServicio.buscarEmpresaPorCodigo(Integer.parseInt(value));
        }
        else {
        	System.out.println("retorno nulo.....");
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Empresa) object).getId());
        }
        else {
            return null;
        }
    }   
}         
 
