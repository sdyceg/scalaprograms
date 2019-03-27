package cn.com.itservice.td.chapter08

trait BaseTrait2 {
  //限制特质混入到一个有给定签名的方法的类型（类、抽象类、或者特质）中。
//  this:{ def showTail():Unit}=>
  def baseSpeak;
}
