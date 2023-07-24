import io.gatling.core.Predef._
import io.gatling.recorder.internal.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration.minutes
import mygrpc.grpcProtocol
import scenarios.CommonScenario

import scala.concurrent.duration.{DurationInt, FiniteDuration}

class Stability extends Simulation {

  val rampDuration: FiniteDuration = 1 minutes
  val stageDuration: FiniteDuration = 3 minutes
  val stagesNumber = 6
  val intensity = 1500
  val duration: FiniteDuration = (rampDuration + stageDuration) * stagesNumber

  setUp(
    new CommonScenario().grpc.inject(
      rampUsersPerSec(0) to intensity during rampDuration, //разгон
      constantUsersPerSec(intensity) during stageDuration, //полка
    ),
  ).protocols(grpcProtocol)
    .maxDuration(duration) //длительность теста = разгон + полка
}
