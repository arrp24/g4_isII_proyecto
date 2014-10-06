package com.ls.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the pedido_retiro database table.
 * 
 */
@Entity
@Table(name="pedido_retiro")
public class PedidoRetiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true, nullable=false)
	private Integer id;

	@Column(name="bodega")
	private String bodega;

	@Column(name="descripcion")
	private String descripcion;

	@Column(name="fecha")
	private Date fecha;
	
	@Column(name="peso")
	private Integer peso;

	@Column(name="volumen")
	private Integer volumen;
	
	@Column(name="id_cliente")
	private String idCliente;
	

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public PedidoRetiro() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBodega() {
		return this.bodega;
	}

	public void setBodega(String bodega) {
		this.bodega = bodega;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getPeso() {
		return this.peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer getVolumen() {
		return this.volumen;
	}

	public void setVolumen(Integer volumen) {
		this.volumen = volumen;
	}

}