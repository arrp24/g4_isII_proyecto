package com.ls.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the flota database table.
 * 
 */
@Entity
@NamedQuery(name = "Flota.findAll", query = "SELECT d FROM Flota d")
public class Flota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_flo")
	private Integer id;

	@Column(name="anio_fabricacion_flo")
	private String anioFabricacion;

	@Column(name="capacidad_flo")
	private double capacidad;

	@Column(name="color_flo")
	private String color;

	@Column(name="descripcion_flo")
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_adquisicion_flo")
	private Date fechaAdquisicion;

	@Column(name="marca_flo")
	private String marca;
	
	@Column(name="chasis_flo")
	private String chasis;

	@Column(name="motor_flo")
	private String motor;
	
	@Column(name="cpn_flo")
	private String cpn;	

	@Column(name="modelo_flo")
	private String modelo;

	@Column(name="placa_flo")
	private String placa;
	
	@Column(name="fecha_matricula_flo")
	private Date fechaMatricula;
	
	@Column(name="pico_placa_flo")
	private String picoPlaca;
	
	@Column(name="mantenimiento_flo")
	private Date mantenimiento;
	
	@Column(name="estado_flo")
	private String estado;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="id_emp")
	private Empresa empresa;

/*	//bi-directional many-to-one association to Ruta
	@ManyToOne
	@JoinColumn(name="id_rut")
	private Ruta ruta;
*/
	//bi-directional many-to-one association to Mantenimiento
	@OneToMany(mappedBy="flota",fetch=FetchType.LAZY)
	private List<Mantenimiento> mantenimientos;

	//bi-directional many-to-one association to Seguro
	@OneToMany(mappedBy="flota",fetch=FetchType.LAZY)
	private List<Seguro> seguros;
	
	//bi-directional many-to-one association to FlotaReinting
			@OneToMany(mappedBy="flota",fetch=FetchType.LAZY)
			private List<FlotaRenting> flotaReintings;

	public Flota() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnioFabricacion() {
		return anioFabricacion;
	}

	
	public void setAnioFabricacion(String anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}
	public String getPicoPlaca() {
		return picoPlaca;
	}

	
	public void setPicoPlaca(String picoPlaca) {
		this.picoPlaca = picoPlaca;
	}
	public Date getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(Date fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}
	public Date getMantenimiento() {
		return fechaMatricula;
	}

	public void setMantenimiento(Date mantenimiento) {
		this.mantenimiento = mantenimiento;
	}
	public double getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getCpn() {
		return cpn;
	}

	public void setCpn(String cpn) {
		this.cpn = cpn;
	}

	public Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}

	public void setFechaAdquisicion(Date fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Empresa getEmpresa() {
		
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

/*	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}*/

	public List<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}

	public void setMantenimientos(List<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}

	public Mantenimiento addMantenimiento(Mantenimiento mantenimiento) {
		getMantenimientos().add(mantenimiento);
		mantenimiento.setFlota(this);

		return mantenimiento;
	}

	public Mantenimiento removeMantenimiento(Mantenimiento mantenimiento) {
		getMantenimientos().remove(mantenimiento);
		mantenimiento.setFlota(null);

		return mantenimiento;
	}

	public List<Seguro> getSeguros() {
		return this.seguros;
	}

	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}

	public Seguro addSeguro(Seguro seguro) {
		getSeguros().add(seguro);
		seguro.setFlota(this);

		return seguro;
	}

	public Seguro removeSeguro(Seguro seguro) {
		getSeguros().remove(seguro);
		seguro.setFlota(null);

		return seguro;
	}
	
	public List<FlotaRenting> getFlotaReintings() {
		return this.flotaReintings;
	}

	public void setFlotaReintings(List<FlotaRenting> flotaReintings) {
		this.flotaReintings = flotaReintings;
	}

	public FlotaRenting addFlotaReinting(FlotaRenting flotaReinting) {
		getFlotaReintings().add(flotaReinting);
		flotaReinting.setFlota(this);

		return flotaReinting;
	}

	public FlotaRenting removeFlotaReinting(FlotaRenting flotaReinting) {
		getFlotaReintings().remove(flotaReinting);
		flotaReinting.setFlota(null);

		return flotaReinting;
	}

}