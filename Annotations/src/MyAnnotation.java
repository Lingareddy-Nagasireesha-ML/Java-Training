import java.lang.annotation.*;
import java.lang.reflect.*;

@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{

    String name() default "hello";
}
