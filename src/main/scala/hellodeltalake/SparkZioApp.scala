package hellodeltalake

import zio._

import org.apache.spark.sql.SparkSession


object SparkModule {
    type SparkModule = Has[SparkModule.Service]

     def apply(): ZIO[SparkModule, Throwable, SparkSession] = ZIO.access[SparkModule](_.get.spark)

    trait Service {
        def spark: SparkSession
    }

    object Test extends Service {
        lazy val spark: SparkSession = SparkSession.builder
    .appName("Demo1")
    .master("local[4]")
    .getOrCreate()
    }

    def layer: ZLayer[ZEnv, Nothing, SparkModule] = ZLayer.fromServiceM{
_ =>
            ZIO.succeed(Test)
    }
}