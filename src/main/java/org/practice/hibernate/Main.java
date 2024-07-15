package org.practice.hibernate;

import org.practice.hibernate.model.Employee;
import org.practice.hibernate.service.Operations;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Operations operations = new Operations();
//        Employee e = operations.insert(getEmployee());
//        Employee e =getEmployee();
//        System.out.println("Employee Details:"+e);
//
//        e.setSalary(e.getSalary()+19000);
//        Thread.sleep(100);
//        e= operations.update(e);

        System.out.println("Updated Employee Details:"+operations.getEmployeesByDepartment(10));

    }
    static Employee  getEmployee(){
        Employee e = new Employee();
        e.setFirstName("Rainy");
        e.setLastName("Chown");
        e.setSalary(1300000);
        e.setPhoneNumber("4000003");
        e.setDeptId(03);
        e.setHireDate(LocalDate.now().minusYears(1));
        return e;
    }
}
