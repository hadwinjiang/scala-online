package com.henryjiang.methodsandfunctions

object FunctionLiteralsAndPlaceholders02 extends App {

  var googStockPrices = List(1367.36, 1360.66, 1394.20,
    1393.33, 1404.31, 1419.82, 1429.72)

  googStockPrices.foreach((price: Double) => println(price))

  var googStockPricesGreaterThan1400 = googStockPrices.filter((price: Double) => price > 1400)
  println(googStockPricesGreaterThan1400)

  var googStockPricesSimple = googStockPrices.filter(_ > 1400)
  println(googStockPricesSimple)

  var stockTickersInLowercase = List("goog", "ps", "tsla", "aapl", "msft")
  println(stockTickersInLowercase)
  var stockTickers = stockTickersInLowercase.map(_.toUpperCase)
  println(stockTickers)

  var sayHello = () => println("Hello function literal!")
  val multiplyBy100 = (x: Int) => x * 100
  var addTwoNumbers = (x: Int, y: Int) => x + y
  var addThreeNumbers = (x: Int, y: Int, z: Int) => x + y + z

  sayHello()
  sayHello.apply()
  println(multiplyBy100(7))
  println(multiplyBy100.apply(7))
  println(addTwoNumbers(7, 10))
  println(addTwoNumbers.apply(7, 10))
  println(addThreeNumbers(7, 10, 3))
  println(addThreeNumbers.apply(7, 10, 3))

  println("------------------------------")
  println("sayHello.isInstanceOf[Function0[_]]: " + sayHello.isInstanceOf[Function0[_]])
  println("multiplyBy100.isInstanceOf[Function1[_,_]]: " + multiplyBy100.isInstanceOf[Function1[_, _]])
  println("addTwoNumbers.isInstanceOf[Function2[_,_,_]]: " + addTwoNumbers.isInstanceOf[Function2[_, _, _]])
  println("addThreeNumbers.isInstanceOf[Function3[_,_,_,_]]: " + addThreeNumbers.isInstanceOf[Function3[_, _, _, _]])

}
