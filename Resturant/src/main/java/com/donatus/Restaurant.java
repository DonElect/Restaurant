package com.donatus;

import com.donatus.implementation.CashierImp;
import com.donatus.implementation.Customer;
import com.donatus.implementation.ManagerImp;
import com.donatus.implementation.Products;
import com.donatus.models.Cashier;
import com.donatus.models.CustomerModel;
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

        Customer customer1 = new Customer(new CustomerModel("Mike"));
        Customer customer2 = new Customer(new CustomerModel("John"));
        Customer customer3 = new Customer(new CustomerModel("Samuel"));

        new Products().addProductsToRestaurant();
        new Products().viewItems(new Products().getFoods());
        System.out.println();
        new Products().viewItems(new Products().getDrinks());

        // Adding to stock

        // Customer making request
        customer1.makeRequest("Coke", 3);
        customer1.makeRequest("Pepper soup", 3);

        customer2.makeRequest("Coke", 4);
        customer2.makeRequest("Pepper soup", 4);

        customer3.makeRequest("Coke", 1);
        customer3.makeRequest("Pepper soup", 2);

        // Make buy request
        customer1.buy();
        customer2.buy();
        customer3.buy();

        cashierImp.sellFIFO();
        //cashierImp.sellPriority();
//
//        // Cashier should give receipt
//        cashierImp.dispenseReceipt(customer);
    }
}
