package cn.com.itservice.td.chapter09

/**
  * 使用部分应用函数 偏函数
  */
object chapter094 {
  def main(args: Array[String]): Unit = {
    val f = sum(1, 2, _: Int) //容易改变的参数用 _ 代替
    println(f(3));

    println("*****************************************************")
    println(greeting("chinese")("二狗"))

    println("*///////////////////////////////////////////////////////*")
    //定义偏函数
    val divide=new PartialFunction[Int,Int] {
      override def isDefinedAt(x: Int): Boolean = x>=10;

      override def apply(v1: Int): Int = {
        v1+30;
      }
    }
    println(divide(9));
  }

  def sum(a: Int, b: Int, c: Int): Int = {
    a + b + c
  }

  def greeting(language: String) = (words: String) => {
    language match {
      case "english" => "hello " + words;
      case "chinese" => "你好 " + words;
    }
  }
}
