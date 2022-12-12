package com.operations.model;

import jakarta.persistence.*;
import lombok.Data;

@Data //(No need to create setters and getters)(lombok generate getter and setter only)
@Entity
@Table(name = "EmployeesDetails")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "First_Name", nullable = false) //(nullable = false) means it cant be null
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Email_Id")
    private String emailid;

}

