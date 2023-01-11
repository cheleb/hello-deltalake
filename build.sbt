name := "hello-deltalake"
scalaVersion := "2.13.10"
scalafmtOnCompile := true

libraryDependencies ++= Seq("spark-sql", "spark-streaming").map(d =>
  "org.apache.spark" %% d % "3.3.1" exclude ("org.slf4j", "slf4j-log4j12")
)

libraryDependencies += "io.delta" %% "delta-core" % "2.2.0"
libraryDependencies += "io.delta" %% "delta-standalone" % "0.6.0"
libraryDependencies += "com.google.guava" % "guava" % "31.1-jre"
libraryDependencies += "dev.zio" %% "zio" % "2.0.5"
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
