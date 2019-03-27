package cn.com.itservice.td.chapter03

/**
  * 测试match的使用语法
  */
object CaseAllTest {
  def main(args:Array[String]):Unit={
    val test1=1;
    val test2=10;
    val test3="helloworld";

    val test4=List(0,1,2);
    val test5=List(1,2,3,4,5,6,7);
    val test6=Vector(1,2,3,4,5,6);

    val test7=(1,2);
    val test8=(1,2,3);

    val test9:Int=123;
    val test10:Long=123l;
    val test11:Float=123.0f;
    val test12:Double=123.1;
    val test13="nihao";
    val test14=List(3,4,5,6,"hello");
    val test15=Map(("name","ergou"),(1,100));

    var test16=Person("ergou",22);
    var test17=Dog;

    println("test1"+matchCaseTest(test1));
    println("test2"+matchCaseTest(test2));
    println("test3"+matchCaseTest(test3));
    println("test4"+matchCaseTest(test4));
    println("test5"+matchCaseTest(test5));
    println("test6"+matchCaseTest(test6));
    println("test7"+matchCaseTest(test7));
    println("test8"+matchCaseTest(test8));
    println("test9"+matchCaseTest(test9));
    println("test10"+matchCaseTest(test10));
    println("test11"+matchCaseTest(test11));
    println("test12"+matchCaseTest(test12));
    println("test13"+matchCaseTest(test13));
    println("test14"+matchCaseTest(test14));
    println("test15"+matchCaseTest(test15));
    println("test16"+matchCaseTest(test16));
    println("test17"+matchCaseTest(test17));

    println("****************************************************")
    //String to Int with Option[Int]
    myToInt("123") match{
      case Some(x) => println(s"the number is = $x");
      case None =>println(s"a oh!!! translating has failed!!!");
    }

    //给Case语句添加if表达式(守卫）
    val number11=10;
    number11 match{
      case a:Int if a==1 =>println("one,a lonely number");
      case a if (a==2 || a==3) => println(a)
      case a if 1 to 10 contains a =>println("1-10 range:"+a);
      case _ => println("some other value");
    }

    //case结合if
    test16 match{
      case Person(x,y)=> if(y>0 && y<20) println("年龄太小") else println("年龄合适");
      case _ =>println("很遗憾");
    }


    var list=1::2::3::4::5::6::7::8::9::10::Nil;
    println(sum(list));
  }

  def matchCaseTest(parameter:Any)={
    parameter match{
      case 1 | 2 | 3 | 4 => "匹配到数值";
      case 10 => "匹配到数值10";
      case "helloworld" => "匹配到字符串 helloworld";

        //匹配集合
      case List(0,_,_) => "a three-element list with 0 as the first element";
      case List(1,_*) => "a list beginning with 1,having any number of elements";
      case Vector(1,_*) => "a vector starting with 1,having any number of elements";

        //tuples
      case (a,b) => s"got $a and $b";
      case (a,b,c)=> s"got $a and $b and $c";
        //匹配类型
      case x:Int => "匹配到Int 类型,值为="+x;
      case x:Long => "匹配到Long 类型,值为="+x;
      case x:Float => "匹配到Float 类型,值为="+x;
      case x:Double => "匹配到Double 类型,值为="+x;
      case x:String => "匹配到String 类型,值为="+x;
      case x:List[_] => "匹配到List类型，值为="+x;
      case m:Map[_,_] => m.mkString;
//      case x:Person =>s"匹配到Person类型，person.name=${x.name},person.age=${x.age}";//此处需要{}获取对象的属性值
        //匹配case class
      case Person(x,y) => s"匹配到case class Person with name=$x,age=$y";//到达不了，因为前面有 case x:Person
      case Dog => s"匹配到case object Dog";

      case _ => "Unknow"
    }
  }

  def myToInt(parameter:String):Option[Int]={
    try{
      Some(parameter.toInt);
    }catch{
      case ex:Exception => None;
    }
  }

  //用case表达式递归计算List集合中数据的和
  def sum(para:List[Int]):Int={
    para match{
      case Nil => 0;
      case n::rest => n+sum(rest);
    }
  }
}

case class Person(val name:String,val age:Int);
case object Dog;
