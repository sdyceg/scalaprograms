package cn.com.itservice.td.chapter10

import scala.collection.immutable.ListSet
import scala.collection.mutable

object MapTest {
  def main(args: Array[String]): Unit = {
    var map1=new mutable.HashMap[Int,String];
    var map2=Map(1->"one",2->"tow",3->"three",4->"four",5->"five")
    println(map2)
    var map3=Map((6,"six"),(7,"seven"),(8,"eight"),(9,"nine"),(10,"ten"))
    println(map3)
    map3+=((11,"eleven"));
    println(map3)
    map3-=11
    println(map3)

    map3+=(11->"eleven")
    println(map3)

    var mmap1=mutable.HashMap.empty[Int,String];
    mmap1+=(1->"one");
    println(mmap1)

    mmap1(1)="oneupdate"
    println(mmap1)

    for((key,value) <- map2){
      println(key+"============>"+value);
    }
    println("*************************< foreach >******************************")
    map2.foreach(x=>println(x._1+"========>"+x._2))

    println("*************************< map >******************************")
//    map3.map[String,Int]((x,y)=>(y,x))
    println(mmap1.map({case (x,y)=>(y,x)}))
    println(map2.map((x:Tuple2[Int,String])=>(x._2,x._1)))

    println("*************************<  >******************************")
     println(map2.keys.exists(_>7))
    println("*************************< retain >******************************")
    println(mmap1.filterInPlace((x,y)=>x>1))

    println("*************************<  >******************************")
    println(map2.toSeq.sortWith(_._2<_._2))
    println("*************************<  >******************************")
    println(map2.keysIterator.max)
    println(map2.valuesIterator.max)
    println("*************************< set >******************************")
    var set1=Set(133,52,13,74,23,12,10,6,9,3)
    println(set1)
    println("*************************<  >******************************")
    println(set1+=1);
    println(set1)
    println("*************************< TreeSet >******************************")
    var treeSet1=mutable.TreeSet(133,52,13,74,23,12,10,6,9,3)
    println(treeSet1)
    println("*************************< LinkedHashSet >******************************")
    var linkedHashSet1=mutable.LinkedHashSet(133,52,13,74,23,12,10,6,9,3)
    println(linkedHashSet1)
    println("*************************< ListSet >******************************")
    var listSet1=ListSet(133,52,13,74,23,12,10,6,9,3)
    println(listSet1)
    println("*************************< map.groupBy >******************************")
    println(map2.groupBy(_._1));
    println("*************************<  >******************************")
    println("*************************<  >******************************")
    println("*************************<  >******************************")
    println("*************************<  >******************************")
    println("*************************<  >******************************")
    println("*************************<  >******************************")
    println("*************************<  >******************************")
    println("*************************<  >******************************")
    println("*************************<  >******************************")
    println("*************************<  >******************************")
    println("*************************<  >******************************")
    println("*************************<  >******************************")
    println("*************************<  >******************************")
  }
}
