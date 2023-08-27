package com.donatus.implementation;

import com.donatus.models.Cashier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashierImpTest {
    Cashier cashier = new Cashier();
    CashierImp cashierImp = new CashierImp(cashier);


    @Test
    void addToStock() {
        assertTrue(cashierImp.addToStock());
    }

    @Test
    void dispenseReceipt() {
    }
}