package com.ls.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ruta database table.
 * 
 */
@Entity
@NamedQuery(name = "Ruta.findAll", query = "SELECT d FROM Ruta d")

public class Ruta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_rut", unique = true, nullable = false)
	private Integer id;

	@Column(name="descripcion_rut")
	private String descripcion;

	@Column(name="punto_fin_rut")
	private String puntoFin;

	@Column(name="punto_inicio_rut")
	private String puntoInicio;

	@Column(name="url_img_rut")
	private String urlImg;
/*
	//bi-directional many-to-one association to Flota
	@OneToMany(mappedBy="ruta",fetch=FetchType.LAZY)
	private List<Flota> flotas;*/

	public Ruta() {
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

	public String getPuntoFin() {
		return puntoFin;
	}

	public void setPuntoFin(String puntoFin) {
		this.puntoFin = puntoFin;
	}

	public String getPuntoInicio() {
		return puntoInicio;
	}

	public void setPuntoInicio(String puntoInicio) {
		this.puntoInicio = puntoInicio;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

/*	public List<Flota> getFlotas() {
		return this.flotas;
	}

	public void setFlotas(List<Flota> flotas) {
		this.flotas = flotas;
	}
*/
/*	public Flota addFlota(Flota flota) {
		getFlotas().add(flota);
		flota.setRuta(this);

		return flota;
	}

	public Flota removeFlota(Flota flota) {
		getFlotas().remove(flota);
		flota.setRuta(null);

		return flota;
	}*/

}