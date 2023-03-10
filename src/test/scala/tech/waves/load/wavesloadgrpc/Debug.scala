package tech.waves.load.wavesloadgrpc

import io.gatling.http.Predef._
import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import tech.waves.load.wavesloadgrpc.scenarios._

class Debug extends Simulation {

  setUp(
    // default = inject(atOnceUsers(1))
    HttpScenario().inject(constantUsersPerSec(100) during 15),
  ).protocols(
    httpProtocol.proxy(Proxy("devnet1-htz-nbg1-1.wavesnodes.com", 6869).httpsPort(6869)),
  ).maxDuration(testDuration)
}