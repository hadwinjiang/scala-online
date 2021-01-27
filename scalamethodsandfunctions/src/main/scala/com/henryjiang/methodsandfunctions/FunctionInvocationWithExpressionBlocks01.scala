package com.henryjiang.methodsandfunctions

object FunctionInvocationWithExpressionBlocks01 extends App {

  var readFinanceData = () => {
    val source = io.Source.fromFile("src/main/resources/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockTicker(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5))
  }

  val records = readFinanceData()

  val getStockDetails = (ticker: String) => records.filter(_.ticker == ticker)

  val ttmSotckDetails = getStockDetails("TTM")
  println("***************")
  println("***************TTM")
  println(ttmSotckDetails)

  val randomStockDetails = getStockDetails {
    val list = List("MSFT", "GOOG", "TM", "TTM", "DB", "BNS")
    val randomNumber = util.Random.nextInt(list.length)
    list(randomNumber)
  }

  println("***************random stock")
  println(randomStockDetails)
}

