

name:= "hello-deltalake"
scalaVersion := "2.12.12"
scalafmtOnCompile := true

libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.0.1"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "3.0.1"
libraryDependencies += "io.delta" %% "delta-core" % "0.7.0"

