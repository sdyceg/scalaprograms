package cn.com.itservice.td.basesyntax

import util.control.Breaks._

/**
  * scala Break测试，注意scala没有break关键字，使用break()函数代替
  */
object BreakTest {

  def main(args: Array[String]): Unit = {

    //
    //    for(i <- 1 to 100){
    //      if(i>15){
    //        break()
    //      }
    //      println("i="+i);
    //    }
    //    println("over!!!");//因break()直接抛出异常该代码得不到执行


    breakable({
      for (i <- 1 to 100) {
        if (i > 15) {
          break()
        }
        println("i=" + i);
      }
      println("over in breakable!!!!");//逻辑关系该代码得不到执行
    })
    println("over!!!"); //用breakable包裹break()可以处理异常，使改行代码执行
  }
}
