package com.donatus.implementation;

import com.donatus.models.Cashier;
import com.donatus.models.CustomerModel;
import com.donatus.models.ProductProperties;
import com.donatus.services.CashierServices;

import java.util.*;

public class CashierImp implements CashierServices {
    private Cashier cashier;

    private final String lock1 = "lock1";
    private final String lock2 = "lock2";

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
        if (customersFIFOQueue.isEmpty())
            return;
        CustomerModel currentCustomer = customersFIFOQueue.poll();
        Map<String, ProductProperties> myCart = currentCustomer.getCart();
        String fullName = currentCustomer.getFullName();
        synchronized (lock1) {
            dispenseReceipt(myCart, fullName);
            System.out.println("Thank you for patronizing us. "+Thread.currentThread().getName());
        }
    }

    public void sellPriority() {
        if (customersPriorityQueue.isEmpty())
            return;
        CustomerModel currentCustomer = customersPriorityQueue.poll();
        Map<String, ProductProperties> myCart = currentCustomer.getCart();
        String fullName = currentCustomer.getFullName();
        synchronized (lock2) {
            dispenseReceipt(myCart, fullName);
            System.out.println("Thank you for patronizing us. "+Thread.currentThread().getName());
        }
    }


    private void dispenseReceipt(Map<String, ProductProperties> myCart, String fullName) {
        System.out.println("---------------------------------");
        System.out.println(fullName+" Purchase Receipt");
        System.out.println("Items" + "                      " + "Price");

        Set<Integer> set = new HashSet<>();
        Set<Map.Entry<String, ProductProperties>> cartSet = new HashSet<>(myCart.entrySet());

        int totalCost = cartSet.stream().peek(item ->
                System.out.printf("%-25s %-25s \n", item.getKey(), item.getValue().getPrice())
        ).map(item -> item.getValue().getPrice() * item.getValue().getQuantity()).reduce(0, Integer::sum);

//        for (Map.Entry<String, ProductProperties> items : myCart.entrySet()) {
//            System.out.println(items.getKey() + "                     " + items.getValue().getPrice());
//            sum += (items.getValue().getQuantity()) * (items.getValue().getPrice());
//        }
        System.out.println("Bill: " + totalCost);
    }

    public Queue<CustomerModel> getCustomersFIFOQueue() {
        return customersFIFOQueue;
    }

    public Queue<CustomerModel> getCustomersPriorityQueue() {
        return customersPriorityQueue;
    }
}
