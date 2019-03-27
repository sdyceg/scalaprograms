package cn.com.itservice.td.chapter07
//scala可以一次引入多个指定类,并可以给类取别名
import cn.com.itservice.td.chapter07.{Foo, Bar => Foo2}




class ManyImportAndRandomImport {
  import scala.beans.BeanProperty
  @BeanProperty
  var name:String="";
  def showFoo(foo:Foo):Unit={
    println(foo);
  }


  def showFoo2(foo:Foo2):Unit={
    println(foo);
  }

  //scala中可以在代码任意位置引入包,只在引入的大括号内有用
  //但须先import 在使用引用类
  import cn.com.itservice.td.chapter07.School
  def showFoo3(foo:School):Unit={
    println(foo);
  }
}

object ManyImportAndRandomImportMain extends App{
//  @BeanProperty
  var foo1=new Foo;
  var foo2=new Foo2;
  var foo3=new School;
  var miari=new ManyImportAndRandomImport;
  miari.showFoo(foo1);
  miari.showFoo2(foo2);
  miari.showFoo3(foo3);
}
