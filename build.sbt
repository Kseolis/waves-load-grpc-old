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

    libraryDependencies += "com.wavesplatform" % "protobuf-schemas" % "1.4.4-71-SNAPSHOT" classifier "protobuf-src" intransitive(),
    inConfig(Compile)(Seq(
      PB.protoSources in Compile := Seq(PB.externalIncludePath.value),
      includeFilter in PB.generate := new SimpleFileFilter((f: File) => f.getName.endsWith(".proto") && f.getParent.endsWith("waves")),
      PB.targets += scalapb.gen(flatPackage = true) -> sourceManaged.value
    )),
    resolvers ++= Resolver.sonatypeOssRepos("snapshots") ++ Seq(Resolver.mavenLocal),
  )
