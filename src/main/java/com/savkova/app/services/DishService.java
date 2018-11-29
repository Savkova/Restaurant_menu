package com.savkova.app.services;

import com.savkova.app.dao.DishDao;
import com.savkova.app.dao.DishEntityDaoImpl;
import com.savkova.app.entities.Dish;
import com.savkova.app.exceptions.MyDbException;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DishService {

    private DishDao dishDao;

    public DishService(EntityManager em) {
        this.dishDao = new DishEntityDaoImpl(em);
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

    public List<Dish> getDishesByPrice(Double from, Double to, Long menuId) {
        return dishDao.getDishesByPrice(from, to, menuId);
    }

    public List<Dish> getDishesWithDiscount(Long menuId) {
        return dishDao.getDishesWithDiscount(menuId);
    }

    public List<Dish> getRandomDishesWithTotalWeightLessOneKilo(Long menuId) {
        List<Dish> dishesLessOneKilo = dishDao.getDishesLessOneKilo(menuId);
        List<Dish> result = new ArrayList<>();

        Random random = new Random();
        Dish firstRandomDish = dishesLessOneKilo.get(random.nextInt(dishesLessOneKilo.size()));

        Double sumWeight = firstRandomDish.getWeight();
        result.add(firstRandomDish);
        dishesLessOneKilo.remove(firstRandomDish);

        for (Dish d : dishesLessOneKilo) {
            if (sumWeight + d.getWeight() < 1000) {
                sumWeight += d.getWeight();
                result.add(d);
            }
            else
                continue;
        }
        return result;
    }

}
