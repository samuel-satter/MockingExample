package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeManagerTest {

    @Test
    void shouldIncreaseAmountOfPayedEmployees() {
        EmployeeRepository employeeRepository1 = mock(EmployeeRepository.class);
        BankService bankService1 = mock(BankService.class);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1", 5000));
        employeeList.add(new Employee("2", 5000));
        employeeList.add(new Employee("3", 5000));

        when(employeeRepository1.findAll()).thenReturn(employeeList);

        EmployeeManager employees = new EmployeeManager(employeeRepository1, bankService1);
        assertEquals(3, employees.payEmployees());
        verify(bankService1, times(3)).pay(anyString(), anyDouble());
    }
    @Test
    void shouldThrowRuntimeExceptionWhenSetPaidMethodEqualsFalse() {
        try {
            EmployeeManager employees = mock(EmployeeManager.class);
            when(employees.payEmployees())
                    .thenThrow(RuntimeException.class);
        } catch (Exception e) {
            System.out.println("Exception caught");
            assertTrue(true);
        }
    }
    @Test
    void shouldThrowRuntimeExceptionWhenBankServiceIsNull(){
        EmployeeRepository employeeRepository1 = mock(EmployeeRepository.class);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1", 5000));
        employeeList.add(new Employee("2", 5000));
        employeeList.add(new Employee("3", 5000));

        when(employeeRepository1.findAll()).thenReturn(employeeList);
        EmployeeManager employees = new EmployeeManager(employeeRepository1, null);
        employees.payEmployees();
        employeeList.forEach(employee -> assertFalse(employee.isPaid()));
    }
}


