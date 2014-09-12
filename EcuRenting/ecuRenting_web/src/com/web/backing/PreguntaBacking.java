package com.ls.gestion.web.backing;



import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ls.gestion.entity.Pregunta;
import com.ls.gestion.service.PreguntaServicioLocal;

@ManagedBean(name = "preguntaBacking")
@ViewScoped

public class PreguntaBacking implements Serializable {

	 private static final long serialVersionUID = -4171368859938600826L;

	    @EJB
	    private PreguntaServicioLocal preguntaServicioLocal;

	    @ManagedProperty(value = "#{authenticationBacking}")
	    private AuthenticationBacking authenticationBacking;

	    private List<Pregunta> preguntas;
	    private Pregunta pregunta = new Pregunta();
	    private Pregunta preguntaEdit;
	   // private DualListModel<OpcionMenu> opcionMenuPorRol = new DualListModel<OpcionMenu>();

	    private Integer codigoSelectedPregunta = 0;
	    
	    public PreguntaBacking() {
	    	preguntaEdit = new Pregunta();
	        
	    }

	    @PostConstruct
	    public void init() {
	    	preguntas = preguntaServicioLocal.getAll();
	        
	    }
	 

	    public void crearPregunta() {
	        preguntaServicioLocal.crearPregunta(pregunta);
	        pregunta = new Pregunta();
	        preguntas = preguntaServicioLocal.getAll();

	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Creación Exitosa",
	                "Se ha creado una nueva pregunta exitosamente!");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }

/*	    public void onEdit(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Edición Actualizada");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        preguntaServicioLocal.actualizarpregunta(((Pregunta) event.getObject()));
	    }*/

	    public void eliminarPregunta() {
	        if (this.codigoSelectedPregunta != null) {
	        	preguntaServicioLocal.eliminarPregunta(this.codigoSelectedPregunta);

	        	preguntas = preguntaServicioLocal.getAll();

	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminación Exitosa",
	                    "Se ha borrado exitosamente la pregunta \"" + this.codigoSelectedPregunta + "\"");
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	            this.codigoSelectedPregunta = null;
	        } else {
	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Selección",
	                    "Ha ocurrido un error al seleccionar la pregunta");
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	        }
	    }

	    public void actualizarPregunta() {
	        
	        preguntaServicioLocal.actualizarPregunta(this.preguntaEdit);
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización Exitosa",
	                "Se ha actualizado exitosamente la pregunta");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
}

