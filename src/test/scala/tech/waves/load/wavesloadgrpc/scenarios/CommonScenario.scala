package tech.waves.load.wavesloadgrpc.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import tech.waves.load.wavesloadgrpc.cases._
import tech.waves.load.wavesloadgrpc.feeders.Feeders.feederBuilder

class CommonScenario {
  val grpc: ScenarioBuilder = scenario("Waves grpc scenario")
    .exec(GrpcActions.getFeature)
    .feed(feederBuilder)
}
