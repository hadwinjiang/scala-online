package com.henryjiang.methodsandfunctions

object FunctionLiteralsAndPlaceholders extends App {

  var multiplyBy = (x: Int) => x * 100
  println(multiplyBy(3))
  println(multiplyBy(7))

  multiplyBy = (x: Int) => x * 200
  println("---------- change the multiplyBy ----------")
  println(multiplyBy(3))

  var calculateResult = (x: Int, y: Int) => {
    val sum = x + y
    val diff = x - y
    var product = x * y
    var quotient = x / y
    (sum, diff, product, quotient)
  }
  println("---------- result of 10 and 5 ----------")
  println(calculateResult(10, 5))

  println("---------- result of 40 and 8 ----------")
  println(calculateResult(40, 8))
}
