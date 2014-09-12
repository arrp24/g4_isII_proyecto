package com.ls.gestion.web.backing;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ls.gestion.entity.Flota;
import com.ls.gestion.entity.HistorialMantenimiento;
import com.ls.gestion.entity.Mantenimiento;
import com.ls.gestion.entity.Tecnico;
import com.ls.gestion.service.FlotaServicioLocal;
import com.ls.gestion.service.HistorialMantenimientoServicioLocal;
import com.ls.gestion.service.MantenimientoServicioLocal;
import com.ls.gestion.service.TecnicoServicioLocal;
import com.ls.gestion.web.util.Mail;

@ManagedBean(name = "mantenimientoBacking")
@ViewScoped
public class MantenimientoBacking  implements Serializable {

	private static final long serialVersionUID = 5297201599173897134L;

	@EJB
	private MantenimientoServicioLocal mantenimientoServicio;
	
	@EJB
	private FlotaServicioLocal FlotaServicio;
	
	public FlotaServicioLocal getFlotaServicio() {
		return FlotaServicio;
	}


	public void setFlotaServicio(FlotaServicioLocal flotaServicio) {
		FlotaServicio = flotaServicio;
	}


	@EJB
	private TecnicoServicioLocal tecnicoServicio;
	
	@EJB
	private HistorialMantenimientoServicioLocal historialMantenimientoServicio;
	
	private List<Mantenimiento> mantenimientos;
	private List<Flota> flotas;
	private List<Tecnico> tecnicos;
	private List<HistorialMantenimiento> historialMantenimientos;
	private Mantenimiento mantenimiento;
	private Mantenimiento selectedMantenimiento;
	private String destinoMail = "arrp19@gmail.com";
	
	 public MantenimientoBacking() {
	        this.mantenimiento = new Mantenimiento();
	    }

	    
	@PostConstruct
	public void init() {
		
		this.mantenimientos = mantenimientoServicio.getAll();
		this.historialMantenimientos = historialMantenimientoServicio.getAll();
		
	}

	public MantenimientoServicioLocal getMantenimientoServicio() {
		return mantenimientoServicio;
	}


	public void setMantenimientoServicio(
			MantenimientoServicioLocal mantenimientoServicio) {
		this.mantenimientoServicio = mantenimientoServicio;
	}


	public List<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}


	public void setMantenimientos(List<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}


	public Mantenimiento getMantenimiento() {
		return mantenimiento;
	}


	public void setMantenimiento(Mantenimiento mantenimiento) {
		this.mantenimiento = mantenimiento;
	}


	public Mantenimiento getSelectedMantenimiento() {
		return selectedMantenimiento;
	}


	public void setSelectedMantenimiento(Mantenimiento selectedMantenimiento) {
		this.selectedMantenimiento = selectedMantenimiento;
	}


	public void crearMantenimiento() {
		String patron = "dd/MM/yyyy";
	    SimpleDateFormat formato = new SimpleDateFormat(patron);
		   
		FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "NOTIFICACION ENVIADA",
                "El mail con la notificacion de la cita para mantenimiento se envio correctamente.");
    	FacesContext.getCurrentInstance().addMessage(null, msg1);
		    HistorialMantenimiento historialMantenimiento  = new HistorialMantenimiento ();
		    
	        mantenimientoServicio.crearMantenimiento(mantenimiento);
	        
	        historialMantenimiento.setObservacion(this.mantenimiento.getDescripcion());
	    	historialMantenimiento.setCosto(0);
	    	historialMantenimiento.setEstado("Pendiente");
	    	historialMantenimiento.setTecnicoResponsable(this.mantenimiento.getResponsable());
	    	historialMantenimiento.setKm(this.mantenimiento.getKm());
	    	historialMantenimiento.setFecha(this.mantenimiento.getFechaSiguiente());
	    	historialMantenimiento.setPlaca(this.mantenimiento.getPlaca());
	    	
	    	this.historialMantenimientoServicio.crearHistorialMantenimiento(historialMantenimiento);

	    	
	    	
	    	String mensaje = "Se ha agendado una cita para mantenimiento del vehiculo de placa: "+historialMantenimiento.getPlaca()
	    			+"("+historialMantenimiento.getKm()+") Kms.\nEl dia: "
	    	+formato.format(historialMantenimiento.getFecha())+" a cargo del tecnico: "+historialMantenimiento.getTecnicoResponsable()
	    	+". \nGracias por la atencion." +
	    	"\nAtt. Unidad de mantenimiento";
	    	
	    	Mail mail = new Mail();
	    	
	    	mail.sendMail(destinoMail, mensaje, "CITA MANTENIMIENTO");
	    	
	    	
	        mantenimiento = new Mantenimiento();
	        mantenimientos = mantenimientoServicio.getAll();
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Creación Exitosa",
	                "Se ha creado un nuevo Mantenimiento exitosamente!");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        
	        historialMantenimiento = null;
	    }
	 
	    public void actualizarMantenimiento() {
	    	String patron = "dd/MM/yyyy";
		    SimpleDateFormat formato = new SimpleDateFormat(patron);
	    	FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "NOTIFICACION ENVIADA",
                    "El mail con la notificacion de la cita para mantenimiento se envio correctamente.");
	    	FacesContext.getCurrentInstance().addMessage(null, msg1);
	    	HistorialMantenimiento historialMantenimiento  = new HistorialMantenimiento ();
	    	mantenimientoServicio.actualizarMantenimiento(this.selectedMantenimiento);
	    	this.mantenimientos = this.mantenimientoServicio.getAll();
	    	
	    	historialMantenimiento.setObservacion(this.selectedMantenimiento.getDescripcion());
	    	historialMantenimiento.setCosto(0);
	    	historialMantenimiento.setEstado("Pendiente");
	    	historialMantenimiento.setTecnicoResponsable(this.selectedMantenimiento.getResponsable());
	    	historialMantenimiento.setKm(this.selectedMantenimiento.getKm());
	    	historialMantenimiento.setFecha(this.selectedMantenimiento.getFechaSiguiente());
	    	historialMantenimiento.setPlaca(this.selectedMantenimiento.getPlaca());
	    	
	    	
	    	
	    	String mensaje = "Se ha agendado una cita para mantenimiento del vehiculo de placa: "+historialMantenimiento.getPlaca()
	    			+"("+historialMantenimiento.getKm()+") Kms. \nEl dia: "
	    	+formato.format(historialMantenimiento.getFecha())+" a cargo del tecnico: "+historialMantenimiento.getTecnicoResponsable()
	    	+". \nGracias por la atencion." +
	    	"\nAtt. Unidad de mantenimiento";
	    	
	    	Mail mail = new Mail();
	    	
	    	mail.sendMail(destinoMail, mensaje, "CITA MANTENIMIENTO");
	    	
	    	this.historialMantenimientoServicio.crearHistorialMantenimiento(historialMantenimiento);
	    	
	    	
	    	
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización Exitosa",
	                "Se ha actualizado exitosamente el Mantenimiento");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        this.selectedMantenimiento = null;
	        historialMantenimiento = null;
	    }
	 

	    public void eliminarMantenimiento() {
	        if (this.selectedMantenimiento != null) {
	        	mantenimientoServicio.eliminarMantenimiento(selectedMantenimiento.getId());

	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminación Exitosa",
	                    "Se ha borrado exitosamente el Mantenimiento");
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	            this.selectedMantenimiento = null;
	            this.mantenimientos = mantenimientoServicio.getAll();
	        } else {
	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Selección",
	                    "Ha ocurrido un error al seleccionar el Mantenimiento");
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	        }
	    }


		public List<HistorialMantenimiento> getHistorialMantenimientos() {
			List<HistorialMantenimiento> temp = new ArrayList<HistorialMantenimiento>();
			
			if(this.getSelectedMantenimiento()!= null){
				this.historialMantenimientos = historialMantenimientoServicio.getAll();
				
				for (int i = 0; i< historialMantenimientos.size(); i++){
					
					if(historialMantenimientos.get(i).getPlaca().equals(
							this.getSelectedMantenimiento().getPlaca())){
						temp.add(historialMantenimientos.get(i));
					}
					
				}
				
			}
			
			if(temp.isEmpty()){return null;}
			else{historialMantenimientos = temp;return historialMantenimientos;}
			
			
		}

		public void setHistorialMantenimientos(
				List<HistorialMantenimiento> historialMantenimientos) {
			this.historialMantenimientos = historialMantenimientos;
		}


		public List<Tecnico> getTecnicos() {
			this.tecnicos = tecnicoServicio.getAll();
			return tecnicos;
		}


		public void setTecnicos(List<Tecnico> tecnicos) {
			this.tecnicos = tecnicos;
		}


		public List<Flota> getFlotas() {
			this.flotas = this.FlotaServicio.getAll();
			return flotas;
		}


		public void setFlotas(List<Flota> flotas) {
			this.flotas = flotas;
		}
}
