package org.practice.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.practice.hibernate.manyToMany.Person;
import org.practice.hibernate.manyToMany.Pincode;
import org.practice.hibernate.model.Employee;
import org.practice.hibernate.oneToMany.Comment;
import org.practice.hibernate.oneToMany.Dept;
import org.practice.hibernate.oneToMany.Lecturer;
import org.practice.hibernate.oneToMany.Post;
import org.practice.hibernate.oneToOne.Emp;
import org.practice.hibernate.oneToOne.ParkingSlot;

import java.util.Properties;

public class HibernateUtil {

    static SessionFactory factory = null;
    static {
        Configuration cfg = new Configuration();
        Properties props = new Properties();
        props.put(Environment.URL, "jdbc:mysql://localhost:3306/pin_services");
        props.put(Environment.USER, "root");
        props.put(Environment.PASS, "root");
        props.put(Environment.SHOW_SQL, true);
        props.put(Environment.FORMAT_SQL, true);
        props.put(Environment.HBM2DDL_AUTO, "update");

        cfg.setProperties(props);
        cfg.addAnnotatedClass(Employee.class);
        cfg.addAnnotatedClass(Emp.class);
        cfg.addAnnotatedClass(ParkingSlot.class);
        cfg.addAnnotatedClass(Dept.class);
        cfg.addAnnotatedClass(Lecturer.class);
        cfg.addAnnotatedClass(Post.class);
        cfg.addAnnotatedClass(Comment.class);
        cfg.addAnnotatedClass(Person.class);
        cfg.addAnnotatedClass(Pincode.class);

        factory = cfg.buildSessionFactory();

    }

    public static Session getSession() {
        return factory.openSession();


    }

}
