package tech.waves.load.wavesloadgrpc

import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import ru.tinkoff.gatling.influxdb.Annotations
import tech.waves.load.wavesloadgrpc.scenarios._

class MaxPerformance extends Simulation with Annotations {

  setUp(
    HttpScenario().inject(
      // интенсивность на ступень
      incrementUsersPerSec((intensity / stagesNumber).toInt)
        // Количество ступеней
        .times(stagesNumber)
        // Длительность полки
        .eachLevelLasting(stageDuration)
        // Длительность разгона
        .separatedByRampsLasting(rampDuration)
        // Начало нагрузки с
        .startingFrom(0),
    ),
  ).protocols(
    httpProtocol,
    // общая длительность теста
  ).maxDuration(testDuration)

}
