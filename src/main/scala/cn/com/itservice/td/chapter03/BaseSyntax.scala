package cn.com.itservice.td.chapter03

import scala.collection.immutable.HashMap


/**
  * 基本语法测试，for while if ...
  */
object BaseSyntax {
  def main(args:Array[String]):Unit={
    /**
      * for 和 foreach循环
      */
    val a=Array("apple","banana","orange");
    for(e <- a){
      print(e+",");
    }
    println();
    //for循环返集合
    var newArray=for(e <- a) yield e.toUpperCase;
//    println(newArray.getClass);
    newArray.foreach(println);
    println();
    //for循环计数器
    for(i <- 0 to 10){
      print(i+"  ");
    }
    println();
    for(i <- 1 until 10){
      print(i+"  ");
    }
    println();

    for((e,count)<- a.zipWithIndex){
      println(s"$count=$e");
    }
    println("*********************************")
    //for使用守卫
    for(i <- 0 to 10 if i%2==0;if i%3==0){
      println(i);
    }

    //遍历Map
    var map1=HashMap(("key1","value1"),("key2","value2"),("key3","value3"));
    for((key,value)<-map1){
      println(s"$key=$value");
    }
//    println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
//    var fun=(key:String,value:String)=>{println(s"$key=$value");(key,value)};
//    map1.foreach(fun);
    var list=List("list1","list2","list3");
    list.foreach(println(_));

    //在for循环中使用多个计数器
    for(i <- 1 to 10;j <- 1 to 10){
      print(s"($i,$j) ")
      if(j==10){
        println();
      }
    }
    for{
      i <- 1 to 3
      j <- 1 to 5
      k <- 1 to 10
    }println(s"i=$i,j=$j,k=$k");

    //像三元运算符一样使用if(scala没有三元运算符)
    var a100=10;
    val threeComputer=if(a100<10) -a100 else a100;
    println(threeComputer);

    //像switch语句一样使用匹配表达式
    //match 两个case之间不用break(scala没有break)，case之间不互通
    var matchi=18;
    matchi match{
      case 1 => println("January");
      case 2 => println("February");
      case 3 => println("March");
      case 4 => println("April");
      case 5 => println("May");
      case 6 => println("June");
      case 7 => println("July");
      case 8 => println("August");
      case 9 => println("September");
      case 10 => println("October");
      case 11 => println("November");
      case 12 => println("December");
      case _ => println("无法匹配");
    }

    //match匹配类型
    var matchType1:Int=12;
    var matchType2:Long=12l;
    var matchType3:Float=12.2f;
    var matchType4:Double=12.3;
    var matchType5="matchType";
    var matchType6:Char='c';     //match match关键字之前的变量类型标志此match的返回类型
    var matchin:Any=matchType6;
    matchin match{
      case x:Int => println(s"This is Int and value is $x ");
      case x:Float => println(s"This is Float and value is $x");
      case x:Double => println(s"This is Double and value is $x");
      case x:String => println(s"this is String and value is $x");
      case x:Long => println(s"This is Long and value is $x");
      case _ => println("sorray i don't know the type!!!");
    }

    //一条case语句匹配多个条件（用 |）
    val i=5;
    i match{
      case 1 | 3 | 5 | 7 | 9 => println("odd!!");
      case 2 | 4 | 6 | 8 | 10 => println("even");
    }

    val cmd="stop"
    cmd match{
      case "start" | "go" => println("starting")
      case "stop" | "quit" | "exit" => println("stopping");
      case _ => println("doing nothing");
    }

    //match case class  and  case object

    var caseClass=new Start();//创建case class 实例
    var caseObject=Start1;//创建case object 实例,case object 不能new ？？？？？？？？？？

    caseClassMatch(caseClass);
    caseObjectMatch(caseObject);

    //访问匹配表达式缺省case的值
    var defaultValue=10;
    defaultValue match{
      case 1 | 2 | 4 | 5 =>println("helloworld");
      case 6 | 7 | 8 | 9 =>println("nihao");
//      case _ => println("找不到匹配值！！！");
      case default => println(s"找不到匹配值$default");//把默认值赋给一个变量并输出
    }
  }

  /**
    *
    * 匹配case class 需要带有参数列表 如Start() ,case 时会调用case class 的 unapplay()函数
    */
  def caseClassMatch(matchClass:Command)={
    matchClass match{
      case Start() | Go() => println("starting")
      case Stop() | Quit() | Exit() => println("stopping");
      case _ => println("doing nothing");
    }
  }

  /**
    * 匹配case object 不需带参数列表(case object无参数列表）
    */
  def caseObjectMatch(matchObject:Command)={
    matchObject match{
      case Start1 | Go1 => println("starting")
      case Stop1 | Quit1 | Exit1 => println("stopping");
      case _ => println("doing nothing");
    }
  }
}

/**
  * case class 需要带有参数列表即使没有参数，并且比case object 多 applay unapplay函数
  * match 匹配 case class 时需要带有参数列表，即使参数个数为零
  */
abstract class Command;
case class Start() extends Command;
case class Go() extends Command;
case class Stop() extends Command;
case class Quit() extends Command;
case class Exit() extends Command;

/**
  * case object 没有参数列表，并且没有 applay unapplay函数
  */
case object Start1 extends Command;
case object Go1 extends Command;
case object Stop1 extends Command;
case object Quit1 extends Command;
case object Exit1 extends Command;
