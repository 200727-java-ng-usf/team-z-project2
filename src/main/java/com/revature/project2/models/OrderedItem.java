package com.revature.project2.models;

import javax.persistence.*;
import java.util.Objects;

public class OrderedItem {

    @Id
    @Column
    private Integer id;

    @ManyToOne // many ordered items to one order
    @JoinColumn // will reference primary key in orders table
    private Order order;

    @ManyToOne // Many ordered items to one item
    @JoinColumn // will reference primary key in items table
    private Item item;

    // no-args constructor
    public OrderedItem() { super(); }

    // constructor without ID
    public OrderedItem(Order order, Item item) {

        this.order = order;
        this.item = item;

    }

    // full constructor
    public OrderedItem(Integer id, Order order, Item item) {

        this (order, item);
        this.id = id;

    }

    // copy constructor
    public OrderedItem(OrderedItem copy) {

        this (copy.id, copy.order, copy.item);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedItem that = (OrderedItem) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(order, that.order) &&
                Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, item);
    }

    @Override
    public String toString() {
        return "OrderedItems{" +
                "id=" + id +
                ", order=" + order +
                ", item=" + item +
                '}';
    }
}
