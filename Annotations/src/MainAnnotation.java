import java.lang.reflect.*;
public class MainAnnotation {
        @MyAnnotation()
        public void sayHello()
        {
            System.out.println("hello");
        }
        @MyAnnotation(name="siri")
        public void siri()
        {
            System.out.println("siri");
        }

}
