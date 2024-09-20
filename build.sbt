name := "hello-deltalake"
scalaVersion := "2.13.15"
scalafmtOnCompile := true

inThisBuild(
  Seq(
  run / javaOptions ++= Seq("java.util.concurrent.atomic",
                          "java.lang",
                          "java.util",
                          "java.util.concurrent",
                          "java.lang.reflect",
                          "java.net",
                          "java.nio",
                          "sun.nio.ch"
)   .map(p => s"--add-opens=java.base/$p=ALL-UNNAMED"),
   run / fork := true
  )
)

libraryDependencies ++= Seq("spark-sql", "spark-streaming").map(d =>
  "org.apache.spark" %% d % "3.4.0" exclude ("org.slf4j", "slf4j-log4j12")
)

libraryDependencies += "io.delta" %% "delta-core" % "2.4.0"
libraryDependencies += "io.delta" %% "delta-standalone" % "3.2.0"
libraryDependencies += "com.google.guava" % "guava" % "33.2.1-android"
libraryDependencies += "dev.zio" %% "zio" % "2.1.6"
//libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.11"
//libraryDependencies += "org.slf4j" % "log4j-over-slf4j" % "1.7.36"


val scala3Test = (project in file("scala3-test"))
  .settings(
    name := "scala3-test",
    scalaVersion := "3.4.2",
    libraryDependencies += "org.apache.hadoop" % "hadoop-common" % "3.4.0",
    libraryDependencies += "org.apache.hadoop" % "hadoop-mapreduce-client-core" % "3.4.0",
    libraryDependencies += "io.delta" % "delta-core_2.13" % "2.4.0",
    libraryDependencies += "io.delta" % "delta-standalone_2.13" % "3.2.0",
    libraryDependencies += "org.xerial.snappy" % "snappy-java" % "1.1.10.5"
  )
