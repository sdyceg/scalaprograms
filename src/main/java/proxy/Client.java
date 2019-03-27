package proxy;

public class Client {
    public static void main(String[] args) {
        Person liudehua=new Person("刘德华",44,"男");
        PersonProxy personProxy=new PersonProxy();
//        Person proxy= (Person) personProxy.getPersonProxy(liudehua);
        Animal proxy=  personProxy.getPersonProxy(liudehua);
        proxy.eat("苹果");
//        for(Method m:proxy.getClass().getMethods()){
//            System.out.print(m.getName()+":");
//            Parameter[] parameters = m.getParameters();
//            for(Parameter p:parameters){
//                System.out.print(" "+p.getName());
//            }
//            System.out.println();
//        }

        //调用代理接口中没有的方法，不能调用
//        System.out.println(proxy.PersonOwnMethod("ehllleieke"));
        System.out.println(proxy.returnString("helloworldnihaowode"));
        System.out.println("over!!!");
    }
}
