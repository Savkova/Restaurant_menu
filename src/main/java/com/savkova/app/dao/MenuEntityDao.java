package com.savkova.app.dao;

import com.savkova.app.entities.Menu;

import javax.persistence.EntityManager;

public class MenuEntityDao extends EntityDao<Long, Menu> implements MenuDao {

    public MenuEntityDao(EntityManager em) {
        super(em);
    }

}
