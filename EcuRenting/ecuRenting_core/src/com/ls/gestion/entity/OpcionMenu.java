package com.ls.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the opcion_menu database table.
 * 
 */
@Entity
@Table(name="opcion_menu")
public class OpcionMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ls_opcmen_id")
	private String id;

	@Column(name="ls_opcmen_etiqueta")
	private String etiqueta;

	@Column(name="ls_opcmen_nivel_opcion")
	private Integer nivelOpcion;

	@Column(name="ls_opcmen_oden_despliegue")
	private Integer ordenDespliegue;

	@Column(name="ls_opcmen_texto_ayuda")
	private String textoAyuda;

	@Column(name="ls_opcmen_url")
	private String url;

	//bi-directional many-to-one association to OpcionMenu
	@ManyToOne
	@JoinColumn(name="ls_opcmen_padre_id")
	private OpcionMenu padre;

	//bi-directional many-to-one association to OpcionMenu
	@OneToMany(mappedBy="padre", fetch=FetchType.EAGER)
	private List<OpcionMenu> hijos;

	//bi-directional many-to-one association to OpcionesMenuPorRol
	@OneToMany(mappedBy="opcionMenu", fetch=FetchType.LAZY)
	private List<OpcionMenuPorRol> opcionesMenuPorRol;

	public OpcionMenu() {
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Integer getNivelOpcion() {
        return nivelOpcion;
    }

    public void setNivelOpcion(Integer nivelOpcion) {
        this.nivelOpcion = nivelOpcion;
    }

    public Integer getOrdenDespliegue() {
        return ordenDespliegue;
    }

    public void setOrdenDespliegue(Integer ordenDespliegue) {
        this.ordenDespliegue = ordenDespliegue;
    }

    public String getTextoAyuda() {
        return textoAyuda;
    }

    public void setTextoAyuda(String textoAyuda) {
        this.textoAyuda = textoAyuda;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public OpcionMenu getPadre() {
        return padre;
    }

    public void setPadre(OpcionMenu padre) {
        this.padre = padre;
    }

    public List<OpcionMenu> getHijos() {
        return hijos;
    }

    public void setHijos(List<OpcionMenu> hijos) {
        this.hijos = hijos;
    }

    public List<OpcionMenuPorRol> getOpcionesMenuPorRol() {
        return opcionesMenuPorRol;
    }

    public void setOpcionesMenuPorRol(List<OpcionMenuPorRol> opcionesMenuPorRol) {
        this.opcionesMenuPorRol = opcionesMenuPorRol;
    }
    
    public OpcionMenu addHijo(OpcionMenu opcionMenu) {
        getHijos().add(opcionMenu);
        opcionMenu.setPadre(this);
        return opcionMenu;
    }

    public OpcionMenu removeHijo(OpcionMenu opcionMenu) {
        getHijos().remove(opcionMenu);
        opcionMenu.setPadre(null);
        return opcionMenu;
    }

    public OpcionMenuPorRol addOpcionesMenuPorRol(OpcionMenuPorRol opcionesMenuPorRol) {
        getOpcionesMenuPorRol().add(opcionesMenuPorRol);
        opcionesMenuPorRol.setOpcionMenu(this);

        return opcionesMenuPorRol;
    }

    public OpcionMenuPorRol removeOpcionesMenuPorRol(OpcionMenuPorRol opcionesMenuPorRol) {
        getOpcionesMenuPorRol().remove(opcionesMenuPorRol);
        opcionesMenuPorRol.setOpcionMenu(null);

        return opcionesMenuPorRol;
    }

}