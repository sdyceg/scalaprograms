package cn.com.itservice.td.implicittest

object ImplicitTest01 {
  def main(args: Array[String]): Unit = {
    val i:Int = 3.5
  }
  implicit def f1(d:Double):Int= {
    d.toInt
  }
}
