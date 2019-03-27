package cn.com.itservice.td.chapter04

/**
  * 辅助构造器测试
  * 辅助构造器调用主构造器（this 调用），并通过参数的不同进行区别
  * 无返回类型
  * 构造器必须先声明在调用
  */
class Pizza(var crustSize:Int,var crustType:String)/*主构造器 该构造器必须存在*/ {

  //辅助构造器1
  def this(crustSize:Int){
    this(crustSize,Pizza.DEFAULT_CRUST_TYPE/*此处调用伴生对象的静态属性*/);
  }

  //辅助构造器2
  def this(){
    this(Pizza.DEFAULT_CRUST_SIZE,Pizza.DEFAULT_CRUST_TYPE);
  }

  override def toString:String=s"A $crustSize inch pizza with a $crustType";
}
object Pizza{
  val DEFAULT_CRUST_SIZE=12;
  val DEFAULT_CRUST_TYPE="THIN";
}


object PizzaMain{
  def main(args: Array[String]): Unit = {

//    Pizza.DEFAULT_CRUST_SIZE=45;

    //用主构造器
    var pizza1=new Pizza(24,"ergou");
    println(pizza1);

    //辅助构造器1
    var pizza2=new Pizza(34);
    println(pizza2);

    //辅助构造器2
    var pizza3=new Pizza();
    println(pizza3);

    //无参时可以省略括号
    var pizza4=new Pizza;
    println(pizza4);

    println(pizza1.crustSize);
    println(pizza1.crustType);

  }
}