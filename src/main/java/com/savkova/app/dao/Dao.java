package com.savkova.app.dao;

import com.savkova.app.exceptions.MyDbException;

public interface Dao<K, T> {

    void create(T item) throws MyDbException;

    void update (T item) throws MyDbException;

    T findById(K id);

    void delete(T item) throws MyDbException;

}
