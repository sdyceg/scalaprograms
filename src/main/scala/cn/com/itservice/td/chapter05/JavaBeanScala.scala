package cn.com.itservice.td.chapter05

import java.io.IOException

import scala.beans.BeanProperty


class JavaBeanScala {
  @BeanProperty //此注解可以生成JavaBean 类型的get/set 方法
  var name: String = _;
  @BeanProperty
  var age: Int = _;
  @BeanProperty
  var gender: Char = _;
  @BeanProperty
  var address: String = _;

  def this(name: String, age: Int, gender: Char, address: String) {
    this;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.address = address
  }

  //定义变参函数，用*符号，必须将变参参数放在最后一个
  def printlnAll(num1: Int, str1: String, num2: Float, otherNumer: Double*): Unit = {
    println(s"num1:$num1,str1:$str1,num2:$num2");
    for (param <- otherNumer) {
      println(param);
    }
  }

  //scala函数声明抛异常，用@Throws注解
  @throws(classOf[IOException])
  def showThrows(): Unit = {
    throw new IOException("this is a @throws test,don't worry!!!");
  }
}


object JavaBeanScalaTest {
  def main(args: Array[String]): Unit = {
    val javaBeanScala = new JavaBeanScala("ergou", 22, 'm', "济南");
    println("用scala默认生成的访问方法")
    println("javaBeanScala.name======>" + javaBeanScala.name);
    println("javaBeanScala.age======>" + javaBeanScala.age);
    println("javaBeanScala.gender======>" + javaBeanScala.gender);
    println("javaBeanScala.address()======>" + javaBeanScala.address);

    println()
    println()
    println()

    println("用@BeanProperty生成的 get/set 访问方法")
    println("javaBeanScala.getName======>" + javaBeanScala.getName);
    println("javaBeanScala.getAge======>" + javaBeanScala.getAge);
    println("javaBeanScala.getGender======>" + javaBeanScala.getGender);
    println("javaBeanScala.getAddress()======>" + javaBeanScala.getAddress());


    println()
    println()
    println()
    println("变参函数测试")
    javaBeanScala.printlnAll(12, "hello erogu!!!", 22.3F, 23.1, 23.2, 23.3, 23.4, 23.5, 23.6);


    println()
    println()
    println()
    try {
      javaBeanScala.showThrows();
    } catch {
      case e: IOException => println(e.getMessage);
      case _ => println("处理不了，另请高明吧！！！");
    }

    //classOf[T] 代替 java  xxx.class
    println(classOf[JavaBeanScala]);
  }
}