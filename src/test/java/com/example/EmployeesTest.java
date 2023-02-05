package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

public class EmployeesTest {

    EmployeeRepository employeeRepository = new EmployeeRepositoryImplementation();
    EmployeeRepositoryImplementation employeeRepositoryImplementation = new EmployeeRepositoryImplementation();
    BankServiceImplementation bankServiceImplementation = new BankServiceImplementation();
    BankService bankService = new BankServiceImplementation();


    @Test
    void shouldPayEmployee() {
        bankServiceImplementation.pay("1", 5000);
        bankServiceImplementation.pay("2", 5000);
        assertEquals(2, bankServiceImplementation.getListOfPayments().size());
    }
    @Test
    void shouldReturnEmptyIfNoEmployeesHaveBeenAdded() {
        assertTrue(employeeRepository.findAll().isEmpty());
    }
    @Test
    void shouldSaveEmployee() {
        Employee employee = new Employee("1", 5000);
        employeeRepository.save(employee);
        assertFalse(employeeRepository.findAll().isEmpty());
    }
    @Test
    void shouldReturnListWithAllEmployees() {
        Employee employee = new Employee("2", 5000);
        Employee employee2 = new Employee("3", 5000);
        Employee employee3 = new Employee("4", 5000);
        Employee employee4 = new Employee("5", 5000);
        employeeRepository.save(employee);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
        employeeRepository.save(employee4);
        assertEquals(4, employeeRepository.findAll().size());
    }
    @Test
    void shouldIncreaseAmountOfPayedEmployees() {
        EmployeeRepository employeeRepository1 = mock(EmployeeRepository.class);
        BankService bankService1 = mock(BankService.class);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1", 5000));
        employeeList.add(new Employee("2", 5000));
        employeeList.add(new Employee("3", 5000));

        when(employeeRepository1.findAll()).thenReturn(employeeList);

        Employees employees = new Employees(employeeRepository1, bankService1);
        assertEquals(3, employees.payEmployees());
        verify(bankService1, times(3)).pay(anyString(), anyDouble());
    }
    @Test
    void shouldThrowRuntimeExceptionWhenSetPaidMethodEqualsFalse() {
        try {
            Employees employees = mock(Employees.class);
            when(employees.payEmployees())
                    .thenThrow(RuntimeException.class);
        } catch (Exception e) {
            System.out.println("Exception caught");
            assertTrue(e instanceof RuntimeException);
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
        Employees employees = new Employees(employeeRepository1, null);
        employees.payEmployees();
        employeeList.forEach(employee -> {
            assertEquals(employee.isPaid(), false);
        });
    }
}


