package cn.com.itservice.td.chapter04

object App {
  def main(args:Array[String]):Unit={
    val animal=new Animal("野兽");
    val dog=new Dog("ergou",23,"汪汪");
    println(animal);
    println(dog);
  }
}
