package cn.com.itservice.td.chapter04

import cn.com.itservice.td.chapter04

/**
  * scala嵌套类
  */
class OuterClass {
  var name:String="";
  var age:Int= _;
  def this(name:String,age:Int){
    this;
    this.name=name;
    this.age=age;
  }

  //innerClass
  class InnerClass{
    var name:String= _;
    var innerAge:Int = _;
    def this(name:String,innerAge:Int){
      this;
      this.innerAge=innerAge;
      this.innerAge=innerAge;
    }
    def innerShow():Unit={
      println(s"this is innerClass name:$name,and this is outerClass's name:${OuterClass.this.name} and $age");
    }
  }
}
object OuterClass{
  //定义static内部类
  class StaticInnerClass{
    var sname:String= _;
    var sage:Int = _;
    def this(sname:String,sage:Int){
      this;
      this.sname=sname;
      this.sage=sage;
    }
    def sInnerShow():Unit={
      println(s"this is StaticInnerClass's sname:$sname and sage:$sage");
    }
  }
}

object OuterClassMain{
  def main(args: Array[String]): Unit = {
    val outer1=new OuterClass("outer====>outer",11);
    println(outer1.name+","+outer1.age);

    //新建内部类对象外部类对象必须为 val
    var inner=new outer1.InnerClass("inner=====>inner",222);
    inner.innerShow();

    var sInner=new chapter04.OuterClass.StaticInnerClass("sname",333);
    sInner.sInnerShow();
  }
}
