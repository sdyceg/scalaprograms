package cn.com.itservice.td.implicittest

object ImplicitTest02 {
  def main(args: Array[String]): Unit = {
    val mysql=new MySql1;
    mysql.sayHi();
    //没有隐式转换没法用mysql实例调用Oracle类的方法
    mysql.delete();
  }

  /**
    * 隐式转换函数
    * @param m
    * @return
    */
  implicit def addDelete(m:MySql1) : Oracle1 = {
    new Oracle1;
  }
}

class MySql1{
  def sayHi():Unit={
    println("This is sayHi in MySql!!!");
  }
}

class Oracle1{
  def delete():Unit={
    println("This is delete in Oracle!!!");
  }
}
