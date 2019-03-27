package cn.com.itservice.td.traittest

object MyTrait04 {
  def main(args: Array[String]): Unit = {
    val myTrait04=new MyTrait04  with DB5 with File5;
    myTrait04.insert(999);
  }
}

trait Operator5{
  def insert(id:Int);
}

trait DB5 extends Operator5{
  override def insert(id: Int): Unit = {
    println("This is inser in DB5");
  }
}
trait File5 extends Operator5{
//   override def insert(id: Int): Unit = {
//    println("This is insert in File5!!!");
//    super.insert(id);//运行时出错，父trait没有实现insert；
//  }

  //当我们给某个方法增加了abstract override后，就是明确的告诉编译器，该方法确实是重写了父特质
  //的抽象方法，但是重写后，该方法仍然是一个抽象方法(因为没有完全的实现，需要其他特质继续实现[通过
  // 混入顺序实现])
  abstract override def insert(id: Int): Unit = {
      println("This is insert in File5!!!");
      super.insert(id);//运行时出错，父trait没有实现insert；
    }
}

class MyTrait04 {
  println("This is MyTrait04");
}