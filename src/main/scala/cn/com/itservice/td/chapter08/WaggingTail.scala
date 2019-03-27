package cn.com.itservice.td.chapter08

trait WaggingTail {
  var tailSize:Int=14 //concrete
  val tailNumber:Int  //抽象字段，子类必须实现
  def startTail{println("tail started")}
  def stopTail{println("tail stopped")}
}
