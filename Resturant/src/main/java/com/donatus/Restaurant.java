package com.donatus;

import com.donatus.implementation.CashierImp;
import com.donatus.implementation.Customer;
import com.donatus.implementation.ManagerImp;
import com.donatus.implementation.Products;
import com.donatus.models.Cashier;
import com.donatus.models.Manager;

public class Restaurant {

    public static void main(String[] args) {
        // Creating instances
        Manager manager = new Manager("Donatus", (byte)35,
                "081464893864", "donatus@gmail.com");

        ManagerImp managerImp = new ManagerImp(manager);

        Cashier cashier = new Cashier("Jane", (byte)25, "090243637784",
                "jane@gmail.com", "Stand 1");

        CashierImp cashierImp = new CashierImp(cashier);
        Customer customer = new Customer();

        new Products().addProductsToRestaurant();
        new Products().viewItems(new Products().getFoods());
        System.out.println();
        new Products().viewItems(new Products().getDrinks());

//        // Adding to stock
//        cashierImp.addToStock("Pepper Soup", 1500);
//        cashierImp.addToStock("Coke", 250);
//        cashierImp.addToStock("Rice", 1000);
//
//        // Customer making request
//        customer.makeRequest("Coke");
//        customer.makeRequest("Pepper Soup");
//
//        // Make buy request
//        customer.buy();
//
//        // Cashier should give receipt
//        cashierImp.dispenseReceipt(customer);
    }
}
