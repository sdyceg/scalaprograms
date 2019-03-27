package annotationTest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserFactory {
    public static User getUser() throws InvocationTargetException, IllegalAccessException {
        User u=new User();
        Method[] methods = u.getClass().getMethods();
//        getFields无法获取private 的字段
//        Field[] fields = u.getClass().getFields();
        Field[] declaredFields = u.getClass().getDeclaredFields();
        for(Method m: methods){
            if(m.isAnnotationPresent(init.class)){
                init annotation = m.getAnnotation(init.class);
                m.invoke(u,annotation.value());
            }
        }
        for(Field f:declaredFields){
            if(f.isAnnotationPresent(init.class)){
                f.setAccessible(true);  //设置private属性访问权限
                init annotation = f.getAnnotation(init.class);
//                System.out.println(annotation.value());
                f.set(u,annotation.value());
            }
        }
        return u;
    }
}
