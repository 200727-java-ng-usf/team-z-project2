package com.revature.project2.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="item_hats")
public class Item {

    @Id
    @Column(name="item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="item_name", nullable = false)
    private String name;

    @Column(name="item_price", nullable = false)
    private Double price;

    @Column(name="item_stock", nullable = false)
    private Integer stock;

    @Column(name="description")
    private String description;

    @Column(name="item_image_url")
    private String itemImageUrl;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    // no-args constructor
    public Item() { super(); }

    // constructor no ID
    public Item(String name, Double price, Integer stock, String description, String itemImageUrl, Genre genre) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.itemImageUrl = itemImageUrl;
        this.genre = genre;
    }

    // full constructor
    public Item(Integer id, String name, Double price, Integer stock, String description, String itemImageUrl, Genre genre) {
        this (name, price, stock, description, itemImageUrl, genre);
        this.id = id;
    }

    // copy constructor
    public Item(Item copy) {

        this (copy.id, copy.name, copy.price, copy.stock, copy.description, copy.itemImageUrl, copy.genre);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemImageUrl() {
        return itemImageUrl;
    }

    public void setItemImageUrl(String itemImageUrl) {
        this.itemImageUrl = itemImageUrl;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(name, item.name) &&
                Objects.equals(price, item.price) &&
                Objects.equals(stock, item.stock) &&
                Objects.equals(description, item.description) &&
                Objects.equals(itemImageUrl, item.itemImageUrl) &&
                Objects.equals(genre, item.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, stock, description, itemImageUrl, genre);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                ", itemImageUrl='" + itemImageUrl + '\'' +
                ", genre=" + genre +
                '}';
    }
}
