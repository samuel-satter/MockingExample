package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeRepositoryImplementation implements EmployeeRepository{

    private final List<Employee> employeeList;

    public EmployeeRepositoryImplementation() {
        this.employeeList = new ArrayList<>();
    }

    public EmployeeRepositoryImplementation(List<Employee> employees){
        this.employeeList = new ArrayList<>();
        employees.forEach(employee -> this.employeeList.add(Integer.parseInt(employee.getId()), employee));
    }

    @Override
    public List<Employee> findAll() {
        return employeeList.stream().toList();
    }

    @Override
    public Employee save(Employee e) {
        for(Employee employee : employeeList){
            if(e.getId().equals(employee.getId())) {
                employee = e;
                return employee;
            }
        }
        employeeList.add(e);
        return e;
    }
}
