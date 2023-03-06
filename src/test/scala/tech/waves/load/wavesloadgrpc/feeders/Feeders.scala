package tech.waves.load.wavesloadgrpc.feeders

import io.gatling.core.feeder.Feeder
import ru.tinkoff.gatling.feeders.RandomDateFeeder

object Feeders {

  val introducedDate: Feeder[String] = RandomDateFeeder("introduced")

}
