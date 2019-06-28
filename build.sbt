name := "scalaPlay"

version := "0.1"

scalaVersion := "2.13.0"

// https://mvnrepository.com/artifact/com.typesafe.play/play-json
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.7.4"

scalacOptions += "-Ymacro-annotations"