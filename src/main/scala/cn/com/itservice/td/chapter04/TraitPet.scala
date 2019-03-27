package cn.com.itservice.td.chapter04

/**
  * 特质不能有构造参数，抽象类可以
  */
trait TraitPet{
  var name:String;
  var age:Int;
  var address:String;

//  def this(name:String,age:Int,address:String){
//    this();
//  }
  //特质中的方法重写仍需override
  override def toString():String={
    s"TraitPet name:$name,age:$age,address:$address";
  }

  //特质中定义未实现的方法
  def say():String;
}
