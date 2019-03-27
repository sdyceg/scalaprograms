package cn.com.itservice.td.chapter05

/**
  * 链式编程测试
  *
  * 函数值类型 this(确定类不会被扩展)   和  this.type
  */

class Person {
  var fname="";
  var lname="";


  //this.type作为函数返回值类型
  def setFirstName(firstName:String):this.type ={
    fname=firstName
    this
  }

  def setLastName(lastName:String):this.type ={
    lname=lastName
    this;
  }
}

class Employee extends Person{
  var role="";

  def setRole(role:String):this.type ={
    this.role=role;
    this;
  }

  override def toString={
    "%s,%s,%s".format(fname,lname,role);
  }
}


object ThisTypeMain extends App{
  val employee=new Employee;
  employee.setFirstName("wang").setLastName("ergou").setRole("Developer");
  println(employee);
}