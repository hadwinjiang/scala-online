package com.henryjiang.methodsandfunctions

object PartialFunctions03 extends App {

  var readFinanceData = () => {
    val source = io.Source.fromFile("src/main/resources/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockTicker(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5))
  }

  var data = readFinanceData()

  //  var printStockTickers: PartialFunction[String, Unit] = new PartialFunction[String, Unit] {
  //    var recordedTickers = List("MSFT", "GOOG", "TTM", "TM", "DB", "BNS")
  //
  //    def apply(ticker: String):Unit = {
  //      for (lines <- data.filter(_.ticker == ticker)) {
  //        println(s"Date: ${lines.date} Ticker: ${lines.ticker} Close: ${lines.close}")
  //      }
  //    }
  //
  //    def isDefinedAt(ticker: String): Boolean = recordedTickers.contains(ticker)
  //  }
  var printStockTickers: PartialFunction[String, Unit] = {
    case ticker: String if List("MSFT", "GOOG", "TTM", "TM", "DB", "BNS").contains(ticker) =>
      for (lines <- data.filter(_.ticker == ticker)) {
        println(s"Date: ${lines.date} Ticker: ${lines.ticker} Close: ${lines.close}")
      }
  }
  if (printStockTickers.isDefinedAt("MSFT")) printStockTickers("MSFT")

  println("***************")

  List("DB", "TTM") map {
    printStockTickers
  }

  //  List("DB", "TSLA") map {
  //    printStockTickers
  //  }

  println("***************")

  List("DB", "TSLA") collect {
    printStockTickers
  }

  println("***************")

  var printTechStocks: PartialFunction[String, Unit] = {
    case ticker: String if List("MSFT", "GOOG").contains(ticker) =>
      for (lines <- data.filter(_.ticker == ticker)) {
        println(s"Date: ${lines.date} Ticker: ${lines.ticker} Close: ${lines.close}")
      }
  }

  var printMotorStocks: PartialFunction[String, Unit] = {
    case ticker: String if List("TM", "TTM").contains(ticker) =>
      for (lines <- data.filter(_.ticker == ticker)) {
        println(s"Date: ${lines.date} Ticker: ${lines.ticker} Close: ${lines.close}")
      }
  }

  var printTechOrMotorStocks = printTechStocks orElse printMotorStocks

  printTechOrMotorStocks("TM")
  printTechOrMotorStocks("MSFT")

}
