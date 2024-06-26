package hellodeltalake

import org.apache.spark.sql.SparkSession

object SparkWriteDemo1 extends App {
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

  val data = spark.range(0, 50000)

  data.write.format("delta").save("/tmp/delta-table")
}
