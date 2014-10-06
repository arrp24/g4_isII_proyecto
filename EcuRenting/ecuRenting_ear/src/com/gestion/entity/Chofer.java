package com.ls.gestion.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the chofer database table.
 * 
 */
@Entity
@NamedQuery(name = "Chofer.findAll", query = "SELECT d FROM Chofer d")
public class Chofer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cho", unique = true, nullable = false)
	private Integer id;

	@Column(name="cedula_cho")
	private String cedula;

	@Column(name="direccion_cho")
	private String direccion;

	@Column(name="nombre_cho")
	private String nombre;

	@Column(name="telefono_cho")
	private String telefono;

	@Column(name="tipo_licencia_cho")
	private String tipoLicencia;

	@Column(name="restriccion_noche_cho")
	private String restriccionNoche;
	
	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="id_emp")
	private Empresa empresa;

	public Chofer() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getRestriccionNoche() {
		return restriccionNoche;
	}

	public void setRestriccionNoche(String restriccionNoche) {
		this.restriccionNoche = restriccionNoche;
	}
	public String getTipoLicencia() {
		return tipoLicencia;
	}

	public void setTipoLicencia(String tipoLicencia) {
		this.tipoLicencia = tipoLicencia;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	

	

	

	
}