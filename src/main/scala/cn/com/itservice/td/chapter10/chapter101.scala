package cn.com.itservice.td.chapter10

import scala.collection.mutable.ArrayBuffer

/**
  * vector test
  */
object chapter101 {
  def main(args: Array[String]): Unit = {
//    val v1=new Vector[Int](1,10,1);
    val v1=Vector[Int](1,2,3,4,5,6);
    println(v1);

    val v2=Vector(1,2,3,"hello","world",4,5);
    println(v2);
    println(v2.getClass.getName)

    println("*************************< ++ >******************************")
    val v3=v1++v2;
    println(v3);
    println("*************************< ++: >******************************")
    val v4=v1++:v2;
    println(v4);
    println("*************************< +: >******************************")
    //+:在vector头插入数据

    val v5=10+:v1;
    println(v5)
    println((11,12,13)+:v1);

    println("*************************< :+ >******************************")
    //:+在vector尾插入数据
    val v6=v1:+10;
    println(v6)
    println("*************************< /: >******************************")
    // /: foldleft 代替写法 已过时
    val v7=(10/:v1)(_-_)
    println(v7)
    println("*************************< :\\ >******************************")
    // :\ foldright 代替写法
    // 6-100=-94
    // 5-(-94)=99
    // 4-99=-95
    // 3-(-95)=98
    // 2-98=-96
    //  1-(-96)=97
    val v8=(v1:\100)(_-_)
    println(v8)
    println("*************************< addString(StringBuilder) >******************************")
    //addString 把vector加入参数中
    var sb=new StringBuilder;
    var result=v1.addString(sb);
    println(sb);
    println(result);
    println("*************************< addString(StringBuilder,String) >******************************")
    var sb2=new StringBuilder;
    var result2=v1.addString(sb2,"<>");
    println(sb2);
    println(result2);
    println("*************************< aggregate >******************************")
    // aggregate(初始化函数,元素操作函数，分区操作函数）
    var result3=v1.aggregate(10)(((a:Int,b:Int)=>a*b),((p1:Int,p2:Int)=>{println(p1+":"+p2);p1+p2;}))
    println(result3);
    println("*************************< addThen >******************************")
    //提取vector的某个元素应用addThen传入的 函数参数，返回处理的结果
    //如下提取第5个元素 应用(x:Int)=>x+1 因此返回 6
    var result4=v1.andThen((x:Int)=>x+1);
    println(result4(4));
    println("*************************< apply() >******************************")
    var result5=v1.apply(2);
    println(result5);
    println("*************************< applyOrElse >******************************")
    //提取vector的第几个元素，如果没有，执行传入的 函数参数
    //因为v1有第二个元素因此取出该元素3
    //因为v1没有第9个元素因此对 9 执行 (x:Int)=>(x*x) 返回 81
    var result6=v1.applyOrElse(2,(x:Int)=>{x*x});
    println(result6);
    var result7=v1.applyOrElse(9,(x:Int)=>{x*x});
    println(result7);
    println("*************************< canEqual >******************************")
    //子类应重写该方法
    println(v1.canEqual("hellworld"));
    println(v1.canEqual(v1));
    println("*************************< charAt >******************************")
    //只有泛型为Char时才可使用此方法，利用了隐式类转换 和  泛型协变
    var vchar=Vector("hello","world","nihao","zhonguo");
    var vchar2=Vector('h','e','l','l','o','w','o','r');
    println(vchar2.charAt(2));
    println("*************************< chars >******************************")
    var result8=vchar2.chars();
    println(result8.getClass.getName);

    println("*************************< collect >******************************")
    var intPart=new PartialFunction[Int,Int] {
      override def isDefinedAt(x: Int): Boolean = {
        x.isInstanceOf[Int]
      }

      override def apply(v1: Int): Int = {
        v1*3
      }
    }
    var charPart=new PartialFunction[String,String] {
      override def isDefinedAt(x: String): Boolean = {
        x.isInstanceOf[String]
      }

      override def apply(v1: String): String = {
        v1
      }
    }
    val intAndChar=intPart orElse charPart
    var result9=v2.collect({case x:Int=>x*3;case x:String=>x;});
    println(result9);
    println("*************************< collectFirst >******************************")
    //找到第一个可以使用偏函数的元素，并给该元素使用提供的偏函数并返回值
    var result10=v2.collectFirst({case x:String=>x});
    println(result10.get)
    println("*************************< combinations >******************************")
    //有顺序的提取 n 个元素返回，必须是有顺序的
    var resutl11=v1.combinations(3);
    for(i <- resutl11){
      print(i)
    }
    println("*************************< compose >******************************")
    //compose[A](g: A => T1): A => R = { x => apply(g(x)) }
    println(v1.compose((x:Int)=>x+1)(2));
    println("*************************< contains >******************************")
    println(v2.contains("hello"))
    println(v2.contains(10));
    println("*************************< containsSlice >******************************")
    var slice=v1.slice(1,4);
    println(slice);
    println(v1.containsSlice(slice));
    println("*************************< copyToArray >******************************")
    var array=new Array[Int](5);
    array.foreach(print);
    v1.copyToArray(array,1,10);
    array.foreach(print);
    println("*************************< copyToBuffer >******************************")
    var buffer=new ArrayBuffer[Int](10)
    v1.copyToBuffer(buffer);
    println(buffer);
    println("*************************< corresponds >******************************")
    var v10=Vector('1','2','3','4','5','6')
    println(v1.corresponds(v10)((a:Int,b:Char)=>{a==b}))
    println(v1.corresponds(v10)((a:Int,b:Char)=>{true}))
    println("*************************< count >******************************")
    println(v2.count(x=>true));
    println(v2.count(x=>x.isInstanceOf[String]))
    println("*************************< diff >******************************")
    println(v1.diff(v2))
    println("*************************< distinct >******************************")
    var v11=Vector(1,2,3,4,4,2,5,3,2,1);
    println(v11);
    println(v11.distinct)
    println("*************************< drop >******************************")
    println(v1.drop(2))
    println(v1)
    println(v1.dropRight(3))
    println("*************************< dropWhile >******************************")
    /**
      * 去除当前数组中符合条件的元素，这个需要一个条件，就是从当前数组的第一个元素起，就要满足条件，
      * 直到碰到第一个不满足条件的元素结束（即使后面还有符合条件的元素），否则返回整个数组
      */
    println(v2.dropWhile(x=>x.isInstanceOf[Int]))
    println("*************************< endsWith >******************************")
    var v12=v2.slice(4,10);
    println(v2.endsWith(v12));
    println("*************************< exists >******************************")
    println(v1.exists(x=>{x>2}));
    println("*************************< filter >******************************")
    println(v1.filter(_>5));
    println("*************************< filterNot >******************************")
    println(v1.filterNot(_>5))
    println("*************************< find >******************************")
    //找到第一个符合条件的并返回，如果找不到就返回None
    println(v1.find(_>4));
    println("*************************< flatMap >******************************")
    var v13=Vector("我 爱 北 京 天 安 门","天 安 门 上 红 旗 升")
    var v13_1=v13.map(_.split(" "));
    var v13_2=v13.flatMap(_.split(" "));
    println(v13_1)
    println(v13_1.flatten)  //flatten 压平
    println(v13_2)          //flatmap=map+flatten

    println("*************************< fold >******************************")
    println(v1.fold(10)(_-_));//fold折叠顺序不确定，已过时，建议用foldLeft
    println(v1.foldLeft(10)(_-_));//从左到右 10-1-2-3-4-5-6
    println(v1.foldRight(10)(_-_));//从右到左 1-(2-(3-(4-(5-(6-10)))))
    println("*************************< forall >******************************")
    println(v1.forall(_>=1))
    println("*************************< foreach >******************************")
    println(v1.foreach(print));
    println("*************************< genericBuilder >******************************")
    //????????
    println("*************************< groupby >******************************")
    println( v1.groupBy(_>=3));
    println("*************************< grouped >******************************")
    for(i<-v1.grouped(3)){
      println(i)
    }
    println("*************************< hasDefiniteSize >******************************")
    //检测序列是否存在有限的长度，对应Stream这样的流数据，返回false
    println(v1.hasDefiniteSize)
    println(v1.knownSize>0)
    println("*************************< head >******************************")
    //取第一个元素
    println(v1.head);
    println("*************************< headOption >******************************")
    //其第一个元素的Option值
    println(v1.headOption);
    println("*************************< indexOf >******************************")
    //寻找元素的第一个索引，可以设置开始搜索的位置,没找到返回-1
    println(v1.indexOf(3,2))
    println(v1.indexOf(3))
    println("*************************< indexOfSlice >******************************")
    var v20=v1.slice(3,5);
    println(v1.indexOfSlice(v20))
    println(v1.indexOfSlice(v20,4))
    println("*************************< indexWhere >******************************")
    //返回第一个符合条件的元素的位置
    println(v1.indexWhere(_>4),3);
    println(v1.indexWhere(_>4))
    println("*************************< indices >******************************")
    println(v1.indices) //Range 0 until 6
    println("*************************< init >******************************")
    println(v1.init) //Selects all elements except the last.
    println("*************************< inits >******************************")
    //每次递减一个元素，最后返回Nil
    /**
      * Vector(1, 2, 3, hello, world, 4, 5)
      * Vector(1, 2, 3, hello, world, 4)
      * Vector(1, 2, 3, hello, world)
      * Vector(1, 2, 3, hello)
      * Vector(1, 2, 3)
      * Vector(1, 2)
      * Vector(1)
      * Vector()
      */
    for(i<-v2.inits){
      println(i);
    }
    println("*************************< groupMap >******************************")
      var reusult20=v1.groupMap(_>3)(_+1);
      println(reusult20)
    println("*************************< groupMapReduce >******************************")
      //It is equivalent to groupBy(key).mapValues(_.map(f).reduce(reduce)), but more efficient.
      var result21=v1.groupMapReduce(_>3)(_+2)(_+_);
      println(result21)
    println("*************************< intersect >******************************")
      //取交集
      var inter1=Vector(23,45,67,24,28);
      var inter2=Vector(67,34,45,22,21,45);
      println(inter1.intersect(inter2));
    println("*************************< isDefinedAt >******************************")
      println(v1.isDefinedAt(10))   //Tests whether this sequence contains given index.
    println("*************************< isEmpty >******************************")
      println(v1.isEmpty)
      println(v1.nonEmpty)
    println("*************************< isTraversableAgain >******************************")
      //检测是否可重复遍历
      println(v1.isTraversableAgain);
    println("*************************< Iterator >******************************")
      var i1=v1.iterator;
      while(i1.hasNext){
          print(i1.next())
      }
      println(">>>>>>>>>>>>>>>>>>>>>1")
      while(i1.hasNext){
          print(i1.next())
      }
      println(">>>>>>>>>>>>>>>>>>>>1_2")
      var i2=v1.iterator;
      while(i2.hasNext){
          print(i2.next())
      }
      println()
    println("*************************< knownSize >******************************")
      println(v1.knownSize) //The number of elements in this sequence, if it can be cheaply computed, -1 otherwise. Cheaply usually means: Not requiring a collection traversal.
    println("*************************< last >******************************")
      println(v1.last)
    println("*************************< lastIndexOf >******************************")
      println(v1.lastIndexOf(5,v1.length-1))
    println("*************************< lazyZip >******************************")
      var result22=v1 lazyZip v1;
      println(result22)
    println("*************************< lengthCompare >******************************")
      println(v1.lengthCompare(20))
    println("*************************< lift >******************************")
      println(v1.lift(2));  //Turns this partial function into a plain function returning an Option result.
    println("*************************< map >******************************")
      println(v1.map(_*2));
    println("*************************< max >******************************")
      println(v1.max)
    println("*************************< maxBy >******************************")
      println(v1.maxBy(_+100))
    println("*************************< maxByOption >******************************")
      println(v1.maxByOption(_+100))
    println("*************************< maxOption >******************************")
      println(v1.maxOption)
    println("*************************< min >******************************")
      println(v1.min)
      println(v1.minBy(_-10))
      println(v1.minOption)
      println(v1.minByOption(_-10))
    println("*************************< mkString >******************************")
      println(v1.mkString)
      println(v1.mkString(","))
      println(v1.mkString("[[[",",","]]]"));
    println("*************************< orElse >******************************")
      var part100=new PartialFunction[Int,Int] {
          override def isDefinedAt(x: Int): Boolean = {
              x>=6
          }

          override def apply(v1: Int): Int = {
              v1+10
          }
      }
      println(v1.orElse(part100)(10))
      println(v1.orElse(part100)(4))
    println("*************************< padTo >******************************")
      //用指定元素填充到指定长度
      println(v1.padTo(10,10))
    println("*************************< partition >******************************")
      println(v1.partition(_>3))
    println("*************************< partitionWith >******************************")
      println(v2.partitionWith({case i:Int=>Left(i);case str:String=>Right(str)}))
    println("*************************< patch >******************************")
      println(v1.patch(2,v2,4)) //用 v2 替换从 2 索引后的 4 个元素
    println("*************************< permutations >******************************")
      var ii=v1.permutations;
      while(ii.hasNext){
          print(ii.next())
      }
      println()
    println("*************************< prepended >******************************")
      println(v1.prepended(100));
      println(101+:v1);
    println("*************************< prependedAll >******************************")
      println(v1.prependedAll(Vector(100,101,102,103)))
      println(Vector(100,101,102,103):++v1)
      println(Vector(100,101,102,103)++:v1)
      println(v1:++Vector(100,101,102,103))
    println("*************************< product >******************************")
      println(v1.product);  //把集合中的元素相乘
    println("*************************< reduce >******************************")
      println(v1.reduce(_*_))   //1*2*3*4*5*6
      println(v1.reduceLeft(_-_)) //1-2-3-4-5-6
      println(v1.reduceRight(_-_)); //1-(2-(3-(4-(5-6))))
      println(v1.reduceOption(_*_))
      println(v1.reduceLeftOption(_-_))
      println(v1.reduceRightOption(_-_))
    println("*************************< reverse >******************************")
      println(v1.reverse)
      println(v1)
      var i3=v1.reverseIterator;
      while(i3.hasNext){
          print(i3.next())
      }
      println()
    println("*************************< runWith >******************************")
      println(v1.runWith(_+100)(1))
    println("*************************< sameElements >******************************")
      println(v1.sameElements(v2));
    println("*************************< scanLeft >******************************")
      println(v1.scanLeft(3)(_+_))  //从左到右 3,3+1,3+1+2,3+1+2+3,3+1+2+3+4,3+1+2+3+4+5,3+1+2+3+4+5+6
      println(v1.scanLeft(3)(_-_))  //3,3-1,3-1-2,3-1-2-3,3-1-2-3-4,3-1-2-3-4-5,3-1-2-3-4-5-6
    println("*************************< scanRight >******************************")
      println(v1.scanRight(10)(_+_))  //1+2+3+4+5+6+10,2+3+4+5+6+10,3+4+5+6+10,4+5+6+10,5+6+10,6+10,10
      println(v1.scanRight(10)(_-_))  //1-(2-(3-(4-(5-(6-10))))),2-(3-(4-(5-(6-10)))),3-(4-(5-(6-10))),4-(5-(6-10)),5-(6-10),6-10,10
    println("*************************< search >******************************")
      println(v1.search(5));
    println("*************************< segmentLength >******************************")
      println(v1)
      println(v1.segmentLength(_>=3))
    println("*************************< sizeCompare >******************************")
      println(v1.sizeCompare(v1))
      println(v1.sizeCompare(v2))
      println(v1.sizeCompare(10))
    println("*************************< slice >******************************")
      println(v1.slice(2,5))
    println("*************************< sliding >******************************")
      var i4=v1.sliding(3)
      var i5=v1.sliding(3,2)
      while(i4.hasNext){
        print(i4.next())
      }
      println()
      while(i5.hasNext){
        print(i5.next())
      }
      println()
    println("*************************< SortBy >******************************")
      println(v1.sortBy(_+1))
      println(v1.sortBy(_+1).reverse)
    println("*************************< sortWith >******************************")
      println(v1.sortWith(_>_))
    println("*************************< sorted >******************************")
      println(v2.sorted(new Ordering[Any] {
        override def compare(x: Any, y: Any): Int = {
          (x.toString.length)-(y.toString.length)
        }
      }))
    println("*************************< span >******************************")
      //第一个失败后后续元素都省略判断
      var i6=v1.span(_<3)
      println(i6)
    println("*************************< splitAt >******************************")
      println(v1.splitAt(4))
    println("*************************< sum >******************************")
      println(v1.sum)
    println("*************************< tail >******************************")
      println(v1.tail)
    println("*************************< tails >******************************")
      var i7=v1.tails
      while(i7.hasNext){
        println(i7.next())
      }
    println("*************************< take >******************************")
      println(v1.take(2))
      println(v1.takeRight(4))
      println(v1.takeWhile(_>=1))
    println("*************************< to >******************************")

    println("*************************< toArray >******************************")
      var array1=v1.toArray
      println(array1.getClass.getName);
      println(array1.isInstanceOf[Array[Int]])
      for(a <- array1){
        println(a)
      }
    println("*************************< toBuffer >******************************")
      var buffer1=v1.toBuffer
      println(buffer1.getClass.getName)
      println(buffer1)
      var buffer2=buffer:+100
      println(buffer1)
      println(buffer2)
    println("*************************< toIndexdSeq >******************************")
      println(v1.toIndexedSeq)
    println("*************************< toList >******************************")
      println(v1.toList)
    println("*************************< toMap >******************************")
//      println(v1.toMap[Int,Int])
    println("*************************< toSet >******************************")
      println(v1.toSet)
    println("*************************< unzip >******************************")
      var zip1=Vector(1,2,3,4,5,6);
      var zip2=Vector("one","two","three","four","five","six")
      var zips=zip1 zip zip2
      println(zips)
      println(zips.unzip)
    println("*************************< unzip3 >******************************")
      var zip3=Vector((1,"one","good"),(2,"tow","very good"),(3,"three","no good"),(4,"four","bad"))
      println(zip3.unzip3)
    println("*************************< updated >******************************")
      println(v1.updated(3,100))
      println(v1)
    println("*************************< zipAll >******************************")
      println(v1.zipAll(v2,100,"ha"));
    println("*************************< zipWithIndex >******************************")
      println(v1.zipWithIndex)
    println("*************************<  >******************************")
    println("*************************<  >******************************")
    println("*************************<  >******************************")
    println("*************************<  >******************************")
    println("*************************<  >******************************")

  }
}
