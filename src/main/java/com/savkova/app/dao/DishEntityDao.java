package com.savkova.app.dao;

import com.savkova.app.entities.Dish;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DishEntityDao extends EntityDao<Long, Dish> implements DishDao {

    public DishEntityDao(EntityManager em) {
        super(em);
    }

    @Override
    public List<Dish> getDishesByPrice(Double from, Double to, Long menuId) {
        String select = "SELECT d FROM Dish d INNER JOIN d.menu m " +
                "where d.price > :priceFrom and d.price <= :priceTo and m.id = :menuId";

        Query query = entityManager.createQuery(select, Dish.class);
        query.setParameter("priceFrom", from);
        query.setParameter("priceTo", to);
        query.setParameter("menuId", menuId);

        return (List<Dish>) query.getResultList();
    }

    @Override
    public List<Dish> getDishesWithDiscount(Long menuId) {
        String select = "SELECT d FROM Dish d INNER JOIN d.menu m " +
                "where d.discount > 0 and m.id = :menuId";

        Query query = entityManager.createQuery(select, Dish.class);
        query.setParameter("menuId", menuId);

        return (List<Dish>) query.getResultList();
    }

    @Override
    public List<Dish> getDishesLessOneKilo(Long menuId) {
        String select = "SELECT d FROM Dish d INNER JOIN d.menu m " +
                "where d.weight <= 1000 and m.id = :menuId";

        Query query = entityManager.createQuery(select, Dish.class);
        query.setParameter("menuId", menuId);

        return (List<Dish>) query.getResultList();
    }

}
