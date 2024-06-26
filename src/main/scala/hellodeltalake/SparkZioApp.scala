package hellodeltalake

import zio._

import org.apache.spark.sql.SparkSession

object SparkModule {

  trait Service {
    def spark: SparkSession
  }

  object Test extends Service {
    lazy val spark: SparkSession = SparkSession.builder
      .config("spark.sql.extensions", "io.delta.sql.DeltaSparkSessionExtension")
      .config(
        "spark.sql.catalog.spark_catalog",
        "org.apache.spark.sql.delta.catalog.DeltaCatalog"
      )
      .appName("Demo1")
      .master("local[4]")
      .getOrCreate()
  }

  // def layer: ZLayer[ZEnv, Nothing, SparkModule] = ZLayer.fromServiceM { _ =>
  //   ZIO.succeed(Test)
  // }
}
