package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Local;

import com.ls.gestion.entity.Archivo;

@Local
public interface ArchivoServicioLocal {

	 /**
     * <b>
     * Se recupera el listado total de los archivos
     * </b>
     * <p>
     * [Author: katy, Date: Dic 10, 2013]
     * </p>
     * 
     * @return List<Archivo>
     */
    
	List<Archivo> getAll();

    /**
     * <b>
     * Se crea un nuevo Archivo
     * </b>
     * <p>
     * [Author: katy, Date: Dic 10, 2013]
     * </p>
     * 
     * @param archivo
     * @return
     */
    void crearArchivo(Archivo archivo);

    /**
     * 
     * <b>
     * Se actualiza un archivo
     * </b>
     * <p>
     * [Author: katy, Date: Dic 10, 2013]
     * </p>
     * 
     * @param archivo
     * @return
     */
    void actualizarArchivo(Archivo archivo);

    /**
     * <b>
     * Elimina el archivo pasado por parámetro.
     * </b>
     * <p>
     * [Author: katy, Date: Dic 10, 2013]
     * </p>
     * 
     * @param codigoArchivo codigo que pertenece al Archivo a borrarse
     *           
     */
    void eliminarArchivo(Integer codigoArchivo);

    /**
     * <b>
     * Devuelve el Archivo buscado por código.
     * </b>
     * <p>
     * [Author: katy, Date: Dic 10, 2013]
     * </p>
     * 
     * @param codigo Código del Archivo a buscar.
     * @return Archivo
     */
    Archivo buscarArchivoPorCodigo(Integer codigo);
    
   
}
