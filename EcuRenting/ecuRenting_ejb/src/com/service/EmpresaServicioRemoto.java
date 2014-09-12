package com.ls.gestion.service;


import java.util.List;
import javax.ejb.Remote;
import com.ls.gestion.entity.Empresa;

@Remote
public interface EmpresaServicioRemoto {

	 /**
     * <b>
     * Se recupera el listado total de las empresas
     * </b>
     * <p>
     * [Author: katy, Date: Jun 14, 2014]
     * </p>
     * 
     * @return List<Empresa>
     */
    List<Empresa> getAll();

    /**
     * <b>
     * Se crea una nueva Empresa
     * </b>
     * <p>
     * [Author: katy, Date: Jun 14, 2014]
     * </p>
     * 
     * @param empresa
     * @return
     */
    void crearEmpresa (Empresa empresa);

    /**
     * Se actualiza una empresa
     * <b>
     * <p>
     * [Author: katy, Date: Jun 14, 2014]
     * </p>
     * 
     * @param empresa
     * @return
     */
    void actualizarEmpresa(Empresa empresa);

    /**
     * <b>
     * Elimina la empresa pasada por parámetro.
     * </b>
     * <p>
     * [Author: katy, Date: Jun 14, 2014]
     * </p>
     * 
     * @param codigoEmpresa
     *            Codigo de la Empresa a ser borrado
     */
    void eliminarEmpresa(Integer codigoEmpresa);

    /**
     * <b>
     * Devuelve una empresa busacada por código.
     * </b>
     * <p>
     * [Author: katy, Date: Jun 14, 2014]
     * </p>
     * 
     * @param codigo
     *            Código a buscar.
     * @return Empresa
     */
    Empresa buscarEmpresaPorCodigo(Integer codigo);
}
