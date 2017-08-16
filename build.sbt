lazy val commonSettings = Seq(
  version := "1.0",
  scalaVersion := "2.12.2",
  libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.3" % "test",
    libraryDependencies += "org.mindrot" % "jbcrypt" % "0.3m"
)

lazy val Inventory = (project in file("Inventory"))
  .settings(
    commonSettings
  )

lazy val checkout = (project in file("checkout"))
  .settings(
    commonSettings
  )
lazy val account = (project in file("account"))
  .dependsOn(Inventory)
  .settings(
    commonSettings
  )


lazy val api = (project in file("api"))
  .settings(
    commonSettings
  )


lazy val root = (project in file(".")).
  aggregate(api , account , checkout , Inventory ).settings(
  commonSettings)