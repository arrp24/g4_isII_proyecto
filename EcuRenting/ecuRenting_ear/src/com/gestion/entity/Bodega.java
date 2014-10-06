package com.ls.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bodegas database table.
 * 
 */
@Entity
@Table(name="bodegas")
public class Bodega implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true, nullable=false)
	private Integer id;

	@Column(name="direccion")
	private String direccion;

	@Column(name="id_cliente")
	private Integer idCliente;

	@Column(name="nombre_bodega")
	private String nombreBodega;

	public Bodega() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreBodega() {
		return this.nombreBodega;
	}

	public void setNombreBodega(String nombreBodega) {
		this.nombreBodega = nombreBodega;
	}

}