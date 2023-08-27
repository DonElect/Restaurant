package com.donatus.services;

import com.donatus.implementation.CashierImp;
import com.donatus.models.Cashier;

public interface ManagerService {
    void hire(Cashier cashier);
    void fire(Cashier cashier);
}
