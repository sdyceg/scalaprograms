package cn.com.itservice.td.chapter04

/**
  * 继承类时子类的构造器参数中含父类的变量不应声明为 val 或 var
  * 继承时子类构造器可随意调用父类的主构造器或其他辅助构造器
  * 子类的辅助构造器第一行必须为本类主构造器或本类其他构造器，故不能在本类
  * 辅助构造器中调用父类构造器
  */
class Dog(name:String,age:Int,var sound:String)extends Animal(name,age) {
  override def toString: String = {
    s"$name:$age:$sound";
  }
}
