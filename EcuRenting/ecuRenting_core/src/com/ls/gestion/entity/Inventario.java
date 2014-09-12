package com.ls.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the inventario database table.
 * 
 */
@Entity
@Table(name="inventario")
public class Inventario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Integer id;

	@Column(name="cliente")
	private String cliente;

	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="existencia")
	private Integer existencia;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fecha_ingreso;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_caducidad")
	private Date fecha_caducidad;

	@Column(name="orden_retiro")
	private Integer orden_retiro;

	@Column(name="ubicacion")
	private String ubicacion;
	
	@Column(name="peso")
	private Double peso;
	
	@Column(name="volumen")
	private Double volumen;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="uni_media")
	private String uni_media;


	public Inventario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getExistencia() {
		return this.existencia;
	}

	public void setExistencia(Integer existencia) {
		this.existencia = existencia;
	}
	
	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Date getFecha_caducidad() {
		return fecha_caducidad;
	}

	public void setFecha_caducidad(Date fecha_caducidad) {
		this.fecha_caducidad = fecha_caducidad;
	}

	public Integer getOrdenRetiro() {
		return this.orden_retiro;
	}

	public void setOrdenRetiro(Integer orden_retiro) {
		this.orden_retiro = orden_retiro;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getVolumen() {
		return volumen;
	}

	public void setVolumen(Double volumen) {
		this.volumen = volumen;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUni_media() {
		return uni_media;
	}

	public void setUni_media(String uni_media) {
		this.uni_media = uni_media;
	}

}