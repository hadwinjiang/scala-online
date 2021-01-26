package com.emr602.spark

import org.apache.spark.{SparkConf, SparkContext}

object SparkFileDemo {

  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("Spark File Access")
    val spark = new SparkContext(conf)

    println("Spark File Access Started")

    //    var file = spark.textFile("s3://henryjiang-nrt-0605/spark/jars/sample.txt")
    var file = spark.textFile(args(0))
    var counts = file.flatMap(line => line.split(" "))
      .map(x=> (x,1)).reduceByKey(_+_)
    counts.saveAsTextFile("s3://henryjiang-nrt-0605/spark/jars/result")

    println("Spark File Access Finished")

    spark.stop()
  }


}
