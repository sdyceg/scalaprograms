package cn.com.itservice.td.traittest

object MyTrait01 {
  def main(args:Array[String]):Unit={
    val dog=new Dog;
    println("*************");
    val cat=new Cat;
    println("*************");
//    val dog2=new Dog with Animal;
    val dog3=new Dog2 with Mammal;

  }
}

trait Animal{
  println("This is level 1 Animal!!!");
}

trait OnlandAnimal extends Animal{
  println("This is level 2 OnlandAnimal");
}

trait Mammal extends OnlandAnimal{
  println("This is level 3 Mammal");
}

class Cat extends Mammal{
  println("This is level 4 Cat");
}

class Dog extends Mammal{
  println("This is level 4 Dog");
}

class Dog2 {
  println("This is Dog2!!!");
}