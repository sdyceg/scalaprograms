package cn.com.itservice.td.chapter04

trait OptionAmimal {

  //特质中未赋值的字段自动为抽象字段，子类必须实现，
  val name:String="OptionAmimal";
  var age:Int=22;

  override def toString: String = {
    s"this is trait OptionAmimal name:$name,age:$age";
  }
}
