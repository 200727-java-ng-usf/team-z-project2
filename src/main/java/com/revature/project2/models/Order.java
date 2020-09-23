package com.revature.project2.models;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name="mall_user_orders")
public class Order {

    @Id
    @Column
    private Integer id;

    @Column(nullable = false)
    private Timestamp timeCreated;

    @ManyToOne // many orders to one user. References mall_users
    @JoinColumn // specify what to join?
    private Integer userId;

    @Column(nullable = false)
    private Integer itemCount;

    @Column(nullable = false)
    private Double price;

    // no-args constructor
    public Order () { super(); }

    // constructor without ID
    public Order (Timestamp timeCreated, Integer userId, Integer itemCount, Double price) {

        this.timeCreated = timeCreated;
        this.userId = userId;
        this.itemCount = itemCount;
        this.price = price;

    }

    // full constructor
    public Order (Integer id, Timestamp timeCreated, Integer userId, Integer itemCount, Double price) {

        this (timeCreated, userId, itemCount, price);
        this.id = id;

    }

    // copy constructor
    public Order (Order copy) {
        this (copy.id, copy.timeCreated, copy.userId, copy.itemCount, copy.price);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Timestamp timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(timeCreated, order.timeCreated) &&
                Objects.equals(userId, order.userId) &&
                Objects.equals(itemCount, order.itemCount) &&
                Objects.equals(price, order.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timeCreated, userId, itemCount, price);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", timeCreated=" + timeCreated +
                ", userId=" + userId +
                ", itemCount=" + itemCount +
                ", price=" + price +
                '}';
    }
}
