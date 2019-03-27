package cn.com.itservice.td.chapter04

abstract class Pet(var name:String,var age:Int) {

  //在抽象类中定义字段，可以在实现子类中重写该字段，该字段必须为 val 不可为 var
  val breeds:String="pet";

  //在抽象类中定义 var 字段，子类可以进行复制，不用制定类型是var 还是 val
  var color:String="unknow";
  override def toString: String = {
     s"abstract class Pet $name,$age";
   }

  //抽象类中定义未实现的方法
  def say():String;
}
