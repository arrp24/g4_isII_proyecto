package com.ls.gestion.entity.pk;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the opciones_menu_por_rol database table.
 * 
 */
@Embeddable
public class OpcionMenuPorRolPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ls_rol_id")
	private String rolId;

	@Column(name="ls_opcmen_id")
	private String opcmenId;

	public OpcionMenuPorRolPK() {
	}
	public String getRolId() {
		return this.rolId;
	}
	public void setRolId(String lsRolId) {
		this.rolId = lsRolId;
	}
	public String getOpcmenId() {
		return this.opcmenId;
	}
	public void setOpcmenId(String lsOpcmenId) {
		this.opcmenId = lsOpcmenId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OpcionMenuPorRolPK)) {
			return false;
		}
		OpcionMenuPorRolPK castOther = (OpcionMenuPorRolPK)other;
		return 
			this.rolId.equals(castOther.rolId)
			&& this.opcmenId.equals(castOther.opcmenId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.rolId.hashCode();
		hash = hash * prime + this.opcmenId.hashCode();
		
		return hash;
	}
}