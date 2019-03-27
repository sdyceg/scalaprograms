package cn.com.itservice.td.chapter08

/**
  * 特质动态混入
  */
object MixInDemo1 {
  def main(args: Array[String]): Unit = {
    //类混入特质
    var db=new Oracle with Operate3 {

      override def delete: Unit = {

      }
    };
    db.insert(10);

    //无抽象方法的 abstract class 动态混入
    var mysql=new Mysql with Operate3 {
      override def delete: Unit = {

      }
    };
    mysql.insert(3);

    //动态混入带有抽象方法的抽象类
    /**
      * var mongodb=new Mongodb {
      * override def info(): Unit = {
      *
      * }
      * } with Operate3;  错误
    */


    //实现抽象类的抽象方法或特质的抽象方法都要在最后追加抽象方法的实现
    var mongodb=new Mongodb with Operate3{
      override def info(): Unit = {
        println("this is mongodb!!!");
      }

      override def delete: Unit = {

      }
    }

    mongodb.info();
    mongodb.insert(10);




  }
}

trait Operate3{
  def insert(id:Int):Unit={
    println("插入数据"+id)
  }
  def delete;
}

class Oracle{

}

abstract class Mysql{

}

abstract class Mongodb{
  def info();
}