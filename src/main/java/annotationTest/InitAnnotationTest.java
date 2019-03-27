package annotationTest;

import java.lang.reflect.InvocationTargetException;

public class InitAnnotationTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        User user=UserFactory.getUser();
        System.out.println(user.getName());
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getAddress());
        System.out.println("over!!!");
    }
}
