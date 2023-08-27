package com.donatus.implementation;

import com.donatus.models.Cashier;
import com.donatus.models.Manager;
import com.donatus.services.ManagerService;

public class ManagerImp implements ManagerService {
    private Manager manager;
    public ManagerImp(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void hire(Cashier cashier) {
        cashier.setHired(true);
        System.out.println(cashier.getName()+" is hired!");
        System.out.println();
    }

    @Override
    public void fire(Cashier cashier) {
        if(cashier.getHired()) {
            cashier.setHired(false);
            System.out.println(cashier.getName() + " is fired!");
            System.out.println();
        }
        else
            System.out.println("This cashier was never hired");
    }
}
