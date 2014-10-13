package com.ecurenting.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import com.ecurenting.action.TipocontratoEjb;
import com.ecurenting.entities.Tipocontrato;

@ManagedBean(name="tipoContratoBean")
@SessionScoped
public class TipocontratoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3207017062662755556L;
	private Tipocontrato tipoContrato = new Tipocontrato();
	private Date fechaInicio = new Date();
	private Date fechaFin = new Date();
	private List<Tipocontrato> list = new ArrayList<Tipocontrato>();

	@EJB
	TipocontratoEjb tipoAction;
	
	
	public void guardar(){
		System.out.println("entro");
		try {
			tipoAction.persist(tipoContrato);
			tipoContrato = new Tipocontrato();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void buscar(){
		System.out.println("entro");
		try {
			list = tipoAction.findAll();
			RequestContext.getCurrentInstance().update("tipoContratoForm:tablaUsuario");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizar() {
		try {
			tipoAction.merge(tipoContrato);
			tipoContrato = new Tipocontrato();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void eliminar() {
		
	}


	public Tipocontrato getTipoContrato() {
		return tipoContrato;
	}


	public void setTipoContrato(Tipocontrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}


	public List<Tipocontrato> getList() {
		return list;
	}


	public void setList(List<Tipocontrato> list) {
		this.list = list;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}
