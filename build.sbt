ThisBuild / scalaVersion := "2.13.6"

ThisBuild / scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-language:higherKinds",
  "-Ymacro-annotations"
)

ThisBuild / updateOptions := updateOptions.value.withGigahorse(false)

ThisBuild / name := "store"

ThisBuild / version := "0.1"

ThisBuild / idePackagePrefix := Some("fr.extia.store")

lazy val domain = (project in file("domain"))
  .settings(
    libraryDependencies ++= Dependencies.circe,
    libraryDependencies ++= Dependencies.log,
    libraryDependencies ++= Dependencies.scalaTest.map(_ % Test)
  )

lazy val `store-api` = (project in file("applications/store-api"))
  .dependsOn(
    domain % "test->test;compile->compile"
  )
  .settings(
    libraryDependencies ++= Dependencies.tapir,
    name := "store-api"
  )

addCommandAlias(
  "run",
  "; compile ; project store-api ; runMain fr.extia.store.AppServer"
)
