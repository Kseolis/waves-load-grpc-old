package tech.waves.load.wavesloadgrpc.feeders

import com.google.protobuf.ByteString
import com.wavesplatform.crypto.base.Base58
import io.gatling.core.Predef.{configuration, csv}
import io.gatling.core.feeder.{BatchableFeederBuilder, Feeder}
import ru.tinkoff.gatling.feeders.RandomDateFeeder

object Feeders {
  val introducedDate: Feeder[String] = RandomDateFeeder("introduced")

  // val message: Expression[AssetRequest] = AssetRequest.of(ByteString.copyFrom(assetId))

  val assetsIdCsvFeeder: Seq[ByteString] = csv("assetsId.csv").readRecords
    .map(value => {
      ByteString.copyFrom(Base58.decode(value.toString))
    })

  val feederBuilder: BatchableFeederBuilder[String] = (
    () => assetsIdCsvFeeder.iterator.map(_.toStringUtf8).toSeq
  )

  println("\n\n\n\n\n\n\n\n\n\n\n\nAssetRequest:   " + assetsIdCsvFeeder + "\n\n\n\n\n\n\n\n\n\n\n\n")

}
