package cn.com.itservice.td.chapter04

class DogPet(name:String,age:Int,var address:String,var words:String)
extends Pet(name,age) {

  //重写抽象类中字段
  override val breeds:String="dog";

  //赋值重写父抽象类中的 var 字段
  color="red";
  override def toString():String={
    s"DogPet name:$name,age:$age,address:$address,words:$words";
  }

  //实现抽象类抽象方法可以不带override关键字
   override def say(): String = {
    s"DogPet I'm a ($breeds) and I'm a ($color) I can say words:$words";
  }
}


