package com.operations.controller;

import com.operations.model.Employee;
import com.operations.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //creating employee RestApi
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }


    //get
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployee() {
        //throw new RuntimeException();
        return new ResponseEntity<>(employeeService.getEmployeesDetails(), HttpStatus.OK);
    }

    //get data based on id
    /*@GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeBasedOnId(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(employeeService.getEmployeeDetailsBasedOnId(id), HttpStatus.OK);
    }*/

    //http://localhost:8080/api/employees/getDetails?Id=2
    @GetMapping("getDetails")
    public Employee getEmployeeBasedOnId(@RequestParam("Id") Integer id) {
        return employeeService.getEmployeeDetailsBasedOnId(id);
    }

    //update the employee table
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployeeDetail(@RequestBody Employee employee, @PathVariable("id") Integer id) {
        return new ResponseEntity<>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    //delete employee based on id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployeeBasedOnId(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    /*@ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorMessage handleExcpetion(ResourceNotFoundException resourceNotFoundException) {
        return new ErrorMessage(HttpStatus.CONFLICT.value(), String.format("Employee with Id is not found"));
    }*/
}
