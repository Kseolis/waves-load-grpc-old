import io.gatling.core.Predef._
import mygrpc.grpcProtocol
import scenarios.CommonScenario

import scala.concurrent.duration.{DurationInt, FiniteDuration}

class MaxPerformance extends Simulation {

  val rampDuration: FiniteDuration  = 1 minutes
  val stageDuration: FiniteDuration = 3 minutes
  val stagesNumber                  = 6
  val intensity                     = 1500
  val maxDuration: FiniteDuration   = (rampDuration + stageDuration) * stagesNumber

  setUp(
    new CommonScenario().grpc.inject(
      incrementUsersPerSec(300)          // интенсивность на ступень
        .times(6)                             // Количество ступеней
        .eachLevelLasting(stageDuration)             // Длительность полки
        .separatedByRampsLasting(rampDuration)       // Длительность разгона
        .startingFrom(300),              // Начало нагрузки с
    ),
  ).protocols(grpcProtocol).maxDuration(maxDuration) // общая длительность теста
}
