package com.ls.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the historial_mantenimiento database table.
 * 
 */
@Entity
@Table(name="historial_mantenimiento")
public class HistorialMantenimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="costo")
	private double costo;
	
	@Column(name="estado")
	private String estado;

	@Column(name="fecha")
	private Date fecha;

	@Column(name="id_man")
	private Integer idMan;


	@Column(name="km")
	private Integer km;
	
	public Integer getKm() {
		return km;
	}

	public void setKm(Integer km) {
		this.km = km;
	}

	@Column(name="observacion")
	private String observacion;

	@Column(name="placa")
	private String placa;

	@Column(name="tecnico_responsable", length=100)
	private String tecnicoResponsable;

	public HistorialMantenimiento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getCosto() {
		return this.costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getIdMan() {
		return this.idMan;
	}

	public void setIdMan(Integer idMan) {
		this.idMan = idMan;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTecnicoResponsable() {
		return this.tecnicoResponsable;
	}

	public void setTecnicoResponsable(String tecnicoResponsable) {
		this.tecnicoResponsable = tecnicoResponsable;
	}

}