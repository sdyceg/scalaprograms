package cn.com.itservice.td.implicittest

object ImplicitClassTest04 {
  def main(args: Array[String]): Unit = {
    val mysql=new Mysql04;
    //Mysql04类有定义sayHi()函数时，优先调用Mysql04的sayHi()函数
    //Mysql04类没有定义sayHi()函数时，自动调用隐式类转换调用隐式类的sayHi()函数
    mysql.sayHi();
  }
  implicit class ImplicitClass(val cl:Mysql04){
    def sayHi():Unit={
      println("This is sayHi in ImplicitClass!!!");
    }
  }
}


class Mysql04{
//  def sayHi():Unit={
//    println("This is sayHi in Mysql04");
//  }
}