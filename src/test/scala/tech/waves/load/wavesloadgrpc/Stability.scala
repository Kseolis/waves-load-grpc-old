package tech.waves.load.wavesloadgrpc

import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import ru.tinkoff.gatling.influxdb.Annotations
import tech.waves.load.mygrpc.grpcProtocol
import tech.waves.load.wavesloadgrpc.scenarios._

class Stability extends Simulation with Annotations {

  setUp(
    new CommonScenario().grpc.inject(
      rampUsersPerSec(0) to intensity.toInt during rampDuration, //разгон
      constantUsersPerSec(intensity.toInt) during stageDuration, //полка
    ),
  ).protocols(grpcProtocol)
    .maxDuration(testDuration) //длительность теста = разгон + полка

}
