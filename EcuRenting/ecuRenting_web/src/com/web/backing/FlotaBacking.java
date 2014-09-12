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

import com.ls.gestion.entity.Empresa;
import com.ls.gestion.entity.Flota;
import com.ls.gestion.entity.Usuario;
import com.ls.gestion.service.EmpresaServicioLocal;
import com.ls.gestion.service.FlotaServicioLocal;


@ManagedBean(name = "flotaBacking")
@ViewScoped
public class FlotaBacking implements Serializable {

	private static final long serialVersionUID = 5297201599173897134L;

	@EJB
	private FlotaServicioLocal flotaServicio;	
	
	@EJB
	private EmpresaServicioLocal empresaServicio;	
	
	private List<Flota> flotas;
	private Flota flota;
	private Flota selectedFlota;
	
	private List<Empresa> empresas;
	
	 public FlotaBacking() {
	        this.flota = new Flota();
	}

	    
	@PostConstruct
	public void init() {
		
		this.flotas = flotaServicio.getAll();
		this.setEmpresas(empresaServicio.getAll());
	}
	
  
	public FlotaServicioLocal getFlotaServicio() {
		return flotaServicio;
	}
	

	public void setFlotaServicio(FlotaServicioLocal flotaServicio) {
		this.flotaServicio = flotaServicio;
	}


	public List<Flota> getFlotas() {
		return flotas;
	}
	public void setFlotas(List<Flota> flotas) {
		this.flotas = flotas;
	}
	
	
	
	
	public Flota getFlota() {
		return flota;
	}


	public void setFlota(Flota flota) {
		this.flota = flota;
	}


	public Flota getSelectedFlota() {
		return selectedFlota;
	}

	
	public void setSelectedFlota(Flota selectedFlota) {
		this.selectedFlota = selectedFlota;
		
	}

	 public void onRowToggle(ToggleEvent event) {
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Flota " + event.getVisibility(), "Placa: "
	                + ((Flota) event.getData()).getPlaca());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }

	public void crearFlota() {
		flotaServicio.crearFlota(flota);
		flota = new Flota();
		flotas = flotaServicio.getAll();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Creación Exitosa",
				"Se ha creado una nueva Flota exitosamente!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void actualizarFlota() {
		flotaServicio.actualizarFlota(this.selectedFlota);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Actualización Exitosa",
				"Se ha actualizado exitosamente la flota \""
						+ this.selectedFlota.getPlaca() + "\"");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		this.selectedFlota = null;
	}
	
	public void eliminarFlota() {
		if (this.selectedFlota != null) {
			flotaServicio.eliminarFlota(selectedFlota.getId());

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Eliminación Exitosa",
					"Se ha borrado exitosamente la flota \""
							+ this.selectedFlota.getPlaca() + "\"");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			this.selectedFlota = null;
			this.flotas = flotaServicio.getAll();
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Error de Selección",
					"Ha ocurrido un error al seleccionar una flota");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}


	public List<Empresa> getEmpresas() {
		return empresas;
	}


	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}


	
}
