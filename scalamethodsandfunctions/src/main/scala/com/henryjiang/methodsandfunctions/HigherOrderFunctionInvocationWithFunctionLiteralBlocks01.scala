package com.henryjiang.methodsandfunctions

object HigherOrderFunctionInvocationWithFunctionLiteralBlocks01 extends App {

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

  val getStockDetails = (ticker: String, extractFunction: StockTicker => Float) => {
    val filteredRecords = records.filter(_.ticker == ticker)
    assert(filteredRecords.length == 1)
    extractFunction(filteredRecords(0))
  }

  val ttmStockDetails = getStockDetails("TTM", (record: StockTicker) => record.high)
  println("***************TTM")
  println(ttmStockDetails)

  val googStockDetails = getStockDetails("GOOG", (record: StockTicker) => record.low)
  println("***************GOOG")
  println(googStockDetails)
}

