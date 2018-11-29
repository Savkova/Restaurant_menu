package com.savkova.app.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Dishes")
public class Dish implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @Column(name = "discount", nullable = false)
    private Integer discount;

    public Dish() {
    }

    public Dish(Menu menu, String name, Double price, Double weight, Integer discount) {
        this.menu = menu;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.discount = discount;
    }

    public Dish(Menu menu, String name, Double price, Double weight) {
        this.menu = menu;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.discount = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        Dish dish = (Dish) o;
        return Objects.equals(getId(), dish.getId()) &&
                Objects.equals(getMenu(), dish.getMenu()) &&
                Objects.equals(getName(), dish.getName()) &&
                Objects.equals(getPrice(), dish.getPrice()) &&
                Objects.equals(getWeight(), dish.getWeight()) &&
                Objects.equals(getDiscount(), dish.getDiscount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMenu(), getName(), getPrice(), getWeight(), getDiscount());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dish{");
        sb.append("id=").append(id);
        sb.append(", menu=").append(menu.getName());
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", weight=").append(weight);
        sb.append(", discount=").append(discount).append("%");
        sb.append('}');
        return sb.toString();
    }

}
