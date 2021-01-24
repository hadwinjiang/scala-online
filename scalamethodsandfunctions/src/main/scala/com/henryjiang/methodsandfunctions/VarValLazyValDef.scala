package com.henryjiang.methodsandfunctions

object VarValLazyValDef extends App {

  var stockPrice = 14
  var volume = 100

  volume = 1000
  var finalValue = stockPrice * volume

  println(s"Final value is $finalValue")

  var data = {
    println("Array is initialized")
    Array(
      "MSFT", "GOOG", "TM"
    )
  }

  println("Before accessing data")
  data.foreach(println)

  println("--------------")
  data.foreach(println)

  def dStockPrice: Int = {
    println("Returning stock price")
    14
  }

  def dVolume: Int = {
    println("Returning volume")
    100
  }

  //  def dFinalValue: Int = dStockPrice * dVolume
  def dFinalValue: String = (dStockPrice * dVolume).toString

  println(s"Final value is $dFinalValue")

  println("-----------------------")

  def dFinalValueAgain: String = (dStockPrice * dVolume).toString

  println(s"Final value is $dFinalValueAgain")

}
