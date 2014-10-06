/*
 * Copyright 2013 LIBRESOFT S.A. - ECUADOR 
 * Todos los derechos reservados
 */

package com.ls.gestion.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * <b> Clase de Persistencia para el log de logeo al sistema. </b>
 * 
 * @author joselo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: joselo $, $Date: 08/08/2013 $]
 *          </p>
 */
@Entity
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ls_log_id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ls_log_usu_id")
    private Usuario usuario;

    @Column(name = "ls_log_nombre_usuario")
    private String nombreUsuario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ls_log_fecha_hora_acceso")
    private Date fechaHoraAcceso;

    @Column(name = "ls_log_exitoso")
    private Boolean exitoso;

    /**
     * Constructor Vacio de la clase.
     */
    public Log() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getExitoso() {
        return exitoso;
    }

    public void setExitoso(Boolean exitoso) {
        this.exitoso = exitoso;
    }

    public Date getFechaHoraAcceso() {
        return fechaHoraAcceso;
    }

    public void setFechaHoraAcceso(Date fechaHoraAcceso) {
        this.fechaHoraAcceso = fechaHoraAcceso;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}