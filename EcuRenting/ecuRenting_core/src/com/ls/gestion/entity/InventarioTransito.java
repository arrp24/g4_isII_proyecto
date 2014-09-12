package com.ls.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the inventario_transito database table.
 * 
 */
@Entity
@Table(name="inventario_transito")
public class InventarioTransito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_inv_transito", unique=true, nullable=false)
	private Integer id_inv_transito;

	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="medida")
	private Integer medida;

	@Column(name="num_packete")
	private Integer num_packete;

	@Column(name="orden_pedido")
	private Integer orden_pedido;

	@Column(name="tipo")
	private String tipo;

	@Column(name="uni_media")
	private String uni_medida;
	
	@Column(name="id_cliente")
	private String id_cliente;
	
	@Column(name="volumen")
	private Double volumen;

	@Column(name="peso")
	private Double peso;
	
	@Column(name="estado")
	private String estado;

	public InventarioTransito() {		
	}

	public Integer getId() {
		return id_inv_transito;
	}

	public void setId(Integer id_inv_transito) {
		this.id_inv_transito = id_inv_transito;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getMedida() {
		return medida;
	}

	public void setMedida(Integer medida) {
		this.medida = medida;
	}

	public Integer getNumPackete() {
		return num_packete;
	}

	public void setNumPackete(Integer num_packete) {
		this.num_packete = num_packete;
	}

	public Integer getOrdenPedido() {
		return orden_pedido;
	}

	public void setOrdenPedido(Integer orden_pedido) {
		this.orden_pedido = orden_pedido;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUniMedia() {
		return uni_medida;
	}

	public void setUniMedia(String uni_medida) {
		this.uni_medida = uni_medida;
	}
	
	public String getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	public Double getVolumen() {
		return volumen;
	}

	public void setVolumen(Double volumen) {
		this.volumen = volumen;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

	
}