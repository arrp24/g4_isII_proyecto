package com.ls.gestion.web.backing;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ToggleEvent;


import com.ls.gestion.entity.Inventario;
import com.ls.gestion.service.InventarioServicioLocal;


@ManagedBean(name = "inventarioBacking")
@ViewScoped
public class InventarioBacking implements Serializable {
	
	private static final long serialVersionUID = 5297201599173897134L;
	
	@EJB
	private InventarioServicioLocal inventarioServicio;
	
	
	private List<Inventario> inventarios;
	private Inventario inventario;
	private Inventario selectedInventario;
	
	
	public InventarioBacking() {
	        this.inventario = new Inventario();
	}

	    
	@PostConstruct
	public void init() {
		this.inventarios = inventarioServicio.getAll();
	}


	public InventarioServicioLocal getInventarioServicio() {
		return inventarioServicio;
	}


	public void setInventarioServicio(InventarioServicioLocal inventarioServicio) {
		this.inventarioServicio = inventarioServicio;
	}


	public List<Inventario> getInventarios() {
		return inventarios;
	}


	public void setInventarios(List<Inventario> inventarios) {
		this.inventarios = inventarios;
	}


	public Inventario getInventario() {
		return inventario;
	}


	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}


	public Inventario getSelectedInventario() {
		return selectedInventario;
	}


	public void setSelectedInventario(Inventario selectedInventario) {
		this.selectedInventario = selectedInventario;
	}
	
	public void crearInventario() {
	       
	}
	 
	public void actualizarInventario() {
	        
	}
	 
	public void eliminarInventario() {
	        
	}
	    
	public void onRowToggle(ToggleEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item " + event.getVisibility(), "Nombre: "
                + ((Inventario) event.getData()).getDescripcion());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}


		
	    
}
