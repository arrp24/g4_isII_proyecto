package com.ls.gestion.web.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ToggleEvent;


import com.ls.gestion.entity.InventarioTransito;
import com.ls.gestion.service.InventarioTransitoServicioLocal;


@ManagedBean(name = "inventarioTransitoBacking")
@ViewScoped
public class InventarioTransitoBacking implements Serializable {
	
	private static final long serialVersionUID = 5297201599173897134L;
	

	@EJB
	private InventarioTransitoServicioLocal inventarioTransitoServicio;
	
	private List<InventarioTransito> inventariosTransito;
	private InventarioTransito inventarioTransito;
	private InventarioTransito selectedInventarioTransito;

	public InventarioTransitoBacking() {
        this.inventarioTransito= new InventarioTransito();
}

    
	@PostConstruct
	public void init() {
		
		this.inventariosTransito = inventarioTransitoServicio.getAll();
	}
	
	
	public InventarioTransitoServicioLocal getInventarioTransitoServicio() {
		return inventarioTransitoServicio;
	}
	
	
	public void setInventarioServicio(InventarioTransitoServicioLocal inventarioTransitoServicio) {
		this.inventarioTransitoServicio = inventarioTransitoServicio;
	}
	
	
	public List<InventarioTransito> getInventariosTransito() {
		return inventariosTransito;
	}
	
	
	public void setInventariosTransito(List<InventarioTransito> inventariosTrasito) {
		this.inventariosTransito = inventariosTransito;
	}
	
	
	public InventarioTransito getInventarioTransito() {
		return inventarioTransito;
	}
	
	
	public void setInventarioTransito(InventarioTransito inventarioTransito) {
		this.inventarioTransito = inventarioTransito;
	}
	
	
	public InventarioTransito getSelectedInventario() {
		return selectedInventarioTransito;
	}
	
	
	public void setSelectedInventarioTransito(InventarioTransito selectedInventarioTransito) {
		this.selectedInventarioTransito = selectedInventarioTransito;
	}
	
	
	 public void crearInventarioTransito() {
		 	inventarioTransitoServicio.crearInventarioTransito(inventarioTransito);
		 	inventarioTransito = new InventarioTransito();
		 	inventariosTransito = inventarioTransitoServicio.getAll();
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Creación Exitosa",
	                "Se ha Ingresado el detalle de la Orden");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	 
	    public void actualizarInventarioTransito() {
	    	inventarioTransitoServicio.actualizarInventarioTransito(inventarioTransito);
	    	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización Exitosa",
	                "Se ha actualizado el detalle de la Orden");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        this.selectedInventarioTransito = null;
	    }
	 
	
	    public void eliminarInventarioTransito() {
	    	if (this.selectedInventarioTransito != null) {
	        	inventarioTransitoServicio.eliminarInventarioTransito(selectedInventarioTransito.getId());

	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminación Exitosa",
	                    "Se ha borrado exitosamente la ruta");
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	            this.selectedInventarioTransito = null;
	            this.inventariosTransito = inventarioTransitoServicio.getAll();
	        } else {
	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Selección",
	                    "Ha ocurrido un error al seleccionar la ruta");
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	        }
	    }
	    
	    public void onRowToggle(ToggleEvent event) {
	    	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item:" + event.getVisibility(), "Nombre: "
	                + ((InventarioTransito) event.getData()).getDescripcion());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	       
	 
	}