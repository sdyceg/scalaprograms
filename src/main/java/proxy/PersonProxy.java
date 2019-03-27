package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PersonProxy implements InvocationHandler {

    private Animal animal;
    public PersonProxy(){
    }
    public Animal getPersonProxy(Animal person){
        this.animal=person;
        person.eat("helloworld");
        return (Animal) Proxy.newProxyInstance(person.getClass().getClassLoader(),person.getClass().getInterfaces(),this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass().getName());
         return method.invoke(animal,args);
    }
}
