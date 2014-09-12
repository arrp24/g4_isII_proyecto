package com.ls.gestion.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * The persistent class for the rol database table.
 */
@Entity
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ls_rol_id")
    private String id;

    @Column(name = "ls_rol_descripcion")
    private String descripcion;

    @Temporal(TemporalType.DATE)
    @Column(name = "ls_rol_fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "ls_rol_modificado_por")
    private Integer modificadoPor;

    // bi-directional many-to-one association to OpcionMenuPorRol
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<OpcionMenuPorRol> opcionMenuPorRol;

    // bi-directional many-to-one association to RolPorUsuario
    @OneToMany(mappedBy = "rol")
    private List<RolPorUsuario> rolPorUsuario;

    public Rol() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(Integer modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public List<OpcionMenuPorRol> getOpcionMenuPorRol() {
        return this.opcionMenuPorRol;
    }

    public void setOpcionMenuPorRol(List<OpcionMenuPorRol> opcionMenuPorRols) {
        this.opcionMenuPorRol = opcionMenuPorRols;
    }

    public OpcionMenuPorRol addOpcionMenuPorRol(OpcionMenuPorRol opcionMenuPorRol) {
        getOpcionMenuPorRol().add(opcionMenuPorRol);
        opcionMenuPorRol.setRol(this);

        return opcionMenuPorRol;
    }

    public OpcionMenuPorRol removeOpcionMenuPorRol(OpcionMenuPorRol opcionMenuPorRol) {
        getOpcionMenuPorRol().remove(opcionMenuPorRol);
        opcionMenuPorRol.setRol(null);

        return opcionMenuPorRol;
    }

    public List<RolPorUsuario> getRolPorUsuario() {
        return this.rolPorUsuario;
    }

    public void setRolPorUsuario(List<RolPorUsuario> rolPorUsuario) {
        this.rolPorUsuario = rolPorUsuario;
    }

    public RolPorUsuario addRolPorUsuario(RolPorUsuario rolPorUsuario) {
        getRolPorUsuario().add(rolPorUsuario);
        rolPorUsuario.setRol(this);

        return rolPorUsuario;
    }

    public RolPorUsuario removeRolPorUsuario(RolPorUsuario rolPorUsuario) {
        getRolPorUsuario().remove(rolPorUsuario);
        rolPorUsuario.setRol(null);

        return rolPorUsuario;
    }

    @Override
    public boolean equals(Object obj) {
        boolean retorno = false;
        try {
            if (this == obj)
                retorno = true;

            Rol param = (Rol) obj;

            if (param.getId().equals(this.getId()))
                retorno = true;
        } catch (Exception e) {
        }
        return retorno;
    }

}