package cn.com.itservice.td.chapter08

class Dog extends Animal with WaggingTail with FourLeggedAnimal {
  /**
    * 复写父类val字段不需override也可，var字段不可被复写，直接赋值即可
    */

  val tailNumber: Int = 4 //复写父类抽象字段
  tailSize=17;

  /**
    * variable tailSize cannot override a mutable variable
    * override var tailSize:Int=17;
    */

  override def speak: Unit = {
    println("Dog says 'woof'")
  }

  override def walk: Unit = {
    println("Dog is walking")
  }

  override def run: Unit = {
    println("Dog is running")
  }

//  def showTail():Unit={
//    println(s"this dog has $tailNumber tails and every tail is $tailSize kilomiters long!!!")
//  }
}


object DogMain extends App{
  val dog=new Dog();
  dog.speak;
  dog.startTail;
  dog.stopTail;
  dog.walk;
  dog.run;
//  dog.showTail()
}
