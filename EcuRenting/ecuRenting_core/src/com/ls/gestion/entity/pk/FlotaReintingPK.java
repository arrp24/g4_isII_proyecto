package com.ls.gestion.entity.pk;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the flota_reinting database table.
 * 
 */
@Embeddable
public class FlotaReintingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_flo", unique=true, nullable=false)
	private Integer idFlo;

	@Column(name="id_ren", unique=true, nullable=false)
	private Integer idRen;

	@Column(name="id_flo_ren", unique=true, nullable=false)
	private Integer idFloRen;

	public FlotaReintingPK() {
	}
	public Integer getIdFlo() {
		return this.idFlo;
	}
	public void setIdFlo(Integer idFlo) {
		this.idFlo = idFlo;
	}
	public Integer getIdRen() {
		return this.idRen;
	}
	public void setIdRen(Integer idRen) {
		this.idRen = idRen;
	}
	public Integer getIdFloRen() {
		return this.idFloRen;
	}
	public void setIdFloRen(Integer idFloRen) {
		this.idFloRen = idFloRen;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FlotaReintingPK)) {
			return false;
		}
		FlotaReintingPK castOther = (FlotaReintingPK)other;
		return 
			this.idFlo.equals(castOther.idFlo)
			&& this.idRen.equals(castOther.idRen)
			&& this.idFloRen.equals(castOther.idFloRen);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idFlo.hashCode();
		hash = hash * prime + this.idRen.hashCode();
		hash = hash * prime + this.idFloRen.hashCode();
		
		return hash;
	}
}