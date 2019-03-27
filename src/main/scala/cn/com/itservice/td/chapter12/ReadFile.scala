package cn.com.itservice.td.chapter12

import scala.io.Source

/**
  * scala只提供文本文件的读取，不提供写，写用java的api
  */

object ReadFile {
  def main(args: Array[String]): Unit = {
    var file=Source.fromFile("f:/files/8888g.log")
    for(l <- file.getLines()){
      println(l)
    }
    file.close()
  }
}
