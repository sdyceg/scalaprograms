package cn.com.itservice.td.chapter05

class UsePackageObject {
  tag="this is in UsePackageObject";
  def saywords():Unit={
    println(say("nihao zhongguo!!!"));
    show();
  }
}


object UsePackageObjectApp extends App{

  var upo=new UsePackageObject();
  upo.saywords();
}