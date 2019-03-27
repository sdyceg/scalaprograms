package cn.com.itservice.td.chapter04

class CatPet(name:String,age:Int,var words:String) extends Pet(name,age) {

  //重写抽象类中字段
  override val breeds:String="cat";

  override def toString: String = {
    s"CatPet name:$name,age:$age,words:$words";
  }
  override def say(): String = {
    s"Catpet I'm a ($breeds) and I'm a ($color) and  I can say words:$words";
  }

//  def this(name:String,age:Int,words:String){
//    this()
//  }
}
