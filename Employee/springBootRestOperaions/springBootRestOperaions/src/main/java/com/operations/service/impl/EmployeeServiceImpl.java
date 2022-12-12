package com.operations.service.impl;

import com.operations.exception.ResourceNotFoundException;
import com.operations.model.Employee;
import com.operations.repository.EmployeeRepository;
import com.operations.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeesDetails() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeDetailsBasedOnId(Integer id) {

        /*Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent())
            return employee.get();
        else
            throw new ResourceNotFoundException("Employee", "Id", id);*/

        return employeeRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException(String.format("Employee with id %s is not found to get the details", id));
        });
    }

    @Override
    public Employee updateEmployee(Employee employee, Integer id) {

        //Frist we need to check whether id is present or not in DB
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Employee with Id %s is not found to update", id)));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmailid(employee.getEmailid());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployeeBasedOnId(Integer id) {
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("No Employee with Id %s is found to delete", id)));
        employeeRepository.deleteById(id);
    }

}
