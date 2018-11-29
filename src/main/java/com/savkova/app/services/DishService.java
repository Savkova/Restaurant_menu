package com.savkova.app.services;

import com.savkova.app.dao.DishDao;
import com.savkova.app.dao.DishEntityDao;
import com.savkova.app.entities.Dish;
import com.savkova.app.exceptions.MyDbException;

import javax.persistence.EntityManager;
import java.util.List;

public class DishService {

    private DishDao dishDao;

    public DishService(EntityManager em) {
        this.dishDao = new DishEntityDao(em);
    }

    public void create(Dish dish) throws MyDbException {
        dishDao.create(dish);
    }

    public void update(Dish dish) throws MyDbException {
        dishDao.update(dish);
    }

    public Dish findById(Long id) {
        return dishDao.findById(id);
    }

    public void delete(Long id) throws MyDbException {
        dishDao.delete(dishDao.findById(id));
    }

    public List<Dish> getDishesByPrice(Double from, Double to, Long menuId){
        return dishDao.getDishesByPrice(from, to, menuId);
    }

    public List<Dish> getDishesWithDiscount(Long menuId){
        return dishDao.getDishesWithDiscount(menuId);
    }

}
