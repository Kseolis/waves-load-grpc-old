package scenarios

import cases.GrpcActions
import feeders.Feeders.feeder
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

class CommonScenario {
  val grpc: ScenarioBuilder = scenario("Waves grpc scenario")
    .feed(feeder)
    .exec(GrpcActions.getFeature)
}
