package com.savkova.app.dao;

import com.savkova.app.exceptions.MyDbException;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;


public abstract class EntityDao<K, T> implements Dao<K, T> {

    protected EntityManager entityManager;
    protected Class<T> type;

    public EntityDao(EntityManager em) {
        this.entityManager = em;

        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.type = (Class<T>) genericSuperclass.getActualTypeArguments()[1];
    }

    @Override
    public void create(T item) throws MyDbException {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(item);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new MyDbException(e.getMessage());
        }
    }

    @Override
    public void update(T item) throws MyDbException {
       entityManager.getTransaction().begin();
        try {
            entityManager.merge(item);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new MyDbException(e.getMessage());
        }
    }

    @Override
    public T findById(K id) {
        return entityManager.find(type, id);
    }


    @Override
    public void delete(T item) throws MyDbException {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(item);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new MyDbException(e.getMessage());
        }
    }

}
