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

import com.ls.gestion.entity.Bodega;

import com.ls.gestion.service.BodegaServicioLocal;


@ManagedBean(name = "bodegaBacking")
@ViewScoped
public class BodegaBacking implements Serializable {

	private static final long serialVersionUID = 5297201599173897134L;

	@EJB
	private BodegaServicioLocal bodegaServicio;
	
	private List<Bodega> bodegas;
	private List<String> nombreBodegas;
	private Bodega bodega;
	private Bodega selectedBodega;
	
	
	 public BodegaBacking() {
	        this.bodega = new Bodega();
	    }

	    
	@PostConstruct
	public void init() {
		
		this.bodegas = bodegaServicio.getAll();
		
	}
	
    public BodegaServicioLocal getBodegaServicio() {
		return bodegaServicio;
	}

	public void setBodegaServicio(BodegaServicioLocal bodegaServicio) {
		this.bodegaServicio = bodegaServicio;
	}

	public List<Bodega> getBodegas() {
		return bodegas;
	}
	public List<String> getNombreBodegas() {
		nombreBodegas = new ArrayList<String>();
		List<Bodega> temp = this.bodegaServicio.getAll();
		for (int i = 0; i< temp.size(); i++){
			nombreBodegas.add(temp.get(i).getNombreBodega().toString());
		}
		
		return nombreBodegas;
	}
	public void setBodegas(List<Bodega> bodegas) {
		this.bodegas = bodegas;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public Bodega getSelectedBodega() {
		return selectedBodega;
	}

	public void setSelectedBodega(Bodega selectedBodega) {
		this.selectedBodega = selectedBodega;
	}

    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bodega " + event.getVisibility(), "Nombre: "
                + ((Bodega) event.getData()).getNombreBodega());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
	public void crearBodega() {
		bodegaServicio.crearBodega(bodega);
		bodega = new Bodega();
		bodegas = bodegaServicio.getAll();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Creación Exitosa",
				"Se ha creado un nuevo Bodega exitosamente!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void actualizarBodega() {
		bodegaServicio.actualizarBodega(this.selectedBodega);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Actualización Exitosa",
				"Se ha actualizado exitosamente el bodega \""
						+ this.selectedBodega.getNombreBodega() + "\"");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		this.selectedBodega = null;
	}
	
	public void eliminarBodega() {
		if (this.selectedBodega != null) {
			bodegaServicio.eliminarBodega(selectedBodega.getId());

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Eliminación Exitosa",
					"Se ha borrado exitosamente el bodega \""
							+ this.selectedBodega.getNombreBodega() + "\"");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			this.selectedBodega = null;
			this.bodegas = bodegaServicio.getAll();
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Error de Selección",
					"Ha ocurrido un error al seleccionar el bodega");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	

	
	}
	
}
