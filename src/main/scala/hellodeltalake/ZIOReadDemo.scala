package hellodeltalake

import zio._

object ReadDemo1 extends ZIOAppDefault {

  override def run: ZIO[Environment with ZIOAppArgs with Scope, Any, Any] = ???

  private val table = "/tmp/delta-table"

  // program
  //   .provideLayer(SparkModule.layer)
  //   .exitCode

  /*

for {
    spark <- SparkModule()
    _ <-      ZIO.effect{
      val df = spark.read.format("delta").load(table)
      df.show()
    }
val data = spark.range(5, 10)
  data.write
    .format("delta")
    .mode("append")
    .save(table)
   */

}
