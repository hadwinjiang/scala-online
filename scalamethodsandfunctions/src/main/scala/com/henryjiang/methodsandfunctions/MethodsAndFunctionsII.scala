package com.henryjiang.methodsandfunctions

object MethodsAndFunctionsII extends App {

  var data = Array("PS", "MSFT", "GOOG", "AAPL", "TSLA")

  def existsMethod(ticker: String): Boolean = data.contains(ticker)

  val existFunction = (ticker: String) => data.contains(ticker)

  var exists = existsMethod _

  println("Does PS exist (method): " + existsMethod("PS"))
  println("Does TM exist (function): " + existFunction("TM"))

  println("Does GOOG exist (function): " + exists("GOOG"))
  // javap MethodsAndFunctionsII$.class
}
