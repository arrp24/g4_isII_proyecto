package com.ls.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the pregunta database table.
 * 
 */
@Entity
@Table(name="pregunta")
public class Pregunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pre", unique = true, nullable = false)
	private Integer id;

	@Column(name="descripcion_pre")
	private String descripcion;

	//bi-directional many-to-one association to PreguntaPorUsuario
	@OneToMany(mappedBy="pregunta",fetch=FetchType.LAZY)
	private List<PreguntaPorUsuario> preguntaPorUsuarios;

	public Pregunta() {
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

	public List<PreguntaPorUsuario> getPreguntaPorUsuarios() {
		return this.preguntaPorUsuarios;
	}

	public void setPreguntaPorUsuarios(List<PreguntaPorUsuario> preguntaPorUsuarios) {
		this.preguntaPorUsuarios = preguntaPorUsuarios;
	}

	public PreguntaPorUsuario addPreguntaPorUsuario(PreguntaPorUsuario preguntaPorUsuario) {
		getPreguntaPorUsuarios().add(preguntaPorUsuario);
		preguntaPorUsuario.setPregunta(this);

		return preguntaPorUsuario;
	}

	public PreguntaPorUsuario removePreguntaPorUsuario(PreguntaPorUsuario preguntaPorUsuario) {
		getPreguntaPorUsuarios().remove(preguntaPorUsuario);
		preguntaPorUsuario.setPregunta(null);

		return preguntaPorUsuario;
	}



}