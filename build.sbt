ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "unit-testing-scala"
  )

libraryDependencies += "org.scalatest" % "scalatest_2.13" % "3.2.12" % "test" // adding scalatest dependency in test scope since we do not want the scalatest sources
// to be available in the production code when we go to bundle our project