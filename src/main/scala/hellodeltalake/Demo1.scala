package hellodeltalake

import org.apache.spark.sql.SparkSession

object Demo1 extends App {
  val spark = SparkSession.builder
    .appName("Demo1")
    .master("local[4]")
    .getOrCreate()

  val data = spark.range(0, 5)

  data.write.format("delta").save("/tmp/delta-table")
}
