package cn.com.itservice.td.chapter08

//SubTrait 被 this:Dog=> 限制语句，限制为只能混入到继承了Dog类的子类中
class TraitClass extends Dog with SubTrait {
  override def talk: Unit = {

  }

  override def baseSpeak: Unit = {

  }

  override def baseSay(): Unit = {

  }
}


object TraitClassMain{
  def main(args: Array[String]): Unit = {
    var traitClass=new TraitClass();
  }
}