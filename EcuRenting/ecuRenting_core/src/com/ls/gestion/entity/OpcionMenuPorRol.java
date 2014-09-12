package com.ls.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.ls.gestion.entity.pk.OpcionMenuPorRolPK;

/**
 * The persistent class for the opcion_menu_por_rol database table.
 */
@Entity
@Table(name = "opcion_menu_por_rol")
public class OpcionMenuPorRol implements Serializable, Comparable<OpcionMenuPorRol> {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OpcionMenuPorRolPK id;

    // bi-directional many-to-one association to OpcionMenu
    @ManyToOne
    @JoinColumn(name = "ls_opcmen_id", insertable = false, updatable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    private OpcionMenu opcionMenu;

    // bi-directional many-to-one association to Rol
    @ManyToOne
    @JoinColumn(name = "ls_rol_id", insertable = false, updatable = false)
    private Rol rol;

    @Column(name = "ls_opcmen_rol_modificado_por")
    private Integer modificadoPor;

    @Transient
    private Boolean asignado;

    public Boolean getAsignado() {
        return asignado;
    }

    public void setAsignado(Boolean asignado) {
        this.asignado = asignado;
    }

    public OpcionMenuPorRol() {
        // Constructor
    }

    public OpcionMenuPorRolPK getId() {
        return id;
    }

    public void setId(OpcionMenuPorRolPK id) {
        this.id = id;
    }

    public OpcionMenu getOpcionMenu() {
        return opcionMenu;
    }

    public void setOpcionMenu(OpcionMenu opcionMenu) {
        this.opcionMenu = opcionMenu;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Integer getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(Integer modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    @Override
    public int compareTo(OpcionMenuPorRol menuAComparar) {
        int retorno = 0;
        int propio = this.getOpcionMenu().getOrdenDespliegue();
        int parametro = menuAComparar.getOpcionMenu().getOrdenDespliegue();
        if (propio > parametro) {
            retorno = 1;
        } else if (propio < parametro) {
            retorno = -1;
        }
        return retorno;
    }

}