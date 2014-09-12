package com.ls.gestion.web.backing;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import com.ls.gestion.entity.Flota;
import com.ls.gestion.entity.Seguro;
import com.ls.gestion.service.FlotaServicioLocal;
import com.ls.gestion.service.SeguroServicioLocal;

@ManagedBean(name = "seguroBacking")
@ViewScoped

public class SeguroBacking implements Serializable{

	private static final long serialVersionUID = 5297201599173897134L;

	@EJB
	private SeguroServicioLocal seguroServicio;
	
	@EJB
	private FlotaServicioLocal FlotaServicio;
	
	private List<Flota> flotas;
	private List<Seguro> seguros;
	private Seguro seguro;
	private Seguro selectedSeguro;

	
	 public SeguroBacking() {
	        this.seguro = new Seguro();
	    }

	    
	@PostConstruct
	public void init() {
		
		this.seguros = seguroServicio.getAll();
	}
	
	
	public SeguroServicioLocal getSeguroServicio() {
		return seguroServicio;
	}


	public void setSeguroServicio(SeguroServicioLocal seguroServicio) {
		this.seguroServicio = seguroServicio;
	}


	public List<Seguro> getSeguros() {
		return seguros;
	}


	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}


	public Seguro getSeguro() {
		return seguro;
	}


	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}


	public Seguro getSelectedSeguro() {
		return selectedSeguro;
	}


	public void setSelectedSeguro(Seguro selectedSeguro) {
		this.selectedSeguro = selectedSeguro;
	}


	public void crearSeguro() {
		seguroServicio.crearSeguro(seguro);
		seguro = new Seguro();
		seguros = seguroServicio.getAll();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Creación Exitosa",
				"Se ha creado un nuevo documento exitosamente!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void actualizarSeguro() {
		seguroServicio.actualizarSeguro(this.selectedSeguro);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Actualización Exitosa",
				"Se ha actualizado exitosamente");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		this.selectedSeguro = null;
	}
	
	public void eliminarSeguro() {
		if (this.selectedSeguro != null) {
			seguroServicio.eliminarSeguro(selectedSeguro.getId());

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Eliminación Exitosa",
					"Se ha borrado exitosamente");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			this.selectedSeguro = null;
			this.seguros = seguroServicio.getAll();
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Error de Selección",
					"Ha ocurrido un error al seleccionar");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}


	public List<Flota> getFlotas() {
		this.flotas = this.FlotaServicio.getAll();
		return flotas;
	}


	public void setFlotas(List<Flota> flotas) {
		this.flotas = flotas;
	}
}



	
	
