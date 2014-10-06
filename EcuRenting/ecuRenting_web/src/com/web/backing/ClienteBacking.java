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

import com.ls.gestion.entity.Chofer;

import com.ls.gestion.service.ChoferServicioLocal;


@ManagedBean(name = "choferBacking")
@ViewScoped
public class ChoferBacking implements Serializable {

	private static final long serialVersionUID = 5297201599173897134L;

	@EJB
	private ChoferServicioLocal choferServicio;
	
	private List<Chofer> choferes;
	private Chofer chofer;
	private Chofer selectedChofer;
	
	
	 public ChoferBacking() {
		 System.out.print("constructor..........");
	        this.chofer = new Chofer();
	    }

	    
	@PostConstruct
	public void init() {
		System.out.print("constructor..........");
		this.choferes = choferServicio.getAll();
		
	}
	
    public ChoferServicioLocal getChoferServicio() {
		return choferServicio;
	}

	public void setChoferServicio(ChoferServicioLocal choferServicio) {
		this.choferServicio = choferServicio;
	}

	public List<Chofer> getChoferes() {
		return choferes;
	}

	public void setChoferes(List<Chofer> choferes) {
		this.choferes = choferes;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}

	public Chofer getSelectedChofer() {
		return selectedChofer;
	}

	public void setSelectedChofer(Chofer selectedChofer) {
		this.selectedChofer = selectedChofer;
	}

    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chofer " + event.getVisibility(), "Nombre: "
                + ((Chofer) event.getData()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
	public void crearChofer() {
		choferServicio.crearChofer(chofer);
		chofer = new Chofer();
		choferes = choferServicio.getAll();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Creación Exitosa",
				"Se ha creado un nuevo Chofer exitosamente!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void actualizarChofer() {
		choferServicio.actualizarChofer(this.selectedChofer);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Actualización Exitosa",
				"Se ha actualizado exitosamente el chofer \""
						+ this.selectedChofer.getNombre() + "\"");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		this.selectedChofer = null;
	}
	
	public void eliminarChofer() {
		if (this.selectedChofer != null) {
			choferServicio.eliminarChofer(selectedChofer.getId());

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Eliminación Exitosa",
					"Se ha borrado exitosamente el chofer \""
							+ this.selectedChofer.getNombre() + "\"");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			this.selectedChofer = null;
			this.choferes = choferServicio.getAll();
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Error de Selección",
					"Ha ocurrido un error al seleccionar el chofer");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void habilitadoFlota(double capacidad, String tipoLicencia){
		if (tipoLicencia.equals("A1") && (capacidad == 0)){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Habilitado",
					"El tipo de licencia:" + this.selectedChofer.getTipoLicencia()+" es correcta. ");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
			
		}
		if (tipoLicencia.equals("C") && (capacidad <= 3500)){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Habilitado",
					"El tipo de licencia:" + this.selectedChofer.getTipoLicencia()+" es correcta. ");
			FacesContext.getCurrentInstance().addMessage(null, msg);
						
		}
		if (tipoLicencia.equals("C1") && (capacidad <= 3500)){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Habilitado",
					"El tipo de licencia:" + this.selectedChofer.getTipoLicencia()+" es correcta. ");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
			
		}
		if (tipoLicencia.equals("D") && (capacidad <= 3500)){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Habilitado",
					"El tipo de licencia:" + this.selectedChofer.getTipoLicencia()+" es correcta. ");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
			
		}
		if (tipoLicencia.equals("D1") && (capacidad <= 3500)){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Habilitado",
					"El tipo de licencia:" + this.selectedChofer.getTipoLicencia()+" es correcta. ");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
			
		}
		if (tipoLicencia.equals("E") ){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Habilitado",
					"El tipo de licencia:" + this.selectedChofer.getTipoLicencia()+" es correcta. ");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
			
		}
		if (tipoLicencia.equals("E1") ){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Habilitado",
					"El tipo de licencia:" + this.selectedChofer.getTipoLicencia()+" es correcta. ");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
			
		}
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Inhabilitado",
				"El tipo de licencia:" + this.selectedChofer.getTipoLicencia()+" es incorrecta para esta flota. ");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}
	
}
