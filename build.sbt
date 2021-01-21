name := "hello-deltalake"
scalaVersion := "2.12.12"
scalafmtOnCompile := true

libraryDependencies ++= Seq("spark-sql", "spark-streaming").map(d =>
  "org.apache.spark" %% d % "3.0.1" exclude ("org.slf4j", "slf4j-log4j12")
)

libraryDependencies += "io.delta" %% "delta-core" % "0.7.0"
libraryDependencies += "dev.zio" %% "zio" % "1.0.3"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"
