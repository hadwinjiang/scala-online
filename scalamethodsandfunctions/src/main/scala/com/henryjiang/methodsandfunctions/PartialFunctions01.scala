package com.henryjiang.methodsandfunctions

object PartialFunctions01 {

  def main(args: Array[String]): Unit = {
    //    val divide64By = (x: Int) => 64 / x
    //    println(divide64By(8))
    //    println(divide64By(0))

    val divide64By = new PartialFunction[Int, Int] {
      def apply(x: Int): Int = 64 / x

      def isDefinedAt(x: Int): Boolean = x != 0
    }

    println("Defined at 11: " + divide64By.isDefinedAt(11))
    println("Defined at 0: " + divide64By.isDefinedAt(0))

    println("Dived 64 by 3: " + (if (divide64By.isDefinedAt(3)) divide64By(3)))
  }

}
