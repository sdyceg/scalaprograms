package cn.com.itservice.td.chapter08

/**
  * 动态混入特质，重写父特质中方法，动态叠加
  * 初始化从左到右 初始化为静态 继承的初始化顺序
  * 执行从右到左 执行为动态
  */
object AddTraits extends App{
  var mysql1=new Mysql4 with DB4 with File4;//执行从右向左
  mysql1.insert(10);


  println()
  println()
  println()
  println()
  var mysql2=new Mysql4 with File4; //
  mysql2.insert(12);

}

class Mysql4{

}

trait Operater4{
  println("1======>this is Operater4!!!")
  def insert(id:Int)
}

trait Data4 extends Operater4{
  println("2======>this is Data4!!!")

  override def insert(id: Int): Unit = {
    println("插入数据 = "+id)
  }
}

trait DB4 extends Data4{
  println("3-1======>this is DB4!!!")

  override def insert(id: Int): Unit = {
    println("向数据库")
    super.insert(id);
  }
}

trait File4 extends Data4{
  println("3-2======>this is File4!!!")

  override def insert(id: Int): Unit = {
    println("向文件")
    super.insert(id);
  }
}