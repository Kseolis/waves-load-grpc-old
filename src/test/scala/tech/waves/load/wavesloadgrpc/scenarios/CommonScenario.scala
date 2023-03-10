package tech.waves.load.wavesloadgrpc.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import tech.waves.load.wavesloadgrpc.cases._

class CommonScenario extends Simulation {
  val grpc: ScenarioBuilder = scenario("Waves grpc scenario")
    .exec(GrpcActions.getFeature)
}
