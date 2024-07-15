package org.practice.hibernate.service;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

import org.hibernate.query.Query;

import org.practice.hibernate.model.Employee;
import org.practice.hibernate.util.HibernateUtil;

import java.util.List;
public class  Operations {
    Employee employee;

    public Employee insert(Employee employee) {
        try {
            Session ses = HibernateUtil.getSession();
            ses.beginTransaction();
            employee = (Employee)ses.save(employee);
            ses.getTransaction().commit();

        } catch (HibernateException hbe) {
            hbe.printStackTrace();
        }
        return employee;
    }

    public Employee get(long empId) {
        try {
            Session ses = HibernateUtil.getSession();
            ses.beginTransaction();
            employee = ses.load(Employee.class, empId);
            ses.getTransaction().commit();
        } catch (ObjectNotFoundException hbe) {
            hbe.printStackTrace();
        } catch (HibernateException hbe) {
            hbe.printStackTrace();
        }
        return employee;
    }
    public Employee update(Employee employee) {
        try {
            Session ses = HibernateUtil.getSession();
            ses.beginTransaction();
            employee = (Employee) ses.merge(employee);
            ses.getTransaction().commit();
        } catch (HibernateException hbe) {
            hbe.printStackTrace();
        }
        return employee;
    }

    public Employee delete(long id) {
        try {
            Session ses = HibernateUtil.getSession();
            ses.beginTransaction();
            Employee e = get(id);
            ses.delete(e);
            ses.getTransaction().commit();
        } catch (HibernateException hbe) {
            hbe.printStackTrace();
        }
        return employee;
    }
    public List<Employee> getEmployeesByDepartment(int deptId){
        List<Employee> employees = null;
        try {
            Session ses = HibernateUtil.getSession();
            ses.beginTransaction();
            Query<Employee> query = ses.createNativeQuery("CALL GetEmployees(:dept)")
                    .addEntity(Employee.class)
                    .setParameter("dept",10);
            employees = query.list();
        } catch (HibernateException hbe) {
            hbe.printStackTrace();
        }
        return employees;
    }


}
