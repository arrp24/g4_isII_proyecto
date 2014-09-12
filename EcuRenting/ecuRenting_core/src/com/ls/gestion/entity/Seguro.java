package com.ls.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the seguro database table.
 * 
 */
@Entity
@NamedQuery(name = "Seguro.findAll", query = "SELECT d FROM Seguro d")
public class Seguro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_seg", unique = true, nullable = false)
	private Integer id;

	@Column(name="compania_seg")
	private String compania;

	@Column(name="placa")
	private String placa;

	@Column(name="descripcion_seg")
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_caducidad_seg")
	private Date fechaCaducidad;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_seg")
	private Date fechaInicio;

	@Column(name="tipo_seg")
	private String tipo;
	
	@Column(name="costo")
	private double costo;

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	//bi-directional many-to-one association to Flota
	@ManyToOne
	@JoinColumn(name="id_flo")
	private Flota flota;

	public Seguro() {
	}

	public Integer getId() {
		return id;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Flota getFlota() {
		return this.flota;
	}

	public void setFlota(Flota flota) {
		this.flota = flota;
	}
}