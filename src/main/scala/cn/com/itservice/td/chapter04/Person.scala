package cn.com.itservice.td.chapter04

class Person(var firstName:String,var lastName:String,private var sex:Char/**只能在class内部使用*/){
  println("the constructor begins!!!");
  private val HOME = System.getProperty("user.home")
  val age=20;
  override def toString():String=s"$firstName $lastName is $age years old";
  def printHome{println(s"HOME = $HOME")}
  def printFullName: Unit ={
    println(this);
  }

  printHome;
  printFullName;
  println("still in the constructor!!!!");
}

object PersonMain{
  def main(args:Array[String]):Unit={
    var person=new Person("wang","ergou",'m');

    //修改Person 类属性
    person.firstName="Ron";
    person.lastName="Artest";
    println(person);

    //通过调用方法修改类属性
    person.firstName_$eq("Metta");
    person.lastName_$eq("World Peace");
    println(person);

    //val属性无法修改
//    person.age=22;

    //private val、private var无法再类外部访问,但可以在伴生object中访问；
//    var sex=person.sex;
//    println(sex);
//    println(person.HOME)
  }
}