package com.ls.gestion.commons.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {

    /**
     * <b> Realiza una insercion en la BDD. </b>
     * <p>
     * [Author: katy, Date: 06/2014]
     * </p>
     * 
     * @param entity
     *            T
     */
    void insert(T entity);

    /**
     * <b> Actualiza la informacion en la BDD. </b>
     * <p>
     *  [Author: katy, Date: 06/2014]
     * </p>
     * 
     * @param entity
     *            T
     */
    void update(T entity);

    /**
     * <b> Elimina una entidad de la BDD. </b>
     * <p>
     *  [Author: katy, Date: 06/2014]
     * </p>
     * 
     * @param entity
     *            T
     */
    void delete(T entity);

    /**
     * <b> Devuelve una lista con todas la entidades existentes de un tipo. </b>
     * <p>
     *  [Author: katy, Date: 06/2014]
     * </p>
     * 
     * @return List<T>
     */
    List<T> findAll();

    /**
     * <b> Devuelve una entidad de acuerdo al codigo entregado por parámetro. </b>
     * <p>
     *  [Author: katy, Date: 06/2014]
     * </p>
     * 
     * @param codigo Codigo de la entidad
     * @return Entidad T
     */
    T findByPk(final PK codigo);

}