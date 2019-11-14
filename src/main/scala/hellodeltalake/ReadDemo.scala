package hellodeltalake

import org.apache.spark.sql.SparkSession

object ReadDemo1 extends App {
  val spark = SparkSession.builder
    .appName("Demo1")
    .master("local[4]")
    .getOrCreate()

  val df = spark.read.format("delta").load("/tmp/delta-table")
  df.show()
}
