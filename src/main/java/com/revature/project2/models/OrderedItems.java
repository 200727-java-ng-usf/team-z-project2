package com.revature.project2.models;

import java.util.Objects;

public class OrderedItems {

    private Integer id;

    private Integer userOrderId;

    private Integer itemId;

    // no-args constructor
    public OrderedItems () { super(); }

    // constructor without ID
    public OrderedItems (Integer userOrderId, Integer itemId) {

        this.userOrderId = userOrderId;
        this.itemId = itemId;

    }

    // full constructor
    public OrderedItems (Integer id, Integer userOrderId, Integer itemId) {

        this (userOrderId, itemId);
        this.id = id;

    }

    // copy constructor
    public OrderedItems (OrderedItems copy) {

        this (copy.id, copy.userOrderId, copy.itemId);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserOrderId() {
        return userOrderId;
    }

    public void setUserOrderId(Integer userOrderId) {
        this.userOrderId = userOrderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedItems that = (OrderedItems) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userOrderId, that.userOrderId) &&
                Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userOrderId, itemId);
    }

    @Override
    public String toString() {
        return "OrderedItems{" +
                "id=" + id +
                ", userOrderId=" + userOrderId +
                ", itemId=" + itemId +
                '}';
    }
}
