package com.henryjiang.methodsandfunctions

object FunctionLiteralsAndPlaceholders04 extends App {

  var googStockPrices = List(1367.36, 1360.66, 1394.20,
    1393.33, 1404.31, 1419.82, 1429.73)

  def checkPriceGreaterThan1400(price: Double): Boolean = price > 1400

  var googStockPricesGreaterThan1400 = googStockPrices.filter(checkPriceGreaterThan1400)

  println(googStockPricesGreaterThan1400)

  var checkPricesGreaterThan1400Function = checkPriceGreaterThan1400 _

  val googNewStockPricesGreaterThan1400 = googStockPrices.filter(checkPricesGreaterThan1400Function)

  println(googNewStockPricesGreaterThan1400)

  def checkPriceInRange(price: Double, lower: Double, upper: Double): Boolean =
    price >= lower && price <= upper

  val goog03StockPricesInRangeFunction = checkPriceInRange _
  var googStockPricesInRange = googStockPrices.filter(price => goog03StockPricesInRangeFunction(price, 1390, 1410))
  println(googStockPricesInRange)

  val goog02StockPricesInRangeFunction = checkPriceInRange(_: Double, _: Double, 1410)
  googStockPricesInRange = googStockPrices.filter(price => goog02StockPricesInRangeFunction(price, 1390))
  println(googStockPricesInRange)

  val goog01StockPricesInRangeFunction = checkPriceInRange(_: Double, 1390, 1410)
  googStockPricesInRange = googStockPrices.filter(price => goog01StockPricesInRangeFunction(price))
  println(googStockPricesInRange)

}
