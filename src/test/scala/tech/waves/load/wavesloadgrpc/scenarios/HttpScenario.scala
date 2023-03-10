package tech.waves.load.wavesloadgrpc.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import tech.waves.load.wavesloadgrpc.cases._

object HttpScenario {
  def apply(): ScenarioBuilder = new HttpScenario().scn
}

class HttpScenario extends Simulation {
  val scn: ScenarioBuilder = scenario("Waves getAddress Node Scenario")
    .exec(HttpActions.getAddress)
}
