package cn.com.itservice.td.chapter05

class StockInfo {
  private var symbol:String= _;
  private var currentPrice:Double= _;
  private var bidPrice:Double= _;

  def this(symbol:String,currentPrice:Double,bidPrice:Double){
    this;
    this.symbol=symbol
    this.currentPrice=currentPrice
    this.bidPrice=bidPrice
  }

  //返回tuple

  //不写return关键字和返回值类型，函数自动推断返回值类型
  def getStockInfo1()={
     (this.symbol,this.currentPrice,this.bidPrice);
  }


  //声明返回值类型为Any可返回任意类型
  def getStockInfo2():Any={
    return (this.symbol,this.currentPrice,this.bidPrice);
  }

  //准确声明返回 Tuple3[String,Double,Double] 类型，泛型参数不可少
  def getStockInfo3():Tuple3[String,Double,Double]={
    return (this.symbol,this.currentPrice,this.bidPrice);
  }
}


object StockInfoTest{
  def main(args: Array[String]): Unit = {
    val stockInfo=new StockInfo("sdyceg",22.45,105.3);
    println("stockInfo.getStockInfo1()=========>"+stockInfo.getStockInfo1());
    println("stockInfo.getStockInfo2()=========>"+stockInfo.getStockInfo2());
    println("stockInfo.getStockInfo3()=========>"+stockInfo.getStockInfo3());
  }
}