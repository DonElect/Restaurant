package com.donatus.implementation;

import com.donatus.models.Cashier;
import com.donatus.models.CustomerModel;
import com.donatus.models.ProductProperties;
import com.donatus.services.CashierServices;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class CashierImp implements CashierServices {
    private Cashier cashier;

    private static Queue<CustomerModel> customersFIFOQueue = new LinkedList<>();

    private static Queue<CustomerModel> customersPriorityQueue = new PriorityQueue<>();

    public CashierImp(Cashier cashier) {
        this.cashier = cashier;
    }

    public CashierImp() {

    }

    @Override
    public boolean addToStock() {
        if (new Products().addProductsToRestaurant()) {
            System.out.println("Products added Successfully");
            return true;
        } else {
            System.out.println("Error adding products.");
            return false;
        }
    }

    public void sellFIFO() {
        while (!customersFIFOQueue.isEmpty()) {
            CustomerModel currentCustomer = customersFIFOQueue.poll();
            Map<String, ProductProperties> myCart = currentCustomer.getCart();
            String fullName = currentCustomer.getFullName();
            dispenseReceipt(myCart, fullName);
        }
    }

    public void sellPriority() {
        while (!customersPriorityQueue.isEmpty()) {
            CustomerModel currentCustomer = customersPriorityQueue.poll();
            Map<String, ProductProperties> myCart = currentCustomer.getCart();
            String fullName = currentCustomer.getFullName();
            dispenseReceipt(myCart, fullName);
        }
    }


    private void dispenseReceipt(Map<String, ProductProperties> myCart, String fullName) {
        int sum = 0;
        System.out.println("---------------------------------");
        System.out.println("Items" + "                      " + "Price");
        for (Map.Entry<String, ProductProperties> items : myCart.entrySet()) {
            System.out.println(items.getKey() + "                     " + items.getValue().getPrice());
            sum += items.getValue().getQuantity()*items.getValue().getPrice();
        }
        System.out.println("Bill: " + sum);
        System.out.println("Thank you for patronizing us " + fullName + ". Have a nice day");
    }

    public Queue<CustomerModel> getCustomersFIFOQueue() {
        return customersFIFOQueue;
    }

    public Queue<CustomerModel> getCustomersPriorityQueue() {
        return customersPriorityQueue;
    }
}
