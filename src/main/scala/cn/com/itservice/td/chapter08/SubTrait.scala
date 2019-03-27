package cn.com.itservice.td.chapter08

trait SubTrait extends BaseTrait1 with BaseTrait2 {
  //限制此特质只能被混入到继承了Dog类的子类中
  this:Dog=>
  def talk;
}
