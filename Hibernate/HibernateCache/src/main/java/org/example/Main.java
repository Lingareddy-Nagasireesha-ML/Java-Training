package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



 // Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
//this is showing the second level cha
public class Main {
    public static void main(String[] args) {


        //you have to mention the configuration file inside the configure method if your configuration file name is nor hibernate.cfg.xml,
        //the default configuration file name is hibernate.cfg.xml, so no need to mention the name.
        //Configuration con=new Configuration().configure().addAnnotatedClass(Student.class);
        Configuration con=new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf=con.configure().buildSessionFactory();
        Session session1=sf.openSession();

        Transaction tx=session1.beginTransaction();

        StudentName studentName=new StudentName();
        studentName.setFirstName("sirisha");
        studentName.setLastName("reddy");

        Student student1=new Student();
        student1.setId(24);
        student1.setName(studentName);
        student1.setAddress("kadapa");

        session1.save(student1);
        //the select query is not executed here,because the data was in cache memory
        Student fetching=(Student) session1.get(Student.class,22);
        System.out.println("the fetched data in session1: " +fetching);
        tx.commit();
        session1.close();
        System.out.println("Session1 closed");

        Session session2=sf.openSession();
        //the select query is executed here,because the data is not present in the cache memory.
        Student fetching2=(Student) session2.get(Student.class,22);
        System.out.println("the fetched data in session2: "+fetching2);

        //the select query is not executed here,because the data was in cache memory
        Student fetching3=null;
        fetching3=(Student) session2.get(Student.class,22);
        System.out.println("again the fetched data in session2: "+fetching3);
        /*it's not working because we need to mention the Id of the table instead of object
        fetching=(Student) session1.get(Student.class,student1);
        System.out.println(fetching);*/

        Student deleting=(Student) session2.get(Student.class,22);
        session2.delete(deleting);
        fetching3=(Student) session2.get(Student.class,22);
        System.out.println("the data after deletion in session2: "+fetching3);

        session2.close();

        sf.close();



    }
}