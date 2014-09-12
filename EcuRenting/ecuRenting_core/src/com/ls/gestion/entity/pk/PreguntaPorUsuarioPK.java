package com.ls.gestion.entity.pk;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pregunta_por_usuario database table.
 * 
 */
@Embeddable
public class PreguntaPorUsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ls_usu_id")
	private Integer lsUsuId;

	@Column(name="id_pre")
	private Integer idPre;

	public PreguntaPorUsuarioPK() {
	}
	public Integer getLsUsuId() {
		return this.lsUsuId;
	}
	public void setLsUsuId(Integer lsUsuId) {
		this.lsUsuId = lsUsuId;
	}
	public Integer getIdPre() {
		return this.idPre;
	}
	public void setIdPre(Integer idPre) {
		this.idPre = idPre;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PreguntaPorUsuarioPK)) {
			return false;
		}
		PreguntaPorUsuarioPK castOther = (PreguntaPorUsuarioPK)other;
		return 
			this.lsUsuId.equals(castOther.lsUsuId)
			&& this.idPre.equals(castOther.idPre);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.lsUsuId.hashCode();
		hash = hash * prime + this.idPre.hashCode();
		
		return hash;
	}
}