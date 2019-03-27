package cn.com.itservice.td.chapter08

//特质 abstract override 调用父特质抽象方法，未实现动态混入时动态调用特质左侧的特质方法

object MixInDemo2 extends App {

//  因为DB5实现了父特质的抽象方法并且没有调用super,而File5 重写的父特质方法并调用的super,所以动态混入
//  File5以左侧的DB5为父特质，File5的super会调用DB5的方法
  var mysql=new Mysql05 with DB5 with File5;
  mysql.insert(10);
}

  class Mysql05 {

  }

  trait Operate05 {
    println("Operater05")

    def insert(id: Int); //抽象方法
  }

  trait File5 extends Operate05 {
    println("File5");

   abstract override def insert(id: Int): Unit = {
      println("向文件")
      super.insert(id); //调用父特质抽象方法,没有abstract override调用出错，因为父特质方法为抽象方法
    }
  }

trait DB5 extends Operate05{
  def insert(id:Int):Unit={
    println("将数据保存到数据库中。。。"+id)
  }
}