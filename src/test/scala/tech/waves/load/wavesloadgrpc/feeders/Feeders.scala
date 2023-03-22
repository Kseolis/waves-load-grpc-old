package tech.waves.load.wavesloadgrpc.feeders

import com.wavesplatform.crypto.base.Base58
import io.gatling.core.Predef.{configuration, csv}
import io.gatling.core.feeder.Feeder
import ru.tinkoff.gatling.feeders.RandomDateFeeder

import scala.util.Random

object Feeders {
  val introducedDate: Feeder[String] = RandomDateFeeder("introduced")

  val assetsIdCsvFeeder: Seq[Array[Byte]] = csv("assetsId.csv").readRecords
    .map(value => {
      Base58.decode(value("assetId").toString)
    })

  lazy val feeder: Iterator[Map[String, Array[Byte]]] =
    Iterator.continually(Map("assetId" -> assetsIdCsvFeeder(Random.nextInt(assetsIdCsvFeeder.length))))
}
