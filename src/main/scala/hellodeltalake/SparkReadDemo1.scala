package hellodeltalake

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Row

object SparkReadDemo1 extends App {
  val spark = SparkSession
    .builder()
    .config("spark.sql.extensions", "io.delta.sql.DeltaSparkSessionExtension")
    .config(
      "spark.sql.catalog.spark_catalog",
      "org.apache.spark.sql.delta.catalog.DeltaCatalog"
    )
    .appName("Demo1")
    .master("local[4]")
    .getOrCreate()

  val data = spark.read.format("delta").load("/tmp/delta-table")
  val r = data.reduce((r1, r2) => Row(r1.getLong(0) + r2.getLong(0)))
  println(r.get(0))
  // foreach(r => println(r))
}
