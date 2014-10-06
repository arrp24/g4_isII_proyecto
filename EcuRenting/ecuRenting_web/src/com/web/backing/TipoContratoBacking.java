package com.ls.gestion.web.backing;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ToggleEvent;

import com.ls.gestion.entity.Chofer;
import com.ls.gestion.entity.TipoContrato;
import com.ls.gestion.service.TipoContratoServicioLocal;


@ManagedBean(name = "tipoContratoBacking")
@ViewScoped
public class TipoContratoBacking implements Serializable {
	
	private static final long serialVersionUID = 5297201599173897134L;

	@EJB
	private TipoContratoServicioLocal tipoContratoServicio;
	
	private List<TipoContrato> tipoContratos;
	private TipoContrato tipoContrato;
	private TipoContrato selectedTipoContrato;

	
	 public TipoContratoBacking() {
	        this.tipoContrato = new TipoContrato();
	    }

	    
	@PostConstruct
	public void init() {
		
		this.tipoContratos = tipoContratoServicio.getAll();
	}


	public TipoContratoServicioLocal getTipoContratoServicio() {
		return tipoContratoServicio;
	}


	public void setTipoContratoServicio(TipoContratoServicioLocal tipoContratoServicio) {
		this.tipoContratoServicio = tipoContratoServicio;
	}


	public List<TipoContrato> getTipoContratos() {
		return tipoContratos;
	}


	public void setTipoContratos(List<TipoContrato> tipoContratos) {
		this.tipoContratos = tipoContratos;
	}


	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}


	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}


	public TipoContrato getSelectedTipoContrato() {
		return selectedTipoContrato;
	}


	public void setSelectedTipoContrato(TipoContrato selectedTipoContrato) {
		this.selectedTipoContrato = selectedTipoContrato;
	}
	
	
	 public void crearTipoContrato() {
	       
	        tipoContratoServicio.crearTipoContrato(tipoContrato);
	        tipoContrato = new TipoContrato();
	        tipoContratos = tipoContratoServicio.getAll();
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Creación Exitosa",
	                "Se ha creado un nuevo Usuario exitosamente!");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	 
	    public void actualizarTipoContrato() {
	        tipoContratoServicio.actualizarTipoContrato(this.selectedTipoContrato);
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización Exitosa",
	                "Se ha actualizado exitosamente el usuario \"" + this.selectedTipoContrato.getNombre() + "\"");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        this.selectedTipoContrato = null;
	    }
	 

	    public void eliminarTipoContrato() {
	        
	    }
	    
	    public void onRowToggle(ToggleEvent event) {
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "TipoContrato " + event.getVisibility(), "Nombre: "
	                + ((TipoContrato) event.getData()).getNombre());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	    
}
