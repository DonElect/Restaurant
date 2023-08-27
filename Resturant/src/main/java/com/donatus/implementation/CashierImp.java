package com.donatus.implementation;

import com.donatus.models.Cashier;
import com.donatus.models.ProductProperties;
import com.donatus.services.CashierServices;

import java.util.Map;

public class CashierImp implements CashierServices {
    //private Products products;
    //private Customer customer;

    private Cashier cashier;

    public CashierImp(Cashier cashier) {
        this.cashier = cashier;
    }

    public CashierImp(){

    }

    @Override
    public boolean addToStock() {
        if (new Products().addProductsToRestaurant()) {
            System.out.println("Products added Successfully");
            return true;
        }
        else {
            System.out.println("Error adding products.");
            return false;
        }
    }

    @Override
    public void dispenseReceipt(Customer customer) {
        int sum = 0;
        System.out.println("---------------------------------");
        System.out.println("Items"+"                      "+"Price");
        for(Map.Entry<String, ProductProperties> items : customer.getCart().entrySet()){
            System.out.println(items.getKey()+"                     "+items.getValue());
            sum += items.getValue().getPrice();
        }
        System.out.println("Bill: "+sum);
        System.out.println("Thank you for patronizing us. Have a nice day");
    }
}
