package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankServiceImplementationTest {

    BankServiceImplementation bankServiceImplementation = new BankServiceImplementation();

    @Test
    void shouldPayEmployee() {
        bankServiceImplementation.pay("1", 5000);
        bankServiceImplementation.pay("2", 5000);
        assertEquals(2, bankServiceImplementation.getListOfPayments().size());
    }

    @Test
    void shouldGetSinglePaymentAmountFromListUsingId(){
        bankServiceImplementation.pay("1", 5000);
        assertEquals(5000, bankServiceImplementation.getSinglePayment("1"));
    }
}
