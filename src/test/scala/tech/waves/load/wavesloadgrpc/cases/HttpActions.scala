package tech.waves.load.wavesloadgrpc.cases

import io.gatling.http.Predef._
import io.gatling.core.Predef._

object HttpActions {
  val getAddress = http("getAddresses")
    .get("/addresses")
    .check(status is 200)
}
