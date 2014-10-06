package com.service;


import java.util.List;
import javax.ejb.Remote;
import com.gestion.entity.Vehiculo;

@Remote
public interface VehiculoServicioRemoto {

	 /**
     * <b>
     * Se recupera el listado total de los Vehiculos
     * </b>
     * <p>
     * [Author: Desarrollo, Date: Oct 04, 2014]
     * </p>
     * 
     * @return List<Vehiculo>
     */
    List<Vehiculo> getAll();

    /**
     * <b>
     * Se crea un nuevo Vehiculo
     * </b>
     * <p>
     * [Author: Desarrollo, Date: Oct 04, 2014]
     * </p>
     * 
     * @param Vehiculo
     * @return
     */
    void crearVehiculo (Vehiculo Vehiculo);

    /**
     * Se actualiza una Vehiculo
     * <b>
     * <p>
     * [Author: Desarrollo, Date: Oct 04, 2014]
     * </p>
     * 
     * @param Vehiculo
     * @return
     */
    void actualizarVehiculo(Vehiculo Vehiculo);

    /**
     * <b>
     * Elimina el Vehiculo pasado por parámetro.
     * </b>
     * <p>
     * [Author: Desarrollo, Date: Oct 04, 2014]
     * </p>
     * 
     * @param codigoVehiculo
     *            Codigo del Vehiculo a ser borrado
     */
    void eliminarVehiculo(Integer codigoVehiculo);

    /**
     * <b>
     * Devuelve un Vehiculo busacado por código.
     * </b>
     * <p>
     * [Author: Desarrollo, Date: Oct 04, 2014]
     * </p>
     * 
     * @param codigo
     *            Código a buscar.
     * @return Vehiculo
     */
    Vehiculo buscarVehiculoPorCodigo(Integer codigo);
}
