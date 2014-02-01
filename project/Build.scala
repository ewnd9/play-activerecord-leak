import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "app"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "com.github.aselab" %% "scala-activerecord" % "0.2.4-SNAPSHOT",
    "com.github.aselab" %% "scala-activerecord-play2" % "0.2.4-SNAPSHOT",
    jdbc,
    anorm
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    resolvers += Resolver.sonatypeRepo("snapshots")
  )




}
