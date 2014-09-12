package com.ls.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.ls.gestion.entity.pk.FlotaReintingPK;


/**
 * The persistent class for the flota_reinting database table.
 * 
 */
@Entity
@Table(name="flota_reinting")
public class FlotaRenting implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FlotaReintingPK id;

	//bi-directional many-to-one association to Flota
	@ManyToOne
	@JoinColumn(name="id_flo", nullable=false, insertable=false, updatable=false)
	private Flota flota;

	//bi-directional many-to-one association to Renting
	@ManyToOne
	@JoinColumn(name="id_ren", nullable=false, insertable=false, updatable=false)
	private Renting renting;

	public FlotaRenting() {
	}

	public FlotaReintingPK getId() {
		return this.id;
	}

	public void setId(FlotaReintingPK id) {
		this.id = id;
	}

	public Flota getFlota() {
		return this.flota;
	}

	public void setFlota(Flota flota) {
		this.flota = flota;
	}

	public Renting getRenting() {
		return this.renting;
	}

	public void setRenting(Renting renting) {
		this.renting = renting;
	}

}