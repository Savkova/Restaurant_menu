package com.savkova.app;

import com.savkova.app.entities.Dish;
import com.savkova.app.entities.Menu;
import com.savkova.app.services.DishService;
import com.savkova.app.services.MenuService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String[] args) {
        try {
            emf = Persistence.createEntityManagerFactory("MenuDB");
            em = emf.createEntityManager();

            MenuService menuService = new MenuService(em);

            Menu regularMenu = new Menu("Regular menu");
            menuService.create(regularMenu);

            Menu banquetMenu = new Menu("Banquet menu");
            menuService.create(banquetMenu);

            DishService dishService = new DishService(em);
            regularMenu = menuService.findById(1L);
            dishService.create(new Dish(regularMenu, "Soup", 55.0, 130.0, 5));
            dishService.create(new Dish(regularMenu, "Dorado", 230.0, 200.0));
            dishService.create(new Dish(regularMenu, "Cheese Plate", 80.0, 150.0, 7));
            dishService.create(new Dish(regularMenu, "Vegetables", 65.0, 550.0));

            Dish dish = dishService.findById(2L);
            dish.setDiscount(30);
            dishService.update(dish);

            menuService.delete(2L);

            List<Dish> dishesFromToByPrice = dishService.getDishesByPrice(50.0, 200.0, 1L);
            for (Dish d : dishesFromToByPrice) {
                System.out.println(d);
            }

            List<Dish> dishesWithDiscount = dishService.getDishesWithDiscount(1L);
            for (Dish d : dishesWithDiscount) {
                System.out.println(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }


    }
}
