package cn.com.itservice.td.chapter02

import java.util.Locale

import scala.util.Random

object NumberTest {
  def main(args: Array[String]): Unit = {
    var c:Char='c';
    var b:Byte=1;
    var s:Short=12;
    var i:Int=123;
    var l:Long=1234l;
    var f:Float=12.1f;
    var d:Double=12.12;
    var boolean:Boolean=true;
    println(c.getClass.getName);
    println(b.getClass.getName);
    println(s.getClass.getName);
    println(i.getClass.getName);
    println(l.getClass.getName);
    println(f.getClass.getName);
    println(d.getClass.getName);
    println(boolean.getClass.getName);
    println("*********************************");
    println(Char.MaxValue);
    println(Byte.MaxValue);
    println(Short.MaxValue);
    println(Int.MaxValue);
    println(Long.MaxValue);
    println(Float.MaxValue);
    println(Double.MaxValue);
    println(Char.MinValue);
    println(Byte.MinValue);
    println(Short.MinValue);
    println(Int.MinValue);
    println(Long.MinValue);
    println(Float.MinValue);
    println(Double.MinValue);
    println("*****************scala.math 测试******************");
    println(math.Pi);
    println(math.abs(-123));
    println(math.addExact(1111111112,13));
    println(math.max(1,2))
    println(math.max(1,1.2));
    println("字符串到数字");
    var number1="1234".toInt
    println("1234".getClass.getName);
    var number2="1234".toDouble;
    println(number2.getClass.getName);
//    var number3="helloworld".toInt;
//    println(number3);
    //java.lang.Integer 转换字符串进制
    println(Integer.parseInt("110",2));
    println(Integer.parseInt("1234",8));
//    println(Integer.parseInt("1234",2));

    println("利用隐式转换类完成")
    println("1234".toIntWithRedix(8));
    println("1234".toIntWithRedix(16));

    /**
      * 利用Option Some 和None代替异常
      */
    println(toInt("helloworld").getOrElse(0));

    /**
      * Option加match匹配
      */
    val result1=toInt("123") match{
      case Some(n)=>n;
      case None=>0;
    }
    println("result1="+result1);



    //scala数值强制转换
    var i2:Int=12;
    var l2:Long=12345456453454l;
    var d2:Double=12.34;
    println(12.3.toInt);
    println(i2.toDouble);
    println(l2.toInt);

    //强转之前检查是否可以进行强转
    println(if(i2.isValidByte) i2.toByte else 0);
    println(d2.toShort)
    println(if(d2.isValidShort) d2.toShort else 0);
    //scala 没有++和--，用+=和-=代替
    var i3:Int=18;
//  i3++;
    i3+=1;
    println(i3);

    /**
      * 比较两个浮点数的值，和其他语言中一样，两个应该相等的浮点数有可能实际上是不等的
      */
    val d4=0.1;
    val d5=0.2;
    println(d4+"   "+d5);
    println(d4+d5);//0.30000000000000004
    println(0.3==0.3);
    println((d4+d5)==0.3);

    /**
      * 处理非常大的整数
      */
    val big1:BigInt=BigInt("994884848394832948847548478");
    println(big1);
    println(big1+120);
    println(big1-120);
    val big2:BigDecimal=BigDecimal("994884848394832948847548478");
    println(big2);
    println(big2+120);
    println(big2-120);
    println(big2*3);
    println(big2-12.334);
    println(big2.pow(2));

    /**
      * scala随机数
      */
    var random=Random;
    println(random.getClass);
    println(random.nextInt(100));
    println(random.nextFloat());
    println(random.nextDouble());
    //生成随意长度的Range
//    println(0 to random.nextInt(100));
    var range1=0 to random.nextInt(100);
    println(range1);
    for(j <- range1){
      print(j+"  ");
    }
    println();
    var range2=for(i <- 0 to random.nextInt(10))yield i*2;
    println(range2);

    /**
      * 创建一个数值区间、列表或者数组
      */
    println(Range.count(1,20,1,false));
    var range4=1 to 20;
    range4.foreach(println);

    /**
      * 格式化数字
      */
    val pi=math.Pi;
    printf("pi=%.5f\n",pi);
    printf("%.5f\n".format(pi));
    var locale=new Locale("de","DE");
    var numberFormat=java.text.NumberFormat.getInstance(locale);
    println(numberFormat.format(10000000));
    println(numberFormat.format(12.345));
    var currencyFormat=java.text.NumberFormat.getCurrencyInstance;
    println(currencyFormat.format(123.456789));
    println(currencyFormat.format(1234.56789));
    println(currencyFormat.format(12345.6789));
    println(currencyFormat.format(123456.789));
    println(currencyFormat.format(12345678.9));
    println(currencyFormat.format(123456789));
  }
  /**
    * 用Option None 和Some代替转换异常
    */
  def toInt(str:String):Option[Int]={
    try{
      Some(str.toInt);
    }catch{
      case ex:NumberFormatException=>None;
    }
  }

  /**
    * 隐式转换类解决字符串转数字的进制问题
    */
  implicit class StringToNumberWithRedix(str:String){
    def toIntWithRedix(redix:Int)={
      Integer.parseInt(str,redix);
    }
  }
}
