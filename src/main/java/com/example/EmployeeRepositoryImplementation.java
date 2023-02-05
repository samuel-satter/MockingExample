package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImplementation implements EmployeeRepository{

    private final List<Employee> employeeList;

    public EmployeeRepositoryImplementation() {
        this.employeeList = new ArrayList<>();
    }

    @Override
    public List<Employee> findAll() {
        return employeeList.stream().toList();
    }

    @Override
    public Employee save(Employee e) {
        employeeList.add(e);
        return e;
    }
}
