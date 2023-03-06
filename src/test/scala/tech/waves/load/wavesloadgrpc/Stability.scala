package tech.waves.load.wavesloadgrpc

import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import ru.tinkoff.gatling.influxdb.Annotations
import tech.waves.load.wavesloadgrpc.scenarios._

class Stability extends Simulation with Annotations {

  setUp(
    HttpScenario().inject(
      // разгон
      rampUsersPerSec(0) to intensity.toInt during rampDuration,
      // полка
      constantUsersPerSec(intensity.toInt) during stageDuration,
    ),
  ).protocols(
    httpProtocol,
    // длительность теста = разгон + полка
  ).maxDuration(testDuration)

}
