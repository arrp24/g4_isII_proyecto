package com.ls.gestion.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.ls.gestion.entity.pk.RolPorUsuarioPK;

import java.util.Date;

/**
 * The persistent class for the rol_por_usuario database table.
 */
@Entity
@Table(name = "rol_por_usuario")
public class RolPorUsuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private RolPorUsuarioPK id;

    @Column(name = "ls_rol_usu_modificado_por")
    private Integer modificadoPor;

    @Column(name = "ls_rol_usu_clave")
    private String clave;

    @Column(name = "ls_rol_usu_estado")
    private String estado;

    @Temporal(TemporalType.DATE)
    @Column(name = "ls_rol_usu_inicio_vigencia")
    private Date fechaInicioVigencia;

    @Transient
    private Boolean asignado;

    // bi-directional many-to-one association to Rol
    @ManyToOne
    @JoinColumn(name = "ls_rol_usu_rol_id", insertable = false, updatable = false)
    private Rol rol;

    // bi-directional many-to-one association to Usuario
    @ManyToOne
    @JoinColumn(name = "ls_rol_usu_usu_id", insertable = false, updatable = false)
    private Usuario usuario;

    public RolPorUsuario() {
        // Constructor
    }

    public Boolean getAsignado() {
        return asignado;
    }

    public void setAsignado(Boolean asignado) {
        this.asignado = asignado;
    }

    public RolPorUsuarioPK getId() {
        return this.id;
    }

    public void setId(RolPorUsuarioPK id) {
        this.id = id;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaInicioVigencia() {
        return this.fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(Date fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public Rol getRol() {
        return this.rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(Integer modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    @Override
    public boolean equals(Object obj) {
        boolean retorno = false;
        try {
            if (this == obj)
                retorno = true;

            RolPorUsuario param = (RolPorUsuario) obj;

            if (param.getId().equals(this.getId()))
                retorno = true;
        } catch (Exception e) {
        }
        return retorno;
    }

}