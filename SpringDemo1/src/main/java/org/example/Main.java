package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        //don't write capital letters, because it should be non-capitalized.
        //it is annotation based configuration
        Vehicle obj=(Vehicle) context.getBean("car");
        obj.drive();

        //xml file based configuration
        Vehicle obj2=(Vehicle) context.getBean("myCar");
        obj2.drive();

        //here we are injecting the property of class using xml file configuration.
        //Tyre tyre=(Tyre) context.getBean("myTyre");
        //System.out.println(tyre);

        Car obj4=(Car) context.getBean("car");
        System.out.println(obj4);
    }
}