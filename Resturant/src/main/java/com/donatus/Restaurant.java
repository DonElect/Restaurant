package com.donatus;

import com.donatus.implementation.*;
import com.donatus.models.Cashier;
import com.donatus.models.CustomerModel;
import com.donatus.models.Manager;
import static  com.donatus.implementation.Products.viewItemsFunc;

public class Restaurant {

    public static void main(String[] args) {
        // Creating instances
        Manager manager = new Manager("Donatus", (byte)35,
                "081464893864", "donatus@gmail.com");

        ManagerImp managerImp = new ManagerImp(manager);

        Cashier cashier1 = new Cashier("Jane", (byte)25, "090243637784",
                "jane@gmail.com", "Stand 1");
        Cashier cashier2 = new Cashier("Mary", (byte)27, "080345727383",
                "mary@gmail.com", "Stand 2");

        CashierImp cashierImp1 = new CashierImp(cashier1);
        CashierImp cashierImp2 = new CashierImp(cashier2);

        Customer customer1 = new Customer(new CustomerModel("Mike"));
        Customer customer2 = new Customer(new CustomerModel("John"));
        Customer customer3 = new Customer(new CustomerModel("Samuel"));

        new Products().addProductsToRestaurant();
        viewItemsFunc.accept(new Products().getFoods());
        System.out.println();
        viewItemsFunc.accept(new Products().getDrinks());

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

        // Threads of Cashiers attending to customers by FIFO or priority.
        while (!new CashierImp().getCustomersPriorityQueue().isEmpty()) {
            Thread thread1 = new Thread(cashierImp1::sellPriority, "Cashier: " + cashier1.getName());
            Thread thread2 = new Thread(cashierImp2::sellPriority, "Cashier: " + cashier2.getName());
            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                System.out.println("Interrupt Exception Thrown.");
            }
        }
    }
}
