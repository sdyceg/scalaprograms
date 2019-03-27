/**
  * scala中包后可以加{}
  */
package cn.com.itservice.td.chapter07 {

  class Foo {
    override def toString: String = {
      s"this is cn.com.itservice.td.chapter07.Foo"
    }
  }
  class Bar{
    override def toString: String = {
      s"this is cn.com.itservice.td.chapter07.Bar"
    }
  }

  class School{
    override def toString: String = {
      s"this is cn.com.itservice.td.chapter07.School"
    }
  }

  /**
    * scala中package可以嵌套
    */
  package customer {

    class Foo {
      override def toString: String = {
        s"this is cn.com.itservice.td.chapter07.customer.Foo"
      }
    }
  }
}

/**
  * scala中可以在包中定义其他包,编译完成后直接放到 classpath:database包下
  */
package database{
  class Foo {
    override def toString: String = {
      s"this is database.Foo"
    }
  }
}


object PackageMain{
  def main(args: Array[String]): Unit = {
    var foo1=new cn.com.itservice.td.chapter07.Foo();
    var foo2=new cn.com.itservice.td.chapter07.customer.Foo();
    var foo3=new database.Foo();

    println(foo1);
    println(foo2);
    println(foo3);
  }
}
