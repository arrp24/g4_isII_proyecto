package com.web.backing;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage

import com.ls.gestion.entity.Usuario;
import com.ls.gestion.service.UsuarioServicioLocal;

@ManagedBean(name = "usuarioBacking")
@ViewScoped
public class UsuarioBacking implements Serializable {

    @EJB
    private UsuarioServicioLocal usuarioServicio;

    private List<Usuario> usuarios;
    private Usuario usuario;
    private Usuario selectedUsuario;

    public UsuarioBacking() {   
        this.usuario = new Usuario();
    }

    @PostConstruct
    public void init() {   	
        this.usuarios = usuarioServicio.getAll();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
        obtenerDualListModel();
    }
    
    public void crearUsuario() {
        usuarioServicio.crearUsuario(usuario);
        usuario = new Usuario();
        usuarios = usuarioServicio.getAll();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Creación Exitosa",
                "Se ha creado un nuevo Usuario exitosamente!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void actualizarUsuario() {
        usuarioServicio.actualizarUsuario(this.selectedUsuario);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización Exitosa",
                "Se ha actualizado exitosamente el usuario \"" + this.selectedUsuario.getNombre() + "\"");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.selectedUsuario = null;
    }

    public void eliminarUsuario() {
        
    }
}
