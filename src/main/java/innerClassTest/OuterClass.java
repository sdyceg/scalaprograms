package innerClassTest;

public class OuterClass {
    public String name;
    public OuterClass(String name){
        this.name=name;
    }
    public class InnerClass{
        public String name;
        public InnerClass(String str){
            this.name=str;
        }
        public void innerShow(){
            System.out.println("this is innerClass's name:"+name+" and this is outerClass name:"+OuterClass.this.name);
        }
    }

    public static void main(String[]args){
        OuterClass outer=new OuterClass("outerClass");
        InnerClass inner=outer.new InnerClass("innerClass");
        System.out.println(outer.name);
        inner.innerShow();
    }
}
