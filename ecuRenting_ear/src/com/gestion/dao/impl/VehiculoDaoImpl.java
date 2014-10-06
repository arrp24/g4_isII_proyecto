package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;
import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.ArchivoDao;
import com.ls.gestion.entity.Archivo;


@Stateless

public class ArchivoDaoImpl extends GenericDaoImpl<Archivo, Integer> implements ArchivoDao  {

	public ArchivoDaoImpl() {
        super(Archivo.class);
    }
}
