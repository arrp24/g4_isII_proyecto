package com.ls.gestion.web.backing;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ls.gestion.entity.Rol;
import com.ls.gestion.entity.RolPorUsuario;
import com.ls.gestion.entity.Usuario;
import com.ls.gestion.service.RolPorUsuarioServicioLocal;
import com.ls.gestion.service.UsuarioServicioLocal;

@ManagedBean
@ViewScoped
public class RolPorUsuarioBacking implements Serializable {

    private static final long serialVersionUID = 5297201599173897134L;

    @ManagedProperty(value = "#{authenticationBacking}")
    private AuthenticationBacking authenticationBacking;

    @EJB
    private RolPorUsuarioServicioLocal rolPorUsuarioServicio;

    @EJB
    private UsuarioServicioLocal usuarioServicio;

    private List<Rol> rolPorUsuario;
    private Usuario selectedUsuario;
    private RolPorUsuario selectedRolPorUsuario;
    private String selectedClave;

    public RolPorUsuarioBacking() {
        this.setSelectedUsuario(new Usuario());
        this.setSelectedRolPorUsuario(new RolPorUsuario());
    }

    @PostConstruct
    public void init() {
    }

    public void setAuthenticationBacking(AuthenticationBacking authenticationBacking) {
        this.authenticationBacking = authenticationBacking;
    }

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    public RolPorUsuario getSelectedRolPorUsuario() {
        return selectedRolPorUsuario;
    }

    public void setSelectedRolPorUsuario(RolPorUsuario selectedRolPorUsuario) {
        this.selectedRolPorUsuario = selectedRolPorUsuario;
    }

    public String getSelectedClave() {
        return selectedClave;
    }

    public void setSelectedClave(String selectedClave) {
        this.selectedClave = selectedClave;
    }

    public List<Rol> getRolPorUsuario() {
        return rolPorUsuario;
    }

    public void setRolPorUsuario(List<Rol> rolPorUsuario) {
        this.rolPorUsuario = rolPorUsuario;
    }

    public void actualizarDetalleRolPorUsuario() {

        // Se verifica el asunto de claves para ver que no se pierda la info
        // Caso contrario se encripta la nueva contraseña
        if ("".equals(this.selectedRolPorUsuario.getClave())) {
            this.selectedRolPorUsuario.setClave(this.selectedClave);
        } else {
            this.selectedRolPorUsuario.setClave(AuthenticationBacking.md5(this.selectedRolPorUsuario.getClave()));
        }

        // Se setea el usuario que modifico el registro
        this.selectedRolPorUsuario.setModificadoPor(authenticationBacking.getRolPorUsuarioActual().getId()
                .getUsuarioId());

        rolPorUsuarioServicio.actualizarRolPorUsuario(this.selectedRolPorUsuario);

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención",
                "Se guardó exitosamente el detalle del rol <b>\"" + this.selectedRolPorUsuario.getId().getRolId()
                        + "\"</b> para el usuario <b>" + this.selectedRolPorUsuario.getUsuario().getNombre() + "</b>");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
