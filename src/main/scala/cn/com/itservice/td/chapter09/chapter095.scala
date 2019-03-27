package cn.com.itservice.td.chapter09

object chapter095 {
  def main(args: Array[String]): Unit = {
    //偏函数1
    val sumpater=sum(1,3,_:Int);
    println(sumpater(4));

    //偏函数2
    val sumpater2=new PartialFunction[Int,Int] {
      override def isDefinedAt(x: Int): Boolean = {
        x<0;
      }

      override def apply(v1: Int): Int = {
        -v1;
      }
    }

    println("*******************");
    println(if(sumpater2.isDefinedAt(1))sumpater2(1));

    println(">>>>>>>>>>>>>>>");
    println(sumpater2.applyOrElse(-12,(x:Int)=>x+24));


    println(">>>>>>>>>>>>>>orElse>>>>>>>>>>>>>>>>")
    val sumpater3=sumpater2.orElse(that = new PartialFunction[Int, Int]{
      override def isDefinedAt(x: Int): Boolean = {
        x>0;
      }

      override def apply(v1: Int): Int = {
        v1*2;
      }
    })
    println(sumpater3(12));
    println(sumpater3(-12));


    println("********************andThen*************")
    val sumpater4=sumpater2.andThen(x=>"haha"*x);
    println(sumpater4(-12))


    println("*****************偏三********************")
    //偏函数3
    val sumpater5:PartialFunction[Int,String]= {case x:Int if x>0 =>"haha"*x}
    println(sumpater5(12));
//    println(sumpater5("nihao!!!"));

    println("*****集合使用偏函数 collect()*******************")
    var list2=List(1,2,3,4,5,"nihao",6,7,"hello");
    var list3=list2.collect({case x:Int=>"haha"*x;case x:String => x;})
    println(list3);
    println(list3(1));
  }

  def sum(a:Int,b:Int,c:Int):Int={
    a+b+c;
  }
}
