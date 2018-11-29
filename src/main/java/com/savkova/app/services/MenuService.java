package com.savkova.app.services;

import com.savkova.app.dao.MenuDao;
import com.savkova.app.dao.MenuEntityDaoImpl;
import com.savkova.app.entities.Menu;
import com.savkova.app.exceptions.MyDbException;

import javax.persistence.EntityManager;

public class MenuService {

    private MenuDao menuDao;

    public MenuService(EntityManager em) {
        this.menuDao = new MenuEntityDaoImpl(em);
    }

    public void create(Menu menu) throws MyDbException {
        menuDao.create(menu);
    }

    public void update(Menu menu) throws MyDbException {
        menuDao.update(menu);
    }

    public Menu findById(Long id) {
        return menuDao.findById(id);
    }

    public void delete(Long id) throws MyDbException {
        menuDao.delete(menuDao.findById(id));
    }

}
