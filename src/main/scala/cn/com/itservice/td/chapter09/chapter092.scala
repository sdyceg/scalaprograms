package cn.com.itservice.td.chapter09

/**
  *将函数作为变量
  */
object chapter092 {
  def main(args: Array[String]): Unit = {
    //定义函数变量
    val fdouble=(x:Int)=>{x*2};
    val sdouble=(x:Int)=>{x.toString};
    println(fdouble)
    println(fdouble.getClass.getName)

    //应用函数变量
    println(fdouble(2));
    println(fdouble(3));

    def showNumber(x:Int):Unit={
      println(x);
    }

    val list=List.range(1,11);
    list.foreach(showNumber);

    println("*************************list2********************")
    val list2=list.foreach(fdouble);
    println(list2);//foreach 无返回值

    println("*************************list3********************")
    val list3=list.map(fdouble);  //map返回list[B]
    println(list3);

    println("*************************list4********************")
    val list4=list.map(sdouble);  //map 为 f:A=>B 返回 List[B] 返回的类型与原类型无关
    println(list4);
    println(list4.getClass.getName)

    println("*************************list5********************")
    val list5=list.updated(2,list4);
    println(list5);
    println("*************************fun1 fun2********************")
    val fun1:(Int,Int)=>Int = (x:Int,y:Int)=>{x+y};
    val fun2:(Int,Int)=>Int = _+_

    println(list.reduce(fun2));
  }
}
