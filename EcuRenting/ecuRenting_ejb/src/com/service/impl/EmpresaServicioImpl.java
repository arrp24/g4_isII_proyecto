package com.ls.gestion.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ls.gestion.dao.EmpresaDao;
import com.ls.gestion.entity.Empresa;
import com.ls.gestion.service.EmpresaServicioRemoto;
import com.ls.gestion.service.EmpresaServicioLocal;

@Stateless

public class EmpresaServicioImpl implements EmpresaServicioRemoto, EmpresaServicioLocal{

	 public EmpresaServicioImpl() {

	    }

	    /**
	     * EmpresaDao.
	     */
	    @EJB
	    private static EmpresaDao empresaDao;

		@Override
		public void actualizarEmpresa(Empresa empresa) {
			empresaDao.update(empresa);
			
		}

		@Override
		public void eliminarEmpresa(Integer codigoEmpresa) {
			empresaDao.delete(buscarEmpresaPorCodigo(codigoEmpresa));
			
		}

		@Override
		public Empresa buscarEmpresaPorCodigo(Integer codigo) {
			
			return empresaDao.findByPk(codigo);
		}

		@Override
		public List<Empresa> getAll() {
	
			return empresaDao.findAll();
		}

		@Override
		public void crearEmpresa(Empresa empresa) {
			empresaDao.insert(empresa);
			
		}
 
}
