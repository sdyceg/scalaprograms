package cn.com.itservice.td.akka

import akka.actor.{Actor, ActorSystem, Props}

import scala.io.StdIn

class HelloActor extends Actor{
  override def receive: Receive = {
    case "你好帅" =>println("竟然说实话，我新欢你这种人！")
    case "丑八怪" =>println("滚犊子！")
    case "stop" =>{
      context.stop(self); //关闭自己的actorRef
      context.system.terminate(); //关闭ActorSystem,即关闭其内部线程池(ExcutorService)
    }
  }
}

object HelloActor{
  /**
    * 创建线程池对象MyFactory,用来创建actor的对象
    */
//  private val MyFactory=ActorSystem("my")  //参数为线程池名

  /**
    * 通过MyFactory.actorOf方法来创建一个actor，注意，Props方法的第一个参数需要传递我们自定义的HelloActor类，
    * 第二个参数是给actor起个名字
    */
//  private val helloActorRef=MyFactory.actorOf(Props[HelloActor],"helloActor")

  def main(args: Array[String]): Unit = {
    var name:String="haha"
    val MyFactory=ActorSystem.create(name)
    val helloActorRef=MyFactory.actorOf(Props[HelloActor],"helloActor")
    var flag=true;
    while(flag){
      print("请输入您想发送的消息:")
      val consoleLine:String=StdIn.readLine()

      helloActorRef ! consoleLine

      if(consoleLine.equals("stop")){
        flag=false;
        println("程序即将结束")
      }
      Thread.sleep(100);
    }
  }
}
