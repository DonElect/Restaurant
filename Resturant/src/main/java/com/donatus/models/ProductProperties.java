package com.donatus.models;

import com.donatus.services.CATEGORY;

public class ProductProperties {
    private String name;
    private CATEGORY CAT;
    private int price;
    private int quantity;

    public ProductProperties(String name, CATEGORY CAT, int price, int quantity) {
        this.name = name;
        this.CAT = CAT;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductProperties(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CATEGORY getCAT() {
        return CAT;
    }

    public void setCAT(CATEGORY CAT) {
        this.CAT = CAT;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductProperties{" +
                "name='" + name + '\'' +
                ", CAT=" + CAT +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
