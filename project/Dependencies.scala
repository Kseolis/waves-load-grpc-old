import sbt.Keys.libraryDependencies
import sbt._

object Dependencies {
  lazy val gatling: Seq[ModuleID] = Seq(
    "io.gatling.highcharts" % "gatling-charts-highcharts",
    "io.gatling"            % "gatling-test-framework",
  ).map(_ % "3.9.2" % Test)

  lazy val gelf: Seq[ModuleID]             = Seq("de.siegmar" % "logback-gelf" % "4.0.2")
  lazy val gatlingPicatinny: Seq[ModuleID] = Seq("ru.tinkoff" %% "gatling-picatinny" % "0.13.0")
  lazy val janino: Seq[ModuleID]           = Seq("org.codehaus.janino" % "janino" % "3.1.9")
  lazy val gatlingGrpc: Seq[ModuleID] = Seq("com.github.phisgr" % "gatling-grpc" % "0.15.1" % "test")
  lazy val grpcDeps: Seq[ModuleID] = Seq(
    "io.grpc" % "grpc-netty" % scalapb.compiler.Version.grpcJavaVersion,
    "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion,
    "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"
  )
  lazy val wavesProto: Seq[ModuleID] = Seq("com.wavesplatform" % "protobuf-schemas" % "1.4.3" classifier "protobuf-src" intransitive())
}
