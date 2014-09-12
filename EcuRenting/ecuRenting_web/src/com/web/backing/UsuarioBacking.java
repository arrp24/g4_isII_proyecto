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

import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DualListModel;


import com.ls.gestion.entity.Rol;
import com.ls.gestion.entity.RolPorUsuario;
import com.ls.gestion.entity.Usuario;
import com.ls.gestion.entity.pk.RolPorUsuarioPK;

import com.ls.gestion.service.RolPorUsuarioServicioLocal;
import com.ls.gestion.service.RolServicioLocal;
import com.ls.gestion.service.UsuarioServicioLocal;

@ManagedBean(name = "usuarioBacking")
@ViewScoped
public class UsuarioBacking implements Serializable {

    private static final long serialVersionUID = 5297201599173897134L;

    @ManagedProperty(value = "#{authenticationBacking}")
    private AuthenticationBacking authenticationBacking;

    @EJB
    private UsuarioServicioLocal usuarioServicio;

    @EJB
    private RolPorUsuarioServicioLocal rolPorUsuarioServicio;

    @EJB
    private RolServicioLocal rolServicio;

   /* @EJB
    private CargoServicioLocal cargoServicio;
*/
    private List<Usuario> usuarios;
    private List<Rol> roles;
    //private List<Cargo> cargos;
    private DualListModel<Rol> rolPorUsuario = new DualListModel<Rol>();
    private Usuario usuario;
    private Usuario selectedUsuario;

    public UsuarioBacking() {   
        this.usuario = new Usuario();
    }

    @PostConstruct
    public void init() {   	
        this.usuarios = usuarioServicio.getAll();
        this.roles = rolServicio.getAll();
    //    this.cargos = cargoServicio.getAll();
    }

    public void setAuthenticationBacking(AuthenticationBacking authenticationBacking) {
        this.authenticationBacking = authenticationBacking;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

   /* public List<Cargo> getCargos() {
    	
        return cargos;
    }
    
    

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }*/

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

    public String getFechaHoy() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date today = Calendar.getInstance().getTime();
        return df.format(today);
    }
    
   /* public List<Cargo> cargosActivos(String cargoP) {
    	List<Cargo> cargoAct = cargoServicio.getAll();
    	System.out.println("CARGO: " + cargoP);
    	for (int i=0; i<cargoAct.size(); i++)
    	{
    		System.out.println("AQUI: " + cargoAct.get(i).getNombre());
    		if (cargoAct.get(i).getNombre().contains(cargoP))
    		{
    			System.out.println("ENTRAAAAA: " + cargoAct.get(i).getNombre());
    			 cargoAct.remove(i);
    		}
    	}
    	
               
    	return cargoAct;
    }*/

    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario " + event.getVisibility(), "Nombre: "
                + ((Usuario) event.getData()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void setRolPorUsuario(DualListModel<Rol> rolPorUsuario) {
        this.rolPorUsuario = rolPorUsuario;
    }

    public DualListModel<Rol> getRolPorUsuario() {
        return this.rolPorUsuario;
    }

    public void obtenerDualListModel() {
        List<Rol> source = this.roles;
        List<Rol> target = new ArrayList<Rol>();

        if (this.selectedUsuario.getRolPorUsuarios() != null) {
            if (!this.selectedUsuario.getRolPorUsuarios().isEmpty()) {
                for (RolPorUsuario rolPorUsuarioActual : this.selectedUsuario.getRolPorUsuarios()) {
                    target.add(rolPorUsuarioActual.getRol());
                }
            }
            for (Rol rolActual : target) {
                for (int i = 0; i < source.size(); i++) {
                    if (source.get(i).getId().equals(rolActual.getId()))
                        source.remove(i);
                }
            }
        }
        this.rolPorUsuario = new DualListModel<Rol>(source, target);
        this.roles = rolServicio.getAll();
    }

    public void crearUsuario() {
        usuario.setFechaCreacion(new Date());
        usuario.setModificadoPor(authenticationBacking.getRolPorUsuarioActual().getId().getUsuarioId());
        // TODO: El cargo no se está asignando desde la vista Algo pasa con el converter
       // usuario.setCargo(cargoServicio.buscarCargoPorCodigo(1));
        usuarioServicio.crearUsuario(usuario);
        usuario = new Usuario();
        usuarios = usuarioServicio.getAll();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Creación Exitosa",
                "Se ha creado un nuevo Usuario exitosamente!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void actualizarUsuario() {
        // TODO: El cargo no se está asignando desde la vista Algo pasa con el converter
        //this.selectedUsuario.setCargo(cargoServicio.buscarCargoPorCodigo(1));
        usuarioServicio.actualizarUsuario(this.selectedUsuario);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización Exitosa",
                "Se ha actualizado exitosamente el usuario \"" + this.selectedUsuario.getNombre() + "\"");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.selectedUsuario = null;
    }

    public void eliminarUsuario() {
        if (this.selectedUsuario != null) {
            usuarioServicio.eliminarUsuario(selectedUsuario);

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminación Exitosa",
                    "Se ha borrado exitosamente el usuario \"" + this.selectedUsuario.getNombre() + "\"");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            this.selectedUsuario = null;
            this.usuarios = usuarioServicio.getAll();
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Selección",
                    "Ha ocurrido un error al seleccionar el usuario");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public String onFlowProcess(FlowEvent event) {
        // Se manda a guardar la asignacion actual de roles
        if ("asignacionRoles".equals(event.getOldStep())) {
            guardarAsignacionRolPorUsuario();
        }
        // if (this.getRolPorUsuario().getTarget().isEmpty() || this.selectedUsuario.getRolPorUsuarios().isEmpty()) {
        // FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención",
        // "No se han asignado roles para este usuario");
        // FacesContext.getCurrentInstance().addMessage(null, msg);
        // RequestContext.getCurrentInstance().update("frmEditRolesPorUsu:growl");
        // return event.getOldStep();
        // } else {
        return event.getNewStep();
        // }

    }

    /**
     * <b> Retorna el indice del elemento<br>
     * Si no lo encuentra retorna -1. </b>
     * <p>
     * [Author: joselo, Date: 15/07/2013]
     * </p>
     * 
     * @param aguja
     *            elemento a buscar
     * @param pajar
     *            lista donde se buscara
     * @return indice del elemento.
     */
    private int indexOf(Rol aguja, List<RolPorUsuario> pajar) {
        int retorno = -1;
        for (int i = 0; i < pajar.size(); i++) {
            if (pajar.get(i).getRol().equals(aguja)) {
                retorno = i;
                break;
            }
        }
        return retorno;
    }

    /**
     * <b> Guarda la Asignación de roles por usuario. </b>
     * <p>
     * [Author: joselo, Date: 15/07/2013]
     * </p>
     */
    public void guardarAsignacionRolPorUsuario() {
        List<RolPorUsuario> asignacionActual = this.selectedUsuario.getRolPorUsuarios();
        List<Rol> nuevaAsignacion = this.rolPorUsuario.getTarget();
        List<Rol> diferencial = new ArrayList<Rol>();
        List<RolPorUsuario> repetidos = new ArrayList<RolPorUsuario>();

        for (Rol rolNuevoActual : nuevaAsignacion) {
            int indice = indexOf(rolNuevoActual, asignacionActual);
            if (indice == -1) {
                diferencial.add(rolNuevoActual);
            } else {
                repetidos.add(asignacionActual.get(indice));
            }
        }

        for (Rol difActual : diferencial) {
            // Se crea el nuevo id para el rol por usuario
            RolPorUsuarioPK id = new RolPorUsuarioPK();
            id.setRolId(difActual.getId());
            id.setUsuarioId(this.selectedUsuario.getId());

            // Se crea el nuevo rolporusuario
            RolPorUsuario nuevo = new RolPorUsuario();
            nuevo.setId(id);
            nuevo.setRol(difActual);
            nuevo.setUsuario(this.selectedUsuario);
            nuevo.setEstado("1");
            nuevo.setFechaInicioVigencia(new Date());
            nuevo.setClave(AuthenticationBacking.md5(this.selectedUsuario.getCedula()));
            nuevo.setModificadoPor(authenticationBacking.getRolPorUsuarioActual().getId().getUsuarioId());

            // Se agrega el nuevo rolporusuario a la lista de rolesporusuario
            asignacionActual.add(nuevo);
        }

        // Si es que los roles asignados son un subcnjunto del actual
        if (diferencial.isEmpty()) {
            this.selectedUsuario.getRolPorUsuarios().clear();
            this.selectedUsuario.setRolPorUsuarios(repetidos);
        }

        // Se resetean los roles antes de volver a asignarlos
        rolPorUsuarioServicio.eliminarPorUsuarioId(this.selectedUsuario.getId());

        // Se actualiza en la bdd
        usuarioServicio.actualizarUsuario(this.selectedUsuario);

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención",
                "Se ha guardado exitosamente la asignación de roles");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        RequestContext.getCurrentInstance().update("frmEditRolesPorUsu:growl");
    }
}
