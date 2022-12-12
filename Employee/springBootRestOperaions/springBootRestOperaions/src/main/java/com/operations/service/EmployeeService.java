package com.operations.service;

import com.operations.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getEmployeesDetails();

    Employee getEmployeeDetailsBasedOnId(Integer id);

    Employee updateEmployee(Employee employee, Integer id);

    void deleteEmployeeBasedOnId(Integer id);
}
