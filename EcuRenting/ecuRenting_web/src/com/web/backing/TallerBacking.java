package com.web.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.ToggleEvent;

import com.ls.gestion.entity.Taller;;
import com.ls.gestion.service.TallerServicioLocal;


@ManagedBean(name = "tallerBacking")
@ViewScoped
public class TallerBacking implements Serializable{

	private static final long serialVersionUID = 5297201599173897134L;

	@EJB
	private TallerServicioLocal tallerServicio;
	
	private List<Taller> tallers;
	private Taller taller;
	private Taller selectedTaller;
	
	public TallerBacking() {
	   this.taller = new Taller();
	}

	    
	@PostConstruct
	public void init() {
		
		this.tallers = tallerServicio.getAll();
	}
	
	 public TallerServicioLocal getTallerServicio() {
		return tallerServicio;
	}


	public void setTallerServicio(TallerServicioLocal tallerServicio) {
		this.tallerServicio = tallerServicio;
	}


	public List<Taller> getTallers() {
		return tallers;
	}


	public void setTallers(List<Taller> tallers) {
		this.tallers = tallers;
	}


	public Taller getTaller() {
		return taller;
	}


	public void setTaller(Taller taller) {
		this.taller = taller;
	}


	public Taller getSelectedTaller() {
		return selectedTaller;
	}


	public void setSelectedTaller(Taller selectedTaller) {
		this.selectedTaller = selectedTaller;
	}



	public void crearTaller() {
	        tallerServicio.crearTaller(taller);
	        taller = new Taller();
	        tallers = tallerServicio.getAll();
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Creación Exitosa",
	                "Se ha creado una nueva taller exitosamente!");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	 
	    public void actualizarTaller() {
	    	tallerServicio.actualizarTaller(this.selectedTaller);
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización Exitosa",
	                "Se ha actualizado exitosamente la taller");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        this.selectedTaller = null;
	    }
	 

	    public void eliminarTaller() {
	        
	    }
	    
}
