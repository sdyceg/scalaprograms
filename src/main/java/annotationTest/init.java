package annotationTest;

import java.lang.annotation.*;

@Inherited
@Target(value = {ElementType.FIELD, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface init {
    String value() default "";
}
