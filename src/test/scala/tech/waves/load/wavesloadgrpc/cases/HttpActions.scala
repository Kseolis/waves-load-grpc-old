package tech.waves.load.wavesloadgrpc.cases

import io.gatling.http.Predef._
import io.gatling.core.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object  HttpActions {
  val getAddress: HttpRequestBuilder = http("getAddresses")
    .get("/addresses")
    .check(status is 200)
}
