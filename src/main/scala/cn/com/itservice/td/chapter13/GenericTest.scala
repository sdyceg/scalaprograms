package cn.com.itservice.td.chapter13

/**
  * 泛型测试  上限 <: 下限 >:
  */
object GenericTest {
  def main(args: Array[String]): Unit = {
    var f1:Friend[Person]=new Friend[Person](new Person);
    f1.speak();

    var dog=new Dog;
    var person=new Person;
    var obj=new Object
    var other=new Other

    show(dog);
    show(person)
    show(obj)
    show(other)
  }

  /**
    * 下限可以接受任何类型的参数因为都可以向上转型为 Object 或 Any
    * @param param
    * @tparam T
    * @return
    */
  def show[T>:Person](param:T):T={
    println(param.getClass.getName)
    param
  }
}


class Friend[T<:Animal]{
  var obj:T= _
  def this(obj:T){
    this;
    this.obj=obj;
  }
  def speak(): Unit ={
    println("I can speak:"+obj.speak);
  }
}

trait Animal{
  def speak:String;
}

class Dog extends Animal{
  def speak:String={
    "wangwang!!!"
  }
}

class Person extends Animal{
  def speak:String={
    "hello world!!!"
  }
}

class Other{
}