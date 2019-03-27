package cn.com.itservice.td.chapter06

/**
  * 用apply新建对象
  */
class UseApply {
  private var name: String = _;
  private var age: Int = _;
  private var gender: Char = _;
  private var address: String = _;

  //定义辅助构造器
  def this(name:String,age:Int,gender:Char,address:String){
    this;//辅助构造器第一句必须调用主构造器，或其他辅助构造器
    this.name=name;
    this.age=age;
    this.gender=gender;
    this.address=address;
  }

  //重写父类toString
  override def toString: String = {
    s"this is UseApply and name:$name,age:$age,gender:$gender,address:$address";
  }

  //定义函数
  def say(words:String):Unit={
    println("I'm $name and i can say $words");
  }

  def showObjectParameter():Unit={
    println(UseApply.MYSIZE);
  }
}

/**
  * 创建伴生对象，名称必须相同，必须位于同一文件中
  * 伴生对象可以访问 类的private属性
  */
object UseApply {

  //伴生对象定义静态常量
  private val MYSIZE:Int=110120;
  //定义apply函数生成对象
  def apply(name:String,age:Int,gender:Char,address:String): UseApply = {
    new UseApply(name,age,gender,address);
  }

  //伴生对象访问类私有属性

  def getPrivateInObject(obj:UseApply): Unit ={
    println("this is in object get priavte parameter===>name:"+obj.name+",address:"+obj.address);
  }
}