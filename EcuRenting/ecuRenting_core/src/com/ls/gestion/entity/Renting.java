package com.ls.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the renting database table.
 * 
 */
@Entity
@Table(name="renting")
public class Renting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ren", unique=true, nullable=false)
	private Integer idRen;

	@Column(name="codigo_ren")
	private String codigoRen;

	@Column(name="descripcion_ren")
	private String descripcionRen;

	@Column(name="empresa_ren")
	private Integer empresaRen;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_ren")
	private Date fechaFinRen;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ren")
	private Date fechaRen;

	@Column(name="subtotal_ren")
	private BigDecimal subtotalRen;

	@Column(name="valor__total_ren")
	private BigDecimal valorTotalRen;

	//bi-directional many-to-one association to FlotaReinting
	@OneToMany(mappedBy="renting",fetch=FetchType.LAZY)
	private List<FlotaRenting> flotaReintings;
	
/*	//bi-directional many-to-one association to Renting
		@ManyToOne
		@JoinColumn(name="id_emp")
		private Empresa empresa;*/

	public Renting() {
	}

	public Integer getIdRen() {
		return this.idRen;
	}

	public void setIdRen(Integer idRen) {
		this.idRen = idRen;
	}

	public String getCodigoRen() {
		return this.codigoRen;
	}

	public void setCodigoRen(String codigoRen) {
		this.codigoRen = codigoRen;
	}

	public String getDescripcionRen() {
		return this.descripcionRen;
	}

	public void setDescripcionRen(String descripcionRen) {
		this.descripcionRen = descripcionRen;
	}

	public Integer getEmpresaRen() {
		return this.empresaRen;
	}

	public void setEmpresaRen(Integer empresaRen) {
		this.empresaRen = empresaRen;
	}

	public Date getFechaFinRen() {
		return this.fechaFinRen;
	}

	public void setFechaFinRen(Date fechaFinRen) {
		this.fechaFinRen = fechaFinRen;
	}

	public Date getFechaRen() {
		return this.fechaRen;
	}

	public void setFechaRen(Date fechaRen) {
		this.fechaRen = fechaRen;
	}

	public BigDecimal getSubtotalRen() {
		return this.subtotalRen;
	}

	public void setSubtotalRen(BigDecimal subtotalRen) {
		this.subtotalRen = subtotalRen;
	}

	public BigDecimal getValorTotalRen() {
		return this.valorTotalRen;
	}

	public void setValorTotalRen(BigDecimal valorTotalRen) {
		this.valorTotalRen = valorTotalRen;
	}

	public List<FlotaRenting> getFlotaReintings() {
		return this.flotaReintings;
	}

	public void setFlotaReintings(List<FlotaRenting> flotaReintings) {
		this.flotaReintings = flotaReintings;
	}

	public FlotaRenting addFlotaReinting(FlotaRenting flotaReinting) {
		getFlotaReintings().add(flotaReinting);
		flotaReinting.setRenting(this);

		return flotaReinting;
	}

	public FlotaRenting removeFlotaReinting(FlotaRenting flotaReinting) {
		getFlotaReintings().remove(flotaReinting);
		flotaReinting.setRenting(null);

		return flotaReinting;
	}

}