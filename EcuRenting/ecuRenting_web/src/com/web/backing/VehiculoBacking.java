package com.web.backing;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage

import com.ls.gestion.entity.Vehiculo;
import com.ls.gestion.service.VehiculoServicioLocal;

@ManagedBean(name = "vehiculoBacking")
@ViewScoped
public class VehiculoBacking implements Serializable {

    @EJB
    private VehiculoServicioLocal vehiculoServicio;

    private List<Vehiculo> vehiculos;
    private Vehiculo vehiculo;
    private Vehiculo selectedVehiculo;

    public VehiculoBacking() {   
        this.vehiculo = new Vehiculo();
    }

    @PostConstruct
    public void init() {   	
        this.vehiculos = vehiculoServicio.getAll();
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Vehiculo getSelectedVehiculo() {
        return selectedVehiculo;
    }

    public void setSelectedVehiculo(Vehiculo selectedVehiculo) {
        this.selectedVehiculo = selectedVehiculo;
        obtenerDualListModel();
    }
    
    public void crearVehiculo() {
        vehiculoServicio.crearVehiculo(vehiculo);
        vehiculo = new Vehiculo();
        vehiculos = vehiculoServicio.getAll();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Creación Exitosa",
                "Se ha creado un nuevo Vehiculo exitosamente!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void actualizarVehiculo() {
        vehiculoServicio.actualizarVehiculo(this.selectedVehiculo);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización Exitosa",
                "Se ha actualizado exitosamente el vehiculo \"" + this.selectedVehiculo.getNombre() + "\"");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.selectedVehiculo = null;
    }

    public void eliminarVehiculo() {
        
    }
}
