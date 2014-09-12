package com.ls.gestion.dao.impl;

import javax.ejb.Stateless;

import com.ls.gestion.commons.dao.impl.GenericDaoImpl;
import com.ls.gestion.dao.PreguntaDao;
import com.ls.gestion.entity.Pregunta;

@Stateless
public class PreguntaDaoImpl extends GenericDaoImpl<Pregunta, Integer> implements PreguntaDao {

	
	 /* Constructor
    */
   public PreguntaDaoImpl() {
       super(Pregunta.class);
   }
}
