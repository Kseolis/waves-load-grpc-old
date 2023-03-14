package tech.waves.load.wavesloadgrpc

import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import ru.tinkoff.gatling.influxdb.Annotations
import tech.waves.load.mygrpc.grpcProtocol
import tech.waves.load.wavesloadgrpc.scenarios._

class MaxPerformance extends Simulation with Annotations {

  setUp(
    new CommonScenario().grpc.inject(
      incrementUsersPerSec(300) // интенсивность на ступень
        .times(stagesNumber) // Количество ступеней
        .eachLevelLasting(stageDuration) // Длительность полки
        .separatedByRampsLasting(rampDuration) // Длительность разгона
        .startingFrom(300), // Начало нагрузки с
    ),

  ).protocols(grpcProtocol)
    .maxDuration(testDuration) // общая длительность теста

}
