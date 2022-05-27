package hellodeltalake

import zio._

object ReadDemo1 extends App {

  private val table = "/tmp/delta-table"

  val program: ZIO[SparkModule.SparkModule, Nothing, Unit] = ???

  override def run(args: List[String]): URIO[ZEnv, ExitCode] = ???
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
