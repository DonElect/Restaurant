package com.donatus.services;

import com.donatus.implementation.Customer;

public interface CashierServices {
    boolean addToStock();
    void dispenseReceipt(Customer customer);
}
