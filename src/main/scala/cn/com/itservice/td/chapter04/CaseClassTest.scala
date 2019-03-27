package cn.com.itservice.td.chapter04

/**
  * 测试case class 辅助构造器，applay方法等
  */
object CaseClassTest {
  def main(args: Array[String]): Unit = {
    var cat1=new Cat("胖虎",'男',11);
    println(cat1);

    //通过case class 默认apply方法
    var cat2=Cat("胖虎2号",'男',13);
    println(cat2);

    //通过自定义的apply方法
    var cat3=Cat("胖虎3号",'男');
    println(cat3);

  }
}


case class Cat(var name:String,var sex:Char,var age:Int){
  var weight:Double=12.3;

  //重写case class 类方法
  override def toString=s"this cat $name,is a $sex cat and $age years old and $weight kg";

  //辅助构造器
  def this(name:String,sex:Char){
    this(name,sex,9);
  }
}

object Cat{
  //新建伴生对象apply方法
  def apply(name: String,sex: Char):Cat = new Cat(name,sex,22);
}