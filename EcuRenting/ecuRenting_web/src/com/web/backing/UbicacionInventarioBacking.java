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


import com.ls.gestion.entity.UbicacionInventario;
import com.ls.gestion.service.UbicacionInventarioServicioLocal;


@ManagedBean(name = "ubicacionInventarioBacking")
@ViewScoped
public class UbicacionInventarioBacking implements Serializable {
	
	private static final long serialVersionUID = 5297201599173897134L;
	
	@EJB
	private UbicacionInventarioServicioLocal inventarioServicio;
	
	
	private List<UbicacionInventario> ubicacionesInventarios;
	private UbicacionInventario ubicacionInventario;
	private UbicacionInventario selectedUbicacionInventario;
	
	
	public UbicacionInventarioBacking() {
	        this.ubicacionInventario = new UbicacionInventario();
	}

	    
	@PostConstruct
	public void init() {
		this.ubicacionesInventarios = inventarioServicio.getAll();
	}


	public UbicacionInventarioServicioLocal getInventarioServicio() {
		return inventarioServicio;
	}


	public void setInventarioServicio(UbicacionInventarioServicioLocal inventarioServicio) {
		this.inventarioServicio = inventarioServicio;
	}


	public List<UbicacionInventario> getInventarios() {
		return ubicacionesInventarios;
	}


	public void setInventarios(List<UbicacionInventario> ubicacionesInventarios) {
		this.ubicacionesInventarios = ubicacionesInventarios;
	}


	public UbicacionInventario getInventario() {
		return ubicacionInventario;
	}


	public void setInventario(UbicacionInventario ubicacionInventario) {
		this.ubicacionInventario = ubicacionInventario;
	}


	public UbicacionInventario getSelectedInventario() {
		return selectedUbicacionInventario;
	}


	public void setSelectedInventario(UbicacionInventario selectedUbicacionInventario) {
		this.selectedUbicacionInventario = selectedUbicacionInventario;
	}
	
	public void crearInventario() {
	       
	}
	 
	public void actualizarInventario() {
	        
	}
	 
	public void eliminarInventario() {
	        
	}
	    
	public void onRowToggle(ToggleEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item " + event.getVisibility(), "Nombre: "
                + ((UbicacionInventario) event.getData()).getColumna());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}


		
	    
}
