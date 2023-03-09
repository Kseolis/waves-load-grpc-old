import Dependencies._

enablePlugins(GatlingPlugin)

lazy val root = (project in file("."))
  .settings(
    inThisBuild(
      List(
        organization := "tech.waves.load",
        scalaVersion := "2.13.8",
        version      := "0.1.0",
      ),
    ),
    name := "waves-load-grpc",
    libraryDependencies ++= gatling,
    libraryDependencies ++= gelf,
    libraryDependencies ++= gatlingPicatinny,
    libraryDependencies ++= janino,
    libraryDependencies ++= gatlingGrpc,
    libraryDependencies ++= grpcDeps,
    libraryDependencies ++= wavesProto,
    Test / PB.targets := Seq(
      scalapb.gen() -> (Test / sourceManaged).value
    ),
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
    ),

    inConfig(Compile)(
      Seq(
        PB.targets += scalapb.gen(flatPackage = true) -> sourceManaged.value,
        PB.protoSources += PB.externalIncludePath.value,
        PB.generate / includeFilter := { (f: File) =>
          (** / "waves" / "*.proto").matches(f.toPath)
        }
      )
    ),
  )
