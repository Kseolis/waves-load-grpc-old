package tech.waves.load.wavesloadgrpc

import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import tech.waves.load.mygrpc.grpcProtocol
import tech.waves.load.wavesloadgrpc.scenarios._

class Debug extends Simulation {

  setUp(
    new CommonScenario().grpc // запускаем наш сценарий
      .inject(constantUsersPerSec(100) during 15),

  ).protocols(grpcProtocol) // работа будет проходить по протоколу, который описан в grpcProtocol
    .maxDuration(testDuration)
}