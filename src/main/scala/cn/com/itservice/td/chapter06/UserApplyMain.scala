package cn.com.itservice.td.chapter06

object UserApplyMain extends App{

  //用伴生类 apply方法生成对象
  val useApply=UseApply("ergou",22,'m',"济南");
  useApply.say("nihao zhonguo!!!");
  useApply.showObjectParameter();
  println(useApply);

  //伴生对象访问类私有属性
  UseApply.getPrivateInObject(useApply);
}
