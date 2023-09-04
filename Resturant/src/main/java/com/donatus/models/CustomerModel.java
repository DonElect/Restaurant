package com.donatus.models;

import java.util.Map;

public class CustomerModel implements Comparable<CustomerModel>{
    private String fullName;
    private int ID;
    private Map<String, ProductProperties> cart;
    private static int count = 0;

    private int quantity;

    public CustomerModel(String fullName, Map<String, ProductProperties> cart){
        this.fullName = fullName;
        this.cart = cart;
        this.quantity = getCartQuantity();
        this.ID = count++;
    }

    public CustomerModel(String fullName){
        this.fullName = fullName;
        this.ID = count++;
        //this.quantity = getCartQuantity();
    }

    public String getFullName() {
        return fullName;
    }

    public int getID() {
        return ID;
    }

    public void setCart(Map<String, ProductProperties> cart) {
        this.cart = cart;
    }

    public Map<String, ProductProperties> getCart() {
        return cart;
    }

    private int getCartQuantity(){
        if(cart != null) {
            for (var item : cart.values()) {
                quantity += item.getQuantity();
            }
            return quantity;
        }
        else
            return 0;
    }

    @Override
    public int compareTo(CustomerModel o) {
        if(this.quantity < o.quantity){
            return 1;
        }
        else if (this.quantity > o.quantity) {
            return -1;
        }
        else
            return 0;
    }
}
