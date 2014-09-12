package com.ls.gestion.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the auditoria database table.
 */
@Entity
@NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a")
public class Auditoria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ls_aud_id")
    private Integer id;

    @Column(name = "ls_aud_descripcion")
    private String descripcion;

    @Temporal(TemporalType.DATE)
    @Column(name = "ls_aud_fecha_transaccion")
    private Date fechaTransaccion;

    @Column(name = "ls_aud_tabla")
    private String tabla;

    @Column(name = "ls_aud_tipo_transaccion")
    private String tipoTransaccion;

    @ManyToOne
    @JoinColumn(name = "ls_aud_usu_id", insertable = false, updatable = false)
    private Usuario usuario;

    @Column(name = "ls_aud_usuario_bdd")
    private String usuarioBdd;

    public Auditoria() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getUsuarioBdd() {
        return usuarioBdd;
    }

    public void setUsuarioBdd(String usuarioBdd) {
        this.usuarioBdd = usuarioBdd;
    }

}