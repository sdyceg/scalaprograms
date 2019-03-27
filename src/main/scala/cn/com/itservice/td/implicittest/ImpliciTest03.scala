package cn.com.itservice.td.implicittest

object ImpliciTest03 {
  def main(args: Array[String]): Unit = {
    //隐式变量自动当做默认参数传入sayHi函数
    implicit val str="hello,i love china!!!";
    //不能带小括号，带有小括号表示调用无参函数
//    sayHi();
    sayHi;
  }

  def sayHi(implicit str:String):Unit={
    println(str);
  }
}

