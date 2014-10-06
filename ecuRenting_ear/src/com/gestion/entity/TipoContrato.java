package com.ls.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the pedido_entrega database table.
 * 
 */
@Entity
@Table(name="pedido_entrega")
public class PedidoEntrega implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_orden_entrega",unique=true, nullable=false)
	private Integer id_orden_entrega;
	
	@Column(name="bodega")
	private String bodega;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@Column(name="descripcion")
	private String descripcion;

	@Column(name="fecha_emplace")
	private Timestamp fecha_emplace;

	@Column(name="fecha_entrega")
	private Timestamp fecha_entrega;

	@Column(name="orden_pedido")
	private Integer orden_pedido;
	
	@Column(name="peso")
	private Double peso;

	@Column(name="peso_total_orden")
	private Double peso_total_orden;
	
	@Column(name="ubicacion")
	private String ubicacion;
	
	@Column(name="volumen")
	private Double volumen;

	@Column(name="volumen_total_orden")
	private Double volumen_total_orden;
	
	@Column(name="descrip_pedido")
	private String descrip_pedido;


	public PedidoEntrega() {
	}

	public Integer getIdOrdenEntrega() {
		return this.id_orden_entrega;
	}

	public void setIdOrdenEntrega(Integer idOrdenEntrega) {
		this.id_orden_entrega = idOrdenEntrega;
	}

	public String getBodega() {
		return this.bodega;
	}

	public void setBodega(String bodega) {
		this.bodega = bodega;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getFechaEmplace() {
		return this.fecha_emplace;
	}

	public void setFechaEmplace(Timestamp fecha_emplace) {
		this.fecha_emplace = fecha_emplace;
	}

	public Timestamp getFechaEntrega() {
		return this.fecha_entrega;
	}

	public void setFechaEntrega(Timestamp fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	public Integer getOrdenPedido() {
		return this.orden_pedido;
	}

	public void setOrdenPedido(Integer orden_pedido) {
		this.orden_pedido = orden_pedido;
	}

	public Double getPeso() {
		return this.peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getPesoTotalOrden() {
		return this.peso_total_orden;
	}

	public void setPesoTotalOrden(Double peso_total_orden) {
		this.peso_total_orden = peso_total_orden;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Double getVolumen() {
		return this.volumen;
	}

	public void setVolumen(Double volumen) {
		this.volumen = volumen;
	}

	public Double getVolumenTotalOrden() {
		return this.volumen_total_orden;
	}

	public void setVolumenTotalOrden(Double volumen_total_orden) {
		this.volumen_total_orden = volumen_total_orden;
	}
	
	public String getDescrip_pedido() {
		return descrip_pedido;
	}

	public void setDescrip_pedido(String descrip_pedido) {
		this.descrip_pedido = descrip_pedido;
	}

}