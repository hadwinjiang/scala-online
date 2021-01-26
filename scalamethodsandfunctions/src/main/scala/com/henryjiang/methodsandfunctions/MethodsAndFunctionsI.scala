package com.henryjiang.methodsandfunctions

object MethodsAndFunctionsI extends App {

  var data = Array("PS", "MSFT", "GOOG", "AAPL", "TLSA")

  def getNumRowsMethod(): Int = data.length

  var getNumRowFunction = () => data.length

  println("Total number of rows (method): " + getNumRowsMethod())
  println("Total number of rows (function): " + getNumRowFunction())

  def getNumRowsMethodNew: Int = data.length

  println("Total number of rows (method): " + getNumRowsMethodNew)

  println(getNumRowsMethodNew.getClass)
  println(getNumRowFunction.getClass)
  println(getNumRowsMethod.getClass)

  println(getNumRowFunction.apply())

  // traits is similar as interface in Java
  println(getNumRowFunction.isInstanceOf[Function0[_]])
}
