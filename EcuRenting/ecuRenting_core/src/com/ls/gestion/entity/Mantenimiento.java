package com.ls.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the mantenimiento database table.
 * 
 */
@Entity

@NamedQuery(name = "Mantenimiento.findAll", query = "SELECT d FROM Mantenimiento d")
public class Mantenimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_man")
	private Integer id;

	@Column(name="descripcion_man")
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_siguiente_man")
	private Date fechaSiguiente;
	
	@Column(name="km")
	private Integer km ;

	@Column(name=" placa")
	private String  placa;
	
	@Column(name=" responsable")
	private String  responsable;
	 
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ultimo_man")
	private Date fechaUltimo;

	//bi-directional many-to-one association to Flota
	@ManyToOne
	@JoinColumn(name="id_flo")
	private Flota flota;

	public Mantenimiento() {
	}

	public Integer getId() {
		return id;
	}

	public Integer getKm() {
		return km;
	}

	public void setKm(Integer km) {
		this.km = km;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaSiguiente() {
		return fechaSiguiente;
	}

	public void setFechaSiguiente(Date fechaSiguiente) {
		this.fechaSiguiente = fechaSiguiente;
	}

	public Date getFechaUltimo() {
		return fechaUltimo;
	}

	public void setFechaUltimo(Date fechaUltimo) {
		this.fechaUltimo = fechaUltimo;
	}

	public Flota getFlota() {
		return flota;
	}

	public void setFlota(Flota flota) {
		this.flota = flota;
	}


}