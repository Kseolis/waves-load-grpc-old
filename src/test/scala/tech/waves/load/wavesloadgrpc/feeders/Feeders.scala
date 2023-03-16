package tech.waves.load.wavesloadgrpc.feeders

import com.google.protobuf.ByteString
import com.wavesplatform.crypto.base.Base58
import io.gatling.core.Predef.{configuration, csv}
import io.gatling.core.feeder.Feeder
import ru.tinkoff.gatling.feeders.RandomDateFeeder

import scala.util.Random

object Feeders {
  val introducedDate: Feeder[String] = RandomDateFeeder("introduced")

  val assetsIdCsvFeeder: Seq[ByteString] = csv("assetsId.csv").readRecords
    .map(value => {
      ByteString.copyFrom(Base58.decode(value("assetId").toString))
    })


  lazy val feeder: Iterator[Map[String, ByteString]] =
    Iterator.continually(Map("assetId" -> assetsIdCsvFeeder(Random.nextInt(assetsIdCsvFeeder.length))))
}
