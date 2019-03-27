package cn.com.itservice.td.chapter09

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object chapter093 {
  def main(args: Array[String]): Unit = {
    println("*********add************")
    val add:(Int,Int)=>Int=(x:Int,y:Int)=>{x+y}
    println(computShell(add,1,2));

    println("***********sub***********")
    val sub:(Int,Int)=>Int=baseSub;
    println(computShell(sub,1,2));

    println("***********multi***********")
    val multi:(Int,Int)=>Int=_*_;
    println(computShell(multi,1,2));


    println("***********div***********")
    val div:(Int,Int)=>Int=_/_;
    println(computShell(div,1,2));


    /**
      * 闭包
      */

    var local="hello this is outer paramter";
    showLocal()("<<<<ergou>>>>");            //闭包原因此处输出
                                            //haha this is inner parameter and str

    //闭包2
    var fruit=ArrayBuffer("apple");
    val addToBuckets:String=>Unit=(name:String)=>{
      fruit+=name;
      println(fruit);
    }

    buystuff(addToBuckets,"ergou!!!");
  }

  def buystuff(f:String=>Unit,s:String)={
    f(s);
  }
  def showLocal():(String)=>Unit={
    var local="haha this is inner parameter";
    (str:String)=>{println(s"$local and str")}
  }

  def computShell(f:(Int,Int)=>Int,x:Int,y:Int):Int={
    f(x,y);
  }

  def baseSub(x:Int,y:Int):Int={
    x-y;
  }
}
