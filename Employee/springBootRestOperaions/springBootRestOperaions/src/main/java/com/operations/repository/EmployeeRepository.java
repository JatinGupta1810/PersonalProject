package com.operations.repository;

import com.operations.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<Entity, Primary Key>
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
