package com.savkova.app.dao;

import com.savkova.app.entities.Menu;

import javax.persistence.EntityManager;

public class MenuEntityDaoImpl extends EntityDao<Long, Menu> implements MenuDao {

    public MenuEntityDaoImpl(EntityManager em) {
        super(em);
    }

}
