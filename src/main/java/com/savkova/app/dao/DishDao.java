package com.savkova.app.dao;

import com.savkova.app.entities.Dish;

import java.util.List;

public interface DishDao extends Dao<Long, Dish> {

    List<Dish> getDishesByPrice(Double from, Double to, Long menuId);

    List<Dish> getDishesWithDiscount(Long menuId);

    List<Dish> getRandomDishesWeightingUpToOneKilo(Long menuId);

}
