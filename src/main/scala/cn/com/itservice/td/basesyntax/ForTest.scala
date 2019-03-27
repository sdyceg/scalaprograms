package cn.com.itservice.td.basesyntax

/**
  * for循环形式测试
  */
object ForTest {
  def main(args: Array[String]): Unit = {
    //第一种for循环
    for(i <- 1 to 10){
      println("i="+i);
    }
    println("**************************************************");
    //第二种for循环,带有守卫变量或条件
    for(j <- 1 to 10 if j%2==0;if j%3==0){
      println("j="+j);
    }
    println("**************************************************");
    //第三种for循环，反向reverse
    for(k <- 1 to 10 reverse){
      println("k="+k);
    }
    println("**************************************************");
    //第四种for循环，用Range代替(1 to 10) Range(start,end,step),步长为2
    for(m <- Range(1,10,2)){
      println("m="+m);
    }
    println("**************************************************");
    //第五种for循环，用返回集合
    val forResult=for(l <- 1 to 10) yield {l+3}
    println("forResult="+forResult);

    println("****************************************************")
    //一种嵌套for循环
    for(n <- 1 to 5;o <- 1 to 5 reverse){
      println("n="+n+"  o="+o);
    }

    println("****************************************************")
    //for引入变量
    for(p <- 1 to 10;q=p-4){
      println("q="+q);
    }
  }
}
