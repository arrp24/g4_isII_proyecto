package com.ls.gestion.commons.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ls.gestion.commons.dao.GenericDao;

@SuppressWarnings("unchecked")
public abstract class GenericDaoImpl<T, PK extends Serializable> implements
		GenericDao<T, PK> {	
	
	@PersistenceContext(unitName = "geoportalDs")
	protected EntityManager em;

	private Class<T> type;

	public GenericDaoImpl(final Class<T> type) {
		this.type = type;
	}

    public GenericDaoImpl() {
		Class<T> aType = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		this.type = aType;
	}
	
	
	@Override
    public void insert(T entity) {			
		try {			
			em.persist(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
    public void update(T entity) {
			em.merge(entity);
	}

	@Override
    public void delete(T entity) {
		em.remove(entity);
	}		
	
	@Override
    public List<T> findAll() {		
			List<T> results = em.createQuery(
					"select o from " + type.getSimpleName() + " o")
					.getResultList();
			return results;	
	}
	
	@Override
    public T findByPk(final PK pk) {
			return em.find(type, pk);	
	}	

}