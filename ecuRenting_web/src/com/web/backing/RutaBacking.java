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

import com.ls.gestion.entity.Ruta;;
import com.ls.gestion.service.RutaServicioLocal;


@ManagedBean(name = "rutaBacking")
@ViewScoped
public class RutaBacking implements Serializable{

	private static final long serialVersionUID = 5297201599173897134L;

	@EJB
	private RutaServicioLocal rutaServicio;
	
	private List<Ruta> rutas;
	private Ruta ruta;
	private Ruta selectedRuta;
	
	public RutaBacking() {
	   this.ruta = new Ruta();
	}

	    
	@PostConstruct
	public void init() {
		
		this.rutas = rutaServicio.getAll();
	}
	
	 public RutaServicioLocal getRutaServicio() {
		return rutaServicio;
	}


	public void setRutaServicio(RutaServicioLocal rutaServicio) {
		this.rutaServicio = rutaServicio;
	}


	public List<Ruta> getRutas() {
		return rutas;
	}


	public void setRutas(List<Ruta> rutas) {
		this.rutas = rutas;
	}


	public Ruta getRuta() {
		return ruta;
	}


	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}


	public Ruta getSelectedRuta() {
		return selectedRuta;
	}


	public void setSelectedRuta(Ruta selectedRuta) {
		this.selectedRuta = selectedRuta;
	}



	public void crearRuta() {
	        rutaServicio.crearRuta(ruta);
	        ruta = new Ruta();
	        rutas = rutaServicio.getAll();
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Creación Exitosa",
	                "Se ha creado una nueva ruta exitosamente!");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	 
	    public void actualizarRuta() {
	    	rutaServicio.actualizarRuta(this.selectedRuta);
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización Exitosa",
	                "Se ha actualizado exitosamente la ruta");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        this.selectedRuta = null;
	    }
	 

	    public void eliminarRuta() {
	        
	    }
	    
}
