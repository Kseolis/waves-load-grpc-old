import sbt._

object Dependencies {
  lazy val gatling: Seq[ModuleID] = Seq(
    "io.gatling.highcharts" % "gatling-charts-highcharts",
    "io.gatling"            % "gatling-test-framework",
  ).map(_ % "3.9.2" % Test)

  lazy val gelf: Seq[ModuleID]              = Seq("de.siegmar" % "logback-gelf" % "4.0.2")
  lazy val gatlingPicatinny: Seq[ModuleID]  = Seq("ru.tinkoff" %% "gatling-picatinny" % "0.13.0")
  lazy val janino: Seq[ModuleID]            = Seq("org.codehaus.janino" % "janino" % "3.1.9")
  lazy val gatlingGrpc: Seq[ModuleID]       = Seq("com.github.phisgr" % "gatling-grpc" % "0.16.0" % "test")
  lazy val grpcDeps: Seq[ModuleID]          = Seq(
    "io.grpc"               % "grpc-netty"           % scalapb.compiler.Version.grpcJavaVersion,
    "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion,
    "com.thesamet.scalapb" %% "scalapb-runtime"      % scalapb.compiler.Version.scalapbVersion % "protobuf",
  )
  lazy val wavesProto: Seq[ModuleID]        = Seq(
    // We need only protobuf definitions
    ("com.wavesplatform" % "protobuf-schemas" % "1.4.3" classifier "protobuf-src") % "protobuf" excludeAll (
      // Because we use runtime from ScalaPB
      ExclusionRule("io.grpc", "grpc-netty-shaded"),
      ExclusionRule("io.grpc", "grpc-protobuf"),
      ExclusionRule("io.grpc", "grpc-stub"),
      // ExclusionRule("com.google.protobuf", "protobuf-java") // is required, otherwise we can't find google entities
    ),
  )
  lazy val wavesTransactions: Seq[ModuleID] = Seq(
    "com.wavesplatform" % "waves-transactions" % "1.2.3" excludeAll ExclusionRule("com.wavesplatform", "protobuf-schemas"),
  )
}