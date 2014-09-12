package com.ls.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ubicacion_inventario database table.
 * 
 */
@Entity
@Table(name="ubicacion_inventario")
public class UbicacionInventario implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tag", unique=true, nullable=false)
	private String id_tag;
	
	@Column(name="columna")
	private String columna;

	@Column(name="estado")
	private Boolean estado;
	
	@Column(name="nivel")
	private Integer nivel;
	
	@Column(name="profundidad")
	private Integer profundidad;

	public UbicacionInventario() {
	}
	
	public UbicacionInventario(String id_tag, String columna, boolean estado, int nivel, int profundidad) {
		this.id_tag = id_tag;
		this.columna = columna;
		this.estado = estado;
		this.nivel = nivel;
		this.profundidad = profundidad;
	}

	public String getIdTag() {
		return this.id_tag;
	}

	public void setIdTag(String id_tag) {
		this.id_tag = id_tag;
	}

	public String getColumna() {
		return this.columna;
	}

	public void setColumna(String columna) {
		this.columna = columna;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Integer getNivel() {
		return this.nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Integer getProfundidad() {
		return this.profundidad;
	}

	public void setProfundidad(Integer profundidad) {
		this.profundidad = profundidad;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_tag == null) ? 0 : id_tag.hashCode());
        result = prime * result + ((columna == null) ? 0 : columna.hashCode());
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
        result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
        result = prime * result + ((profundidad == null) ? 0 : profundidad.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UbicacionInventario other = (UbicacionInventario) obj;
        if (id_tag == null) {
            if (other.id_tag!= null)
                return false;
        } else if (!id_tag.equals(other.id_tag))
            return false;
        if (columna == null) {
            if (other.columna != null)
                return false;
        } else if (!columna.equals(other.columna))
            return false;
        if (estado == null) {
            if (other.estado != null)
                return false;
        } else if (!estado.equals(other.estado))
            return false;
        if (nivel == null) {
            if (other.nivel != null)
                return false;
        } else if (!nivel.equals(other.nivel))
            return false;
        if (profundidad == null) {
            if (other.profundidad != null)
                return false;
        } else if (!profundidad.equals(other.profundidad))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return id_tag;
    }
 
    public int compareTo(UbicacionInventario ubicacionInventario) {
        return this.getIdTag().compareTo(ubicacionInventario.getIdTag());
    }

}