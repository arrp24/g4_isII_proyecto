package com.ls.gestion.entity.pk;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rol_por_usuario database table.
 */
@Embeddable
public class RolPorUsuarioPK implements Serializable {
    // default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;
    @Column(name = "ls_rol_usu_usu_id")
    private Integer usuarioId;

    @Column(name = "ls_rol_usu_rol_id")
    private String rolId;

    public RolPorUsuarioPK() {
    }

    public Integer getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(Integer id) {
        this.usuarioId = id;
    }

    public String getRolId() {
        return this.rolId;
    }

    public void setRolId(String lsRolId) {
        this.rolId = lsRolId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RolPorUsuarioPK)) {
            return false;
        }
        RolPorUsuarioPK castOther = (RolPorUsuarioPK) other;
        return this.usuarioId.equals(castOther.usuarioId)
                && this.rolId.equals(castOther.rolId);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.usuarioId.hashCode();
        hash = hash * prime + this.rolId.hashCode();

        return hash;
    }
}