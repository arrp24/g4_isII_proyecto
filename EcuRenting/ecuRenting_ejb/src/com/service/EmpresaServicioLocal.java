package com.ls.gestion.service;

import java.util.List;

import javax.ejb.Local;

import com.ls.gestion.entity.Empresa;

@Local
public interface EmpresaServicioLocal {

	 /**
	    * <b>
	    * Se recupera el listado total de Empresas
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
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
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param empresa
	    * @return
	    */
	   void crearEmpresa(Empresa empresa);

	   /**
	    * 
	    * <b>
	    * Se actualiza una empresa
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param empresa
	    * @return
	    */
	   void actualizarEmpresa(Empresa empresa);

	   /**
	    * <b>
	    * Elimina la empresa pasado por parámetro.
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param codigoEmpresa codigo que pertenece a la empresa a borrarse
	    *           
	    */
	   void eliminarEmpresa(Integer codigoEmpresa);

	   /**
	    * <b>
	    * Devuelve la empresa buscada por código.
	    * </b>
	    * <p>
	    * [Author: katy, Date: Jun 18, 2014]
	    * </p>
	    * 
	    * @param codigo Código de la Empresa a buscar.
	    * @return Empresa
	    */
	   Empresa buscarEmpresaPorCodigo(Integer codigo);
}
