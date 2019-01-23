import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.github.hayasshi"
ThisBuild / organizationName := "hayasshi"

lazy val root = (project in file("."))
  .settings(
    name := "refined-sample",
    libraryDependencies += refined
  )
  .enablePlugins(JmhPlugin)

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
