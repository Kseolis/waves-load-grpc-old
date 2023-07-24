package feeders

import com.wavesplatform.crypto.base.Base58
import io.gatling.core.Predef.{configuration, csv}

import scala.util.Random

object Feeders {
  val assetsIdCsvFeeder: Seq[Array[Byte]] = csv("assetsId.csv").readRecords
    .map(value => {
      Base58.decode(value("assetId").toString)
    })

  lazy val feeder: Iterator[Map[String, Array[Byte]]] =
    Iterator.continually(Map("assetId" -> assetsIdCsvFeeder(Random.nextInt(assetsIdCsvFeeder.length))))
}
