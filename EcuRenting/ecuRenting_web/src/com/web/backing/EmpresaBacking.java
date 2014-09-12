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
import com.ls.gestion.entity.Empresa;
import com.ls.gestion.service.EmpresaServicioLocal;


@ManagedBean(name = "empresaBacking")
@ViewScoped
public class EmpresaBacking implements Serializable {
	
	private static final long serialVersionUID = 5297201599173897134L;

	@EJB
	private EmpresaServicioLocal empresaServicio;
	
	private List<Empresa> empresas;
	private Empresa empresa;
	private Empresa selectedEmpresa;

	
	 public EmpresaBacking() {
	        this.empresa = new Empresa();
	    }

	    
	@PostConstruct
	public void init() {
		
		this.empresas = empresaServicio.getAll();
	}


	public EmpresaServicioLocal getEmpresaServicio() {
		return empresaServicio;
	}


	public void setEmpresaServicio(EmpresaServicioLocal empresaServicio) {
		this.empresaServicio = empresaServicio;
	}


	public List<Empresa> getEmpresas() {
		return empresas;
	}


	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public Empresa getSelectedEmpresa() {
		return selectedEmpresa;
	}


	public void setSelectedEmpresa(Empresa selectedEmpresa) {
		this.selectedEmpresa = selectedEmpresa;
	}
	
	
	 public void crearEmpresa() {
	       
	        empresaServicio.crearEmpresa(empresa);
	        empresa = new Empresa();
	        empresas = empresaServicio.getAll();
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Creación Exitosa",
	                "Se ha creado un nuevo Usuario exitosamente!");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	 
	    public void actualizarEmpresa() {
	        empresaServicio.actualizarEmpresa(this.selectedEmpresa);
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización Exitosa",
	                "Se ha actualizado exitosamente el usuario \"" + this.selectedEmpresa.getNombre() + "\"");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        this.selectedEmpresa = null;
	    }
	 

	    public void eliminarEmpresa() {
	        if (this.selectedEmpresa != null) {
	            empresaServicio.eliminarEmpresa(selectedEmpresa.getId());

	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminación Exitosa",
	                    "Se ha borrado exitosamente la empresa \"" + this.selectedEmpresa.getNombre() + "\"");
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	            this.selectedEmpresa = null;
	            this.empresas = empresaServicio.getAll();
	        } else {
	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Selección",
	                    "Ha ocurrido un error al seleccionar la empresa");
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	        }
	    }
	    
	    public void onRowToggle(ToggleEvent event) {
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Empresa " + event.getVisibility(), "Nombre: "
	                + ((Empresa) event.getData()).getNombre());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	    
}
