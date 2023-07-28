import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface myAnnotation{
    int value();
}

//Applying annotation
class Hello{
    @myAnnotation(value=10)
    public void sayHello(){System.out.println("hello annotation");}
}

//Accessing annotation
@classAnnotation(value=10)
class TestCustomAnnotation1{
    public static void main(String args[])throws Exception{

        Hello h=new Hello();
        Method m=h.getClass().getMethod("sayHello");
        myAnnotation manno=m.getAnnotation(myAnnotation.class);
        System.out.println("value is: "+manno.value());

        MainAnnotation mainAnnotation=new MainAnnotation();
        //to get the method using class object.
        Method m2=mainAnnotation.getClass().getMethod("sayHello");
        MyAnnotation my=m2.getAnnotation(MyAnnotation.class);
        //it prints the annotation values
        System.out.println("default name is:"+my.name());
        Method m3=mainAnnotation.getClass().getMethod("siri");
        MyAnnotation my2=m3.getAnnotation(MyAnnotation.class);
        System.out.println("name is:"+my2.name());

        //to access class level annotation

    }
}