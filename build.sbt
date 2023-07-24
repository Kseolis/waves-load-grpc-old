import Dependencies.*

Global / onChangedBuildSource := ReloadOnSourceChanges

enablePlugins(GatlingPlugin)

lazy val root = (project in file("."))
  .settings(
    inThisBuild(
      List(
        organization := "tech.waves.load",
        scalaVersion := "2.13.8",
        version      := "0.1.1",
      ),
    ),
    name := "waves-load-grpc",
    libraryDependencies ++= gatling ++ gelf ++ razem ++ janino ++ gatlingGrpc ++ grpcDeps ++ wavesProto ++ wavesTransactions,
    scalacOptions ++= Seq(
      "-encoding",
      "UTF-8",
      "-Xfatal-warnings",
      "-deprecation",
      "-feature",
      "-unchecked",
      "-language:implicitConversions",
      "-language:higherKinds",
      "-language:existentials",
      "-language:postfixOps",
      "-Wconf:cat=deprecation&site=com.google.protobuf.descriptor.FileOptions.*:s",
      "-Wconf:cat=deprecation&site=com.wavesplatform.api.grpc.*:s",                                // Ignore gRPC warnings
      "-Wconf:cat=deprecation&site=com.wavesplatform.protobuf.transaction.InvokeScriptResult.*:s", // Ignore deprecated argsBytes
      "-Wconf:cat=deprecation&site=com.wavesplatform.state.InvokeScriptResult.*:s",
    ),
    inConfig(Compile)(
      Seq(
        doc / sources                := Seq.empty,
        packageDoc / publishArtifact := false,
        PB.deleteTargetDirectory     := false,
        PB.protoSources += PB.externalIncludePath.value,
        PB.targets                   := Seq(
          PB.gens.java                                            -> (Compile / sourceManaged).value, // Otherwise we get compilation errors
          scalapb.gen(flatPackage = true, javaConversions = true) -> (Compile / sourceManaged).value / "scalapb",
        ),
      ),
    ),
  )