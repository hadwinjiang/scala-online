package com.henryjiang.methodsandfunctions

object HigherOrderFunctions01 extends App {

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

  val extractHighPrice = (records: Vector[StockTicker]) => {
    for (record <- records) yield (record.ticker, record.high)
  }

  val extractOpenPrice = (records: Vector[StockTicker]) => {
    for (record <- records) yield (record.ticker, record.open)
  }

  val extractClosePrice = (records: Vector[StockTicker]) => {
    for (record <- records) yield (record.ticker, record.close)
  }

  val extractPriceDelta = (records: Vector[StockTicker]) => {
    for (record <- records) yield (record.ticker, record.close - record.open)
  }

  println("***************")
  println("Open: " + extractOpenPrice(records))
  println("***************")
  println("Close: " + extractClosePrice(records))
  println("***************")
  println("Delta: " + extractPriceDelta(records))

  val extractInfo = (records: Vector[StockTicker],
                     extractFunction: Vector[StockTicker] => Vector[(String, Float)]) => {
    extractFunction(records)
  }
  println("*******High Order********")
  println("Open: " + extractInfo(records, extractOpenPrice))
  println("*******High Order********")
  println("Open: " + extractInfo(records, extractClosePrice))
  println("*******High Order********")
  println("Open: " + extractInfo(records, extractPriceDelta))
}

