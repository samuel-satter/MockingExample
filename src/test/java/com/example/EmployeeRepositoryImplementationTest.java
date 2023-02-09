package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeRepositoryImplementationTest {

    EmployeeRepository employeeRepository = new EmployeeRepositoryImplementation();

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
}
