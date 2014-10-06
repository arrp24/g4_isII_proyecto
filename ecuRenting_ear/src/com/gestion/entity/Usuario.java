package com.ls.gestion.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the usuario database table.
 */
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ls_usu_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "ls_usu_cedula")
    private String cedula;

    @Column(name = "ls_usu_nombre")
    private String nombre;

    @Column(name = "ls_usu_telefono")
    private String telefono;

    @Column(name = "ls_usu_mail")
    private String mail;

    @Column(name = "ls_usu_costo_hombre")
    private BigDecimal costoHombre;

    @Column(name = "ls_usu_fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "ls_usu_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @Column(name = "ls_usu_demarcacion")
    private String demarcacion;

    @Column(name = "ls_usu_departamento")
    private String departamento;

    @Column(name = "ls_usu_modificado_por")
    private Integer modificadoPor;

    // bi-directional many-to-one association to Auditoria
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Auditoria> auditorias;

    // bi-directional many-to-one association to Log
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Log> logs;

    // bi-directional many-to-one association to RolPorUsuario
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<RolPorUsuario> rolPorUsuarios;

  //bi-directional many-to-one association to PreguntaPorUsuario
  	@OneToMany(mappedBy="usuario")
  	private List<PreguntaPorUsuario> preguntaPorUsuarios;
  	
  //bi-directional many-to-one association to Empresa
  	@ManyToOne
  	@JoinColumn(name="id_emp")
  	private Empresa empresa;


    public Usuario() {
    }

    public boolean tieneRoles() {
        return this.rolPorUsuarios.isEmpty() ? false : true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public BigDecimal getCostoHombre() {
        return costoHombre;
    }

    public void setCostoHombre(BigDecimal costoHombre) {
        this.costoHombre = costoHombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDemarcacion() {
        return demarcacion;
    }

    public void setDemarcacion(String demarcacion) {
        this.demarcacion = demarcacion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Integer getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(Integer modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public List<Auditoria> getAuditorias() {
        return auditorias;
    }

    public void setAuditorias(List<Auditoria> auditorias) {
        this.auditorias = auditorias;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }

   
    public List<RolPorUsuario> getRolPorUsuarios() {
        return rolPorUsuarios;
    }

    public void setRolPorUsuarios(List<RolPorUsuario> rolPorUsuarios) {
        this.rolPorUsuarios = rolPorUsuarios;
    }
    

    public List<PreguntaPorUsuario> getPreguntaPorUsuarios() {
		return preguntaPorUsuarios;
	}

	public void setPreguntaPorUsuarios(List<PreguntaPorUsuario> preguntaPorUsuarios) {
		this.preguntaPorUsuarios = preguntaPorUsuarios;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Auditoria addAuditoria(Auditoria auditoria) {
        getAuditorias().add(auditoria);
        auditoria.setUsuario(this);

        return auditoria;
    }

    public Auditoria removeAuditoria(Auditoria auditoria) {
        getAuditorias().remove(auditoria);
        auditoria.setUsuario(null);

        return auditoria;
    }

    public Log addLog(Log log) {
        getLogs().add(log);
        log.setUsuario(this);

        return log;
    }

    public Log removeLog(Log log) {
        getLogs().remove(log);
        log.setUsuario(null);

        return log;
    }

  
    public RolPorUsuario addRolPorUsuario(RolPorUsuario rolPorUsuario) {
        getRolPorUsuarios().add(rolPorUsuario);
        rolPorUsuario.setUsuario(this);

        return rolPorUsuario;
    }

    public RolPorUsuario removeRolPorUsuario(RolPorUsuario rolPorUsuario) {
        getRolPorUsuarios().remove(rolPorUsuario);
        rolPorUsuario.setUsuario(null);

        return rolPorUsuario;
    }

    }