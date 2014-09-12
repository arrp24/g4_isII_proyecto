/*
 * Copyright 2013 LIBRESOFT S.A. - ECUADOR 
 * Todos los derechos reservados
 */

package com.ls.gestion.web.backing;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DualListModel;

import com.ls.gestion.entity.OpcionMenu;
import com.ls.gestion.entity.OpcionMenuPorRol;
import com.ls.gestion.entity.Rol;
import com.ls.gestion.entity.pk.OpcionMenuPorRolPK;
import com.ls.gestion.service.OpcionMenuPorRolServicioLocal;
import com.ls.gestion.service.OpcionMenuServicioLocal;
import com.ls.gestion.service.RolServicioLocal;

@ManagedBean(name = "rolBacking")
@ViewScoped
public class RolBacking implements Serializable {

    private static final long serialVersionUID = -4171368859938600826L;

    @EJB
    private RolServicioLocal rolServicioLocal;

    @EJB
    private OpcionMenuServicioLocal opcionMenuServicio;

    @EJB
    private OpcionMenuPorRolServicioLocal opcionMenuPorRolServicio;

    @ManagedProperty(value = "#{authenticationBacking}")
    private AuthenticationBacking authenticationBacking;

    private List<OpcionMenu> opcionMenus;
    private List<Rol> roles;
    private Rol rol = new Rol();
    private Rol rolEdit;
    private Rol selectedRolPermisos = new Rol();
    private DualListModel<OpcionMenu> opcionMenuPorRol = new DualListModel<OpcionMenu>();

    private String codigoSelectedRol = null;

    public RolBacking() {
        rolEdit = new Rol();
        this.setSelectedRolPermisos(new Rol());
    }

    @PostConstruct
    public void init() {
        roles = rolServicioLocal.getAll();
        this.opcionMenus = opcionMenuServicio.buscarOpcionMenu();
    }

    public List<OpcionMenu> getOpcionMenus() {
        return opcionMenus;
    }

    public void setOpcionMenus(List<OpcionMenu> opcionMenus) {
        this.opcionMenus = opcionMenus;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public Rol getRol() {
        return this.rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public RolServicioLocal getRolServicioLocal() {
        return rolServicioLocal;
    }

    public void setRolServicioLocal(RolServicioLocal rolServicioLocal) {
        this.rolServicioLocal = rolServicioLocal;
    }

    public String getCodigoSelectedRol() {
        return codigoSelectedRol;
    }

    public void setCodigoSelectedRol(String codigoSelectedRol) {
        this.codigoSelectedRol = codigoSelectedRol;
    }

    public String getFechaHoy() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date today = Calendar.getInstance().getTime();
        return df.format(today);
    }

    public Rol getRolEdit() {
        return rolEdit;
    }

    public void setRolEdit(Rol rolEdit) {
        this.rolEdit = rolEdit;
    }

    public Rol getSelectedRolPermisos() {
        return selectedRolPermisos;
    }

    public void setSelectedRolPermisos(Rol selectedRolPermisos) {
        this.selectedRolPermisos = selectedRolPermisos;
    }

    public DualListModel<OpcionMenu> getOpcionMenuPorRol() {
        return opcionMenuPorRol;
    }

    public void setOpcionMenuPorRol(DualListModel<OpcionMenu> opcionMenuPorRol) {
        this.opcionMenuPorRol = opcionMenuPorRol;
    }

    public void setAuthenticationBacking(AuthenticationBacking authenticationBacking) {
        this.authenticationBacking = authenticationBacking;
    }

    public void obtenerDualListModel() {
        List<OpcionMenu> source = opcionMenuServicio.buscarOpcionMenu();
        List<OpcionMenu> target = new ArrayList<OpcionMenu>();

        if (this.selectedRolPermisos.getOpcionMenuPorRol() != null) {
            if (!this.selectedRolPermisos.getOpcionMenuPorRol().isEmpty()) {
                for (OpcionMenuPorRol opcionMenuPorRolActual : this.selectedRolPermisos.getOpcionMenuPorRol()) {
                    target.add(opcionMenuPorRolActual.getOpcionMenu());
                }
            }
            for (OpcionMenu opcionMenuActual : target) {
                for (int i = 0; i < source.size(); i++) {
                    if (opcionMenuActual != null && source.get(i).getId().equals(opcionMenuActual.getId()))
                        source.remove(i);
                }
            }
        }
        this.opcionMenuPorRol = new DualListModel<OpcionMenu>(source, target);
        try {
            this.opcionMenus = opcionMenuServicio.buscarOpcionMenu();
        } catch (Exception e) {
        }
    }

    public String grabarOpcionMenu() {

        for (int i = 0; i < this.rol.getOpcionMenuPorRol().size(); i++) {
            if (!this.rol.getOpcionMenuPorRol().get(i).getAsignado()) {
                this.rol.getOpcionMenuPorRol().remove(this.rol.getOpcionMenuPorRol().get(i));
            }
        }
        rolServicioLocal.actualizarRol(this.rol);
        return "success";
    }

    public void crearRol() {
        rol.setFechaCreacion(new Date());
        rol.setModificadoPor(authenticationBacking.getRolPorUsuarioActual().getId().getUsuarioId());
        rolServicioLocal.crearRol(rol);
        rol = new Rol();
        roles = rolServicioLocal.getAll();

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Creación Exitosa",
                "Se ha creado un nuevo rol exitosamente!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edición Actualizada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        rolServicioLocal.actualizarRol(((Rol) event.getObject()));
    }

    public void borrarRol() {
        if (this.codigoSelectedRol != null) {
            rolServicioLocal.eliminarRol(this.codigoSelectedRol);

            roles = rolServicioLocal.getAll();

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminación Exitosa",
                    "Se ha borrado exitosamente el rol \"" + this.codigoSelectedRol + "\"");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            this.codigoSelectedRol = null;
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Selección",
                    "Ha ocurrido un error al seleccionar el rol");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void actualizarRol() {
        this.rolEdit.setModificadoPor(authenticationBacking.getRolPorUsuarioActual().getId().getUsuarioId());
        rolServicioLocal.actualizarRol(this.rolEdit);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización Exitosa",
                "Se ha actualizado exitosamente el rol \"" + this.rolEdit.getId() + "\"");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void guardarOpcionesMenuPorRol() {
        List<OpcionMenuPorRol> listaPermisosAsignados = new ArrayList<OpcionMenuPorRol>();
        for (int i = 0; i < this.opcionMenuPorRol.getTarget().size(); i++) {
            OpcionMenu opcionMenuActual = this.opcionMenuPorRol.getTarget().get(i);
            // Se crea el PK para la nueva Opcion de menu por rol
            OpcionMenuPorRolPK pkActual = new OpcionMenuPorRolPK();
            pkActual.setOpcmenId(opcionMenuActual.getId());
            pkActual.setRolId(this.selectedRolPermisos.getId());

            // Se crea la nueva opcion de menu por rol y se setea el PK
            OpcionMenuPorRol opcionMenuPorRolActual = new OpcionMenuPorRol();
            opcionMenuPorRolActual.setId(pkActual);
            // Se setea quien fue el que modifico los permisos
            opcionMenuPorRolActual.setModificadoPor(this.authenticationBacking.getRolPorUsuarioActual().getId()
                    .getUsuarioId());

            opcionMenuPorRolActual.setRol(this.selectedRolPermisos);
            opcionMenuPorRolActual.setOpcionMenu(opcionMenuActual);

            // Se grega la opcionMenuPorRol a la lista del rol
            listaPermisosAsignados.add(opcionMenuPorRolActual);
        }
        // Se setea la nueva lista de permisos en el rol
        this.selectedRolPermisos.setOpcionMenuPorRol(listaPermisosAsignados);

        // Se borra la configuración previa de permisos
        opcionMenuPorRolServicio.eliminarPorIdRol(this.selectedRolPermisos.getId());

        // Se guarda los nuevos datos en la BDD
        rolServicioLocal.actualizarRol(this.selectedRolPermisos);

        // Se presenta un mensaje bonito en la vista
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización Exitosa",
                "Se ha actualizado exitosamente el rol \"" + this.selectedRolPermisos.getId() + "\"");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
