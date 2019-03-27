package cn.com.itservice.td.chapter09

object Chapter091 {
  def main(args: Array[String]): Unit = {
    val list1=List.range(1,11);
    val events=list1.filter((x:Int)=>{x%2==0});
    println("events====>"+events);

    val events2=list1.filter(x=>x%2==0);
    println("events2===>"+events2)

    //当参数在函数中只出现一次时，scala允许使用 _ 通配符替换变量名
    val events3=list1.filter(_%2==1);
    println("events3===>"+events3)

    list1.foreach((x:Int)=>{println(x)})
    list1.foreach(x=>println(x))
    list1.foreach(println(_))

    //如果一个函数字面量只有一条语句，并且该语句只接受一个参数，那么参数不需要特别指定，也不需要显示声明
    list1.foreach(println)

    //定义函数字面量

  }

}
