package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.ArchivoDao;
import com.ls.gestion.entity.Archivo;
import com.ls.gestion.service.ArchivoServicioRemoto;
import com.ls.gestion.service.ArchivoServicioLocal;


@Stateless
public class ArchivoServicioImpl implements ArchivoServicioRemoto, ArchivoServicioLocal {

	
	 /**
     * ArchivoDao.
     */
    @EJB
    private static ArchivoDao archivoDao;
    
    
	@Override
	public List<Archivo> getAll() {
		return archivoDao.findAll();
	}

	@Override
	public void crearArchivo(Archivo archivo) {
		archivoDao.insert(archivo);
		
	}

	@Override
	public void actualizarArchivo(Archivo archivo) {
		archivoDao.update(archivo);
		
	}

	@Override
	public void eliminarArchivo(Integer codigoArchivo) {
		archivoDao.delete(buscarArchivoPorCodigo(codigoArchivo));	
		
	}

	@Override
	public Archivo buscarArchivoPorCodigo(Integer codigo) {
		return archivoDao.findByPk(codigo);
	}

}
