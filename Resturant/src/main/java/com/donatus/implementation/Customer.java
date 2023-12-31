package com.donatus.implementation;

import com.donatus.models.CustomerModel;
import com.donatus.models.ProductProperties;
import com.donatus.services.CATEGORY;

import java.util.HashMap;
import java.util.Map;

public class Customer {

    private CustomerModel customer;
    private Map<String, ProductProperties> cart = new HashMap<>();
    public Customer(CustomerModel customer){
        this.customer = customer;
    }

    public Customer(){

    }

    public void makeRequest(String item, int quantity){
        if(new Products().getDrinks().containsKey(item)){
            if((new Products().getDrinks().get(item).getQuantity() - quantity) >= 0){
                if(cart.containsKey(item)){
                    cart.get(item).setQuantity(cart.get(item).getQuantity() + quantity);
                }
                else {
                    ProductProperties newProduct = new ProductProperties();
                    newProduct.setName(item);
                    newProduct.setCAT(CATEGORY.DRINKS);
                    newProduct.setPrice(new Products().getDrinks().get(item).getPrice());
                    newProduct.setQuantity(quantity);

                    cart.put(item, newProduct);
                }
                new Products().getDrinks().get(item).setQuantity(new Products().getDrinks().get(item).getQuantity() - quantity);
                System.out.println(item+" request made.");
                System.out.println();
            }
        }
        else if(new Products().getFoods().containsKey(item)){
            if((new Products().getFoods().get(item).getQuantity() - quantity) >= 0){
                if(cart.containsKey(item)){
                    cart.get(item).setQuantity(cart.get(item).getQuantity() + quantity);
                }
                else {
                    ProductProperties newProduct = new ProductProperties();
                    newProduct.setName(item);
                    newProduct.setCAT(CATEGORY.FOOD);
                    newProduct.setPrice(new Products().getFoods().get(item).getPrice());
                    newProduct.setQuantity(quantity);
                    cart.put(item, newProduct);
                }

                new Products().getFoods().get(item).setQuantity(new Products().getFoods().get(item).getQuantity() - quantity);
                System.out.println(item+" request made.");
                System.out.println();
            }
        }
        else {
            System.out.println("We dont sell " + item + " here'");
            System.out.println();
        }
    }

    public void buy(){
        customer.setCart(cart);

        // FIFO Queue
        new CashierImp().getCustomersFIFOQueue().add(customer);

        // Priority Queue
        new CashierImp().getCustomersPriorityQueue().add(new CustomerModel(customer.getFullName(), cart));
    }

    public Map<String, ProductProperties> getCart() {
        return cart;
    }
}
