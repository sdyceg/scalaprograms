package cn.com.itservice.td.traittest

object MyTrait03 {
  def main(args: Array[String]): Unit = {
    //1.初始化混入，先初始化class对象，然后从左到右初始化trait,
    //2.公共trait只初始化一次
    val data=new Data with MySql with Oracle;
    println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    //1.调用trait中方法从右到左进行，
    //2.右侧的super调用左侧的重写的方法
    //3.最左侧trait的方法调用super,此时调用该trait的父trait的方法
    data.sayHi();

    println("*********************************************************");
    val data2=new Data with Oracle with MySql;
    println("*********************************************************");
    data2.sayHi();
  }
}

trait Persist{
  println("This is level 1 Persist!!!");
  def sayHi();
}

trait DataBase extends Persist{
  println("This is level 2 DataBase!!!");

   def sayHi(): Unit = {
    println("This is level2 DataBase sayHi!!!");
  }
}

trait MySql extends DataBase{
  println("This is level3 mysql!!!");

  override def sayHi(): Unit = {
    println("This is level 3 mysql sayHi!!!");
    super.sayHi();
  }
}

trait Oracle extends DataBase{
  println("This is level3 Oracle!!!");

  override def sayHi(): Unit = {
    println("This is level 3 Oracle sayHi!!!");
//    super.sayHi();
    //通过泛型打破trait叠加的执行顺序，直接调用父trait的方法，跳过左侧trait的方法
    super[DataBase].sayHi();
  }
}

class Data{
  println("This is class Data!!!");
}