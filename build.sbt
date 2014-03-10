// -*- mode: scala -*-
import play.Project._

name := "openreviews"

organization := "com.github.openreviews"

version := "0.1-SNAPSHOT"

libraryDependencies ++= Seq(
  // Select Play modules
  //jdbc,      // The JDBC connection pool and the play.api.db API
  //anorm,     // Scala RDBMS Library
  //javaJdbc,  // Java database API
  //javaEbean, // Java Ebean plugin
  //javaJpa,   // Java JPA plugin
  //filters,   // A set of built-in filters
  javaCore,  // The core Java API
  "org.webjars" %% "webjars-play" % "2.2.0",
  "org.webjars" % "bootstrap" % "3.1.1",
  "org.mongodb" % "mongo-java-driver" % "2.11.4",
  "org.jongo" % "jongo" % "1.0"
)


playJavaSettings

val dependenciesUrl = TaskKey[Seq[String]]("dependenciesUrl", "List dependencies urls")

dependenciesUrl <<= (update in Runtime) map {(u) =>
 u.configuration("runtime") match {
   case Some(conf) => conf.modules.flatMap(_.artifacts.map{case (art,_) => art.url.map(_.toString).getOrElse("No URL")})
   case None => List("No such configuration")
 }
}
