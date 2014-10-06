package com.ls.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;

@Entity

@NamedQuery(name = "Empresa.findAll", query = "SELECT d FROM Empresa d")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_emp")
	private Integer id;

	@Column(name="direccion_emp")
	private String direccion;

	@Column(name="nombre_emp")
	private String nombre;

	@Column(name="telefono_emp")
	private String telefono;

	//bi-directional many-to-one association to Chofer
	@OneToMany(mappedBy="empresa",fetch=FetchType.LAZY)
	private List<Chofer> choferes;

	//bi-directional many-to-one association to Flota
	@OneToMany(mappedBy="empresa",fetch=FetchType.LAZY)
	private List<Flota> flotas;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="empresa",fetch=FetchType.LAZY)
	private List<Usuario> usuarios;
	
/*	//bi-directional many-to-one association to Renting
	@OneToMany(mappedBy="empresa",fetch=FetchType.LAZY)
	private List<Renting> rentings;*/

	public Empresa() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Chofer> getChoferes() {
		return choferes;
	}

	public void setChoferes(List<Chofer> choferes) {
		this.choferes = choferes;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Chofer addChofer(Chofer chofer) {
		getChoferes().add(chofer);
		chofer.setEmpresa(this);

		return chofer;
	}

	public Chofer removeChofer(Chofer chofer) {
		getChoferes().remove(chofer);
		chofer.setEmpresa(null);
		return chofer;
	}

	/*public List<Renting> getRentings() {
		return rentings;
	}

	public void setRentings(List<Renting> rentings) {
		this.rentings = rentings;
	}

	*/
	public List<Flota> getFlotas() {
		return this.flotas;
	}

	public void setFlotas(List<Flota> flotas) {
		this.flotas = flotas;
	}

	public Flota addFlota(Flota flota) {
		getFlotas().add(flota);
		flota.setEmpresa(this);

		return flota;
	}

	public Flota removeFlota(Flota flota) {
		getFlotas().remove(flota);
		flota.setEmpresa(null);

		return flota;
	}
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
 
    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Empresa)) {
            return false;
        }
       Empresa other = (Empresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}