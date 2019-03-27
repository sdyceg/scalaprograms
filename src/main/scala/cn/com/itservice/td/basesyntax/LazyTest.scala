package cn.com.itservice.td.basesyntax

/**
  * 测试lazy特性
  */
object LazyTest {
  def main(args: Array[String]): Unit = {
    val result1=sum(10,20);//未被声明懒加载立即执行sum()函数
    lazy val result2=sum(11,22);//被声明为lazy直到下一句用到result2时，sum()才被调用
//    println(result2);
  }

  def sum(n1:Int,n2:Int):Int={
    println("sum("+n1+","+n2+")被调用!!!");
    n1+n2;
  }
}
