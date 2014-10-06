package com.ls.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the archivo database table.
 * 
 */
@Entity
public class Archivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_arc")
	private Integer id;

	@Column(name="descripcion_arc")
	private String descripcion;

	@Column(name="estado_arc")
	private Boolean estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_carga_arc")
	private Date fechaCarga;

	@Column(name="nombre_arc")
	private String nombre;

	@Column(name="path_arc")
	private String path;

	public Archivo() {
	}

	public Integer getId() {
		return id;
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
}