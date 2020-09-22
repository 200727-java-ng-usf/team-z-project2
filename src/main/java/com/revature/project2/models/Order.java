package com.revature.project2.models;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

public class Order {

    private Integer id;

    private Timestamp timeCreated;

    private Integer userId;

    private Integer itemCount;

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
