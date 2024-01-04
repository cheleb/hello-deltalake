name := "hello-deltalake"
scalaVersion := "2.13.12"
scalafmtOnCompile := true

libraryDependencies ++= Seq("spark-sql", "spark-streaming").map(d =>
  "org.apache.spark" %% d % "3.4.0" exclude ("org.slf4j", "slf4j-log4j12")
)

libraryDependencies += "io.delta" %% "delta-core" % "2.4.0"
libraryDependencies += "io.delta" %% "delta-standalone" % "0.6.0"
libraryDependencies += "com.google.guava" % "guava" % "33.0.0-jre"
libraryDependencies += "dev.zio" %% "zio" % "2.0.17"
//libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.11"
//libraryDependencies += "org.slf4j" % "log4j-over-slf4j" % "1.7.36"

run / javaOptions ++= Seq("java.util.concurrent.atomic",
                          "java.lang",
                          "java.util",
                          "java.util.concurrent",
                          "java.lang.reflect",
                          "java.net",
                          "java.nio",
                          "sun.nio.ch"
).map(p => s"--add-opens=java.base/$p=ALL-UNNAMED")
run / fork := true
