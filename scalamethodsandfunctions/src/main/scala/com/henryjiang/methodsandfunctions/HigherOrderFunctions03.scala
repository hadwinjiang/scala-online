package com.henryjiang.methodsandfunctions

object HigherOrderFunctions03 extends App {

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
  println(records.getClass)

  for (record <- records) {
    println(record)
  }

  val getExtractFunction = (functionName: String, records: Vector[StockTicker]) => {
    if (functionName == "high") {
      () => for (record <- records) yield (record.ticker, record.high)
    } else if (functionName == "open") {
      () => for (record <- records) yield (record.ticker, record.open)
    } else if (functionName == "close") {
      () => for (record <- records) yield (record.ticker, record.close)
    } else {
      () => for (record <- records) yield (record.ticker, record.close - record.open)
    }
  }

  val openFunction = getExtractFunction("open", records)
  val closeFunction = getExtractFunction("close", records)
  val deltaFunction = getExtractFunction("delta", records)

  println("*******High Order********")
  println("Open: " + openFunction())
  println("*******High Order********")
  println("Open: " + closeFunction())
  println("*******High Order********")
  println("Open: " + deltaFunction())
}

