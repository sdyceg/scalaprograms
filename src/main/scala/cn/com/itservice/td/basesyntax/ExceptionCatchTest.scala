package cn.com.itservice.td.basesyntax

/**
  * 测试scala异常捕获
  */
object ExceptionCatchTest {
  def main(args: Array[String]): Unit = {
    val n1=0;
    val n2=10;
    try{
      n2/n1;
    }catch{
      //使用case匹配类型
      case e:ArithmeticException=>println("发生了除数为零的情况！！！！");
      case e:Exception=>println("其他异常情况发生！！！");
    }finally {
      println("不论什么情况发生都会执行的地方！！！");
    }
  }
}
