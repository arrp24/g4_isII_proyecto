package com.ls.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.ls.gestion.entity.pk.PreguntaPorUsuarioPK;


/**
 * The persistent class for the pregunta_por_usuario database table.
 * 
 */
@Entity
@Table(name="pregunta_por_usuario")
public class PreguntaPorUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PreguntaPorUsuarioPK id;

	@Column(name="respuesta_pre")
	private String respuesta;

	//bi-directional many-to-one association to Pregunta
	@ManyToOne
	@JoinColumn(name="id_pre",insertable = false, updatable = false)
	private Pregunta pregunta;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usu",insertable = false, updatable = false)
	private Usuario usuario;

	public PreguntaPorUsuario() {
	}

	public PreguntaPorUsuarioPK getId() {
		return this.id;
	}

	public void setId(PreguntaPorUsuarioPK id) {
		this.id = id;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Pregunta getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



}