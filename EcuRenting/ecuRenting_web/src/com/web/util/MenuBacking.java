package com.ls.gestion.web.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

import com.ls.gestion.entity.OpcionMenu;
import com.ls.gestion.entity.OpcionMenuPorRol;
import com.ls.gestion.service.OpcionMenuPorRolServicioLocal;
import com.ls.gestion.web.backing.AuthenticationBacking;

@ManagedBean(name = "menuBacking")
@SessionScoped
public class MenuBacking implements Serializable {

    private static final long serialVersionUID = -8957720281547968495L;

    @ManagedProperty(value = "#{authenticationBacking}")
    private AuthenticationBacking authenticationBacking;

    @EJB
    private OpcionMenuPorRolServicioLocal opcionMenuPorRolServicio;

    private MenuModel menu;

    private List<OpcionMenuPorRol> opcionesMenuPorRol;

    public MenuBacking() {

    }

    @PostConstruct
    public void init() throws IOException {
        if (authenticationBacking.getRolPorUsuarioActual() != null) {
            String rolId = authenticationBacking.getRolPorUsuarioActual().getId().getRolId();
            this.opcionesMenuPorRol = opcionMenuPorRolServicio.getOpcionesMenuPorRol(rolId);
            construirMenu();
        }
    }

    private void construirMenu() {
        menu = new DefaultMenuModel();
        Collections.sort(this.opcionesMenuPorRol);
        for (OpcionMenuPorRol opcionMenuPorRol : this.opcionesMenuPorRol) {
            if (opcionMenuPorRol.getOpcionMenu().getNivelOpcion() == 1) {
                if ("#".equals(opcionMenuPorRol.getOpcionMenu().getUrl())) {
                    Submenu submenu = new Submenu();
                    submenu = obtenerMenuHijos(opcionMenuPorRol.getOpcionMenu(), submenu);
                    submenu.setLabel(opcionMenuPorRol.getOpcionMenu().getEtiqueta());
                    menu.addSubmenu(submenu);
                } else if (opcionMenuPorRol.getOpcionMenu().getPadre() == null) {
                    MenuItem item = new MenuItem();
                    item.setValue(opcionMenuPorRol.getOpcionMenu().getEtiqueta());
                    item.setUrl(opcionMenuPorRol.getOpcionMenu().getUrl());
                    // item.adaddActionListener(new FooActionListener());
                    menu.addMenuItem(item);
                }
                
            }
        }
    }

    private Submenu obtenerMenuHijos(OpcionMenu opcionMenu, Submenu submenu) {
        MenuItem item = new MenuItem();
        if (opcionMenu.getUrl().trim().equals("#")) {
            for (OpcionMenuPorRol opcionMenuPorRol : this.opcionesMenuPorRol) {
                if (opcionMenuPorRol.getOpcionMenu().getPadre() != null
                        && opcionMenuPorRol.getOpcionMenu().getPadre().getId().equals(opcionMenu.getId())) {
                    if (opcionMenuPorRol.getOpcionMenu().getHijos().isEmpty()) {
                        item = new MenuItem();
                        item.setValue(opcionMenuPorRol.getOpcionMenu().getEtiqueta());
                        item.setUrl(opcionMenuPorRol.getOpcionMenu().getUrl());
                        // item.adaddActionListener(new FooActionListener());
                        submenu.getChildren().add(item);
                    } else {
                        Submenu submenuItem = new Submenu();
                        submenuItem = obtenerMenuHijos(opcionMenuPorRol.getOpcionMenu(), submenuItem);
                        submenuItem.setLabel(opcionMenuPorRol.getOpcionMenu().getEtiqueta());
                        submenu.getChildren().add(submenuItem);
                    }
                }
            }
        }
        return submenu;
    }

    public MenuModel getMenu() {
        return menu;
    }

    public void setAuthenticationBacking(AuthenticationBacking authenticationBacking) {
        this.authenticationBacking = authenticationBacking;
    }
}
