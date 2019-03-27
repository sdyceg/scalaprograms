package cn.com.itservice.td.chapter04

class Animal(var name:String,var age:Int) {
  //辅助构造器
  def this(name:String){
    this(name,22);//辅助构造器第一行必须调用以定义的主构造器或其他辅助构造器
  }

  override def toString: String = {
   s"$name:$age";
  }
}
