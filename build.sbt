name := "hello-deltalake"
scalaVersion := "2.12.14"
scalafmtOnCompile := true

libraryDependencies ++= Seq("spark-sql", "spark-streaming").map(d =>
  "org.apache.spark" %% d % "3.1.2" exclude ("org.slf4j", "slf4j-log4j12")
)

libraryDependencies += "io.delta" %% "delta-core" % "1.0.0"
libraryDependencies += "com.google.guava" % "guava" % "30.1.1-jre"
libraryDependencies += "dev.zio" %% "zio" % "1.0.9"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"
libraryDependencies += "org.slf4j" % "log4j-over-slf4j" % "1.7.31"

run / javaOptions ++= Seq("java.util.concurrent.atomic",
                          "java.lang",
                          "java.util",
                          "java.util.concurrent",
                          "java.lang.reflect",
                          "java.net",
                          "java.nio"
).map(p => s"--add-opens=java.base/$p=ALL-UNNAMED")
run / fork := true
