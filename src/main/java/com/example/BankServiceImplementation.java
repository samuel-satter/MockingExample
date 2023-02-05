package com.example;

import java.util.HashMap;

public class BankServiceImplementation implements BankService{

    private HashMap<String, Double> listOfPayments = new HashMap<>();
    @Override
    public void pay(String id, double amount) {
        listOfPayments.put(id, amount);
    }

    public double getSinglePayment(String id) {
        return listOfPayments.get(id);
    }

    public void setSinglePayment(String id, double amount) {
        listOfPayments.putIfAbsent(id, amount);
    }

    public HashMap<String, Double> getListOfPayments() {
        return listOfPayments;
    }

    public void setListOfPayments(HashMap<String, Double> listOfPayments) {
        this.listOfPayments = listOfPayments;
    }
}
