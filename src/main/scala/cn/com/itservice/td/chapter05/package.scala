package cn.com.itservice.td

package object chapter05{
  var tag:String="I'm package object";
  def show():Unit={
    println(this.tag);
  }

  def say(words:String):String={
    return "this is package object speaking "+words;
  }
}
