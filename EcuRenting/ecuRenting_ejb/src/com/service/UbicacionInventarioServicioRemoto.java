package com.ls.gestion.service;

import java.util.List;
import javax.ejb.Remote;

import com.ls.gestion.entity.UbicacionInventario;


@Remote
public interface UbicacionInventarioServicioRemoto {

	/**
	 * <b> Se recupera el listado total de los Inventarioes </b>
	 * <p>
	 * [Author: Andres, Date: Jul 29, 2014]
	 * </p>
	 * 
	 * @return List<UbicacionInventario>
	 */

	List<UbicacionInventario> getAll();

	/**
	 * <b> Se crea un nuevo UbicacionInventario </b>
	 * <p>
	 * [Author: Andres, Date: Jul 29, 2014]
	 * </p>
	 * 
	 * @param archivo
	 * @return
	 */
	void crearInventario(UbicacionInventario ubicacionInventario);

	/**
	 * 
	 * <b> Se actualiza un ubicacionInventario </b>
	 * <p>
	 * [Author: Andres, Date: Jul 29, 2014]
	 * </p>
	 * 
	 * @param ubicacionInventario
	 * @return
	 */
	void actualizarInventario(UbicacionInventario ubicacionInventario);

	/**
	 * <b> Elimina el archivo pasado por parámetro. </b>
	 * <p>
	 * [Author: Andres, Date: Jul 29, 2014]
	 * </p>
	 * 
	 * @param codigoInventario
	 *            codigo que pertenece al ubicacionInventario a borrarse
	 * 
	 */
	void eliminarInventario(Integer codigoubicacionInventario);

	/**
	 * <b> Devuelve el ubicacionInventario buscado por código. </b>
	 * <p>
	 * [Author: Andres, Date: Jul 29, 2014]
	 * </p>
	 * 
	 * @param codigo
	 *            Código del UbicacionInventario a buscar.
	 * @return UbicacionInventario
	 */
	UbicacionInventario buscarInventarioPorCodigo(Integer codigo);
}
