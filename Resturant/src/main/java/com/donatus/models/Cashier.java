package com.donatus.models;

public class Cashier extends Staff{
    private String standNumber;
    private boolean isHired;
    public Cashier(String name, byte age, String phoneNumber, String email, String standNumber) {
        super(name, age, phoneNumber, email);
        this.standNumber = standNumber;
    }

    public Cashier() {
    }

    public String getStandNumber() {
        return standNumber;
    }

    public void setStandNumber(String standNumber) {
        this.standNumber = standNumber;
    }

    public boolean getHired() {
        return isHired;
    }

    public void setHired(boolean hired) {
        isHired = hired;
    }
}
