package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {




        Configuration con=new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Laptop.class);
        SessionFactory sf=con.buildSessionFactory();

        Session session1=sf.openSession();
        Transaction tx=session1.beginTransaction();

        Laptop laptop=new Laptop();
        laptop.setId(131);
        laptop.setLapName("HP");

        Employee employee=new Employee();
        employee.setId(31);
        employee.setName("vani");
        employee.getLaptop().add(laptop);

        laptop.setEmployee(employee);

        //System.out.println(laptop);
        //System.out.println(employee);

        session1.save(employee);
        session1.save(laptop);

        Laptop l1=session1.get(Laptop.class,120);
        System.out.println("the laptop is:"+l1);


        tx.commit();
        session1.close();
    }
}