package org.practice.hibernate.model;


import javax.persistence.*;
import lombok.Data;
import lombok.ToString;


import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Data
@ToString
public class Employee {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "salary")
    private double salary;
    @Column(name = "dept_id")
    private int deptId;
    @Column(name = "hire_date")
    private LocalDate hireDate;
}
