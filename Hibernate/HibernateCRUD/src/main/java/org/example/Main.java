package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.transaction.internal.TransactionImpl;
import org.hibernate.query.Query;
import java.util.*;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Configuration con=new Configuration().configure().addAnnotatedClass(Employee.class);
        SessionFactory sf= con.buildSessionFactory();

        Session session1=sf.openSession();
        Transaction tx=session1.beginTransaction();
        Employee employee1=new Employee();
        employee1.setId(21);
        employee1.setName("prudhvi");
        employee1.setRole("Associate software engineer");
        session1.save(employee1);

        //fetching the data
        Employee employee2=session1.get(Employee.class,1);
        System.out.println(employee2);

        //deleting the data
        Employee employee3=null;
        System.out.println("before deleting the id-2: "+employee3);
        employee3=session1.get(Employee.class,7);
        //it will delete the employee bases on the id
        //session1.delete(employee3);
        employee3=session1.get(Employee.class,7);
        //so it  print null
        System.out.println("after deleting the id-2: "+employee3);

        //updating the data
        employee3=session1.get(Employee.class,1);
        System.out.println("Before changing the name and role of the id-1: "+employee3);
        employee3.setName("siri");
        employee3.setRole("senior Software Engineer");
        employee3=session1.get(Employee.class,1);
        System.out.println("after changing the name and role of the id-1: "+employee3);

        //fetching all data from the table using HQL.
        Query q=session1.createQuery("from Employee");
        List<Employee> empList=q.list();
        for(Employee e : empList){
            System.out.println(e);
        }

        //to print the single record from the table using the HQL
        Query q2=session1.createQuery("from Employee where id=10");
        Employee emp=(Employee) q2.uniqueResult();
        System.out.println(emp);

        //fetching the particular columns
        Query q3=session1.createQuery("select name,role from Employee");
        List<Object[]> employees= q3.list();
        for(Object[] o: employees)
        {
            System.out.println("name: "+o[0]+"   role: "+o[1]);
        }

        //fetching the particular rows which satisfies the condition
        int a=15;
        //here we are using positional parameters inside the query
        Query q4=session1.createQuery("from Employee where id>:a");
        q4.setParameter("a",a);
        //here you can also use Employee type instead of the Object type.
        List<Object> employees2= q4.list();
        for(Object e: employees2)
        {
            System.out.println(e);
        }


        tx.commit();
        session1.close();
        System.out.println("session1 closed");


        sf.close();
    }
}