package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class EmployeeTest {

    @Test
    void shouldReturnFalseWhenEmployeeNotPaid() {
        Employee employee = new Employee("1", 50000);
        Assertions.assertFalse(employee.isPaid());
    }

    @Test
    void shouldReturnRightId() {
        Employee employee2 = new Employee("2", 50000);
        assertEquals(2, Integer.parseInt(employee2.getId()));
    }
    @Test
    void shouldSetRightId() {
        Employee employee3 = new Employee("3", 50000);
        assertEquals(3, Integer.parseInt(employee3.getId()));
        employee3.setId("4");
        assertEquals(4, Integer.parseInt(employee3.getId()));
    }
    @Test
    void shouldSetRightSalary() {
        Employee employee4 = new Employee("5", 50000);
        assertEquals(50000, (employee4.getSalary()));
        employee4.setSalary(100000);
        assertEquals(100000, (employee4.getSalary()));
    }
}

